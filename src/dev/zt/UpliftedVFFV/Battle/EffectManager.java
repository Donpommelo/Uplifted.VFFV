package dev.zt.UpliftedVFFV.Battle;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.statusEffects.Invuln;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class EffectManager {
	
	public ArrayList<Schmuck> team;
	public ArrayList<Schmuck> enemy;
	public GameState gs;
	public BattleState bs;
	
	public EffectManager(Game g, BattleState bs, GameState gs){
		this.gs=gs;
		this.bs=bs;	
	}
		
	//Function called when hp is changed in battle. (Except in the case of Pure Damage)
	//if the input hp is negative, that means damage is being done.
	public void hpChange(int hp, Schmuck perp, Schmuck vic, int elem){
		
		//finalDamage is the number that will be returned at the end.
		int finalDamage = hp;
		
		//If damage is being dealt, Damage Amplification and Resistance modify it.
		if(finalDamage < 0){
			finalDamage += (int)(perp.getDamAmp()*hp);
			finalDamage -= (int)(vic.getDamRes()*hp);
			
			//If elemental damage is being dealt, elemental alignment anf resistance are calculated.
			if(elem != 6){
				finalDamage -= (int)(hp*(double)(vic.getBonusStats()[elem+19]/100));
				finalDamage += (int)(hp*(double)(perp.getBuffedElemPoints()[elem]/100));
			}	
		}
		else{
			
			//Elementally aligned healing is also modified by alignment
			if( elem != 6){
				finalDamage += (int)(hp*(double)(perp.getBuffedElemPoints()[elem]/100));			
			}
		}
		
		//Damage variance is calculated
		finalDamage += (int)((finalDamage)*(Math.random() * 2 * (perp.getDamageVariance()+.1)-(perp.getDamageVariance()+.1)));
		
		//Elements
/*		String element = "";
		switch(elem){
		case 0:
			element = "Red";
			break;
		case 1:
			element = "Blue";
			break;
		case 2:
			element = "Green";
			break;
		case 3:
			element = "Yellow";
			break;
		case 4:
			element = "Purple";
			break;
		case 5:
			element = "Void";
			break;
		case 6:
			element = "";
			break;
		}*/
		
		//Extra check to ensure that the target is not incapacitated.
		if(!bs.bp.stm.checkStatus(vic, new incapacitate(vic))){
			if(finalDamage > 0){
				
				//perp's heal-give effects and target's heal-receive effects activate.
				finalDamage = perp.statusProcTime(15, bs, null, vic, finalDamage, elem, true, null);
				finalDamage = vic.statusProcTime(16, bs, null, perp, finalDamage, elem, true, null);
				
				//Final healing amount is finally modified by the target's regen bonus.
				finalDamage *= (1+vic.getRegenBonus());
				vic.tempStats[0]+=finalDamage;
				bs.bs.flash(vic, 120, -finalDamage, elem);
			}
			
			else{
				
				//perp's damage-dealt effects and target's on-damage effects activate.
				finalDamage = perp.statusProcTime(13, bs, null, vic, finalDamage, elem, true, null);
				finalDamage = vic.statusProcTime(14, bs, null, perp, finalDamage, elem, true, null);

				//Display text and do damage.
//				bs.bp.bt.addScene(vic.getName()+" received "+-finalDamage+" "+element+" damage!");
				vic.tempStats[0]+=finalDamage;
				bs.bs.flash(vic, 120, -finalDamage, elem);

			}
			
			//After hp change, check if target is incapacitated
			if(vic.tempStats[0]<=0){
				
				//If so, set Hp to 0 and apply perp's on-kill effects and vic's on-death effects.
				vic.tempStats[0]=0;
				
				perp.statusProcTime(19, bs, null, vic, 0, 0, true, null);
				vic.statusProcTime(20, bs, null, perp, 0, 0, true, null);
				
				//Add incapacitate status and remove all of the target's actions from the TOQ
				bs.bp.stm.addStatus(vic, new incapacitate(perp));
				for(Action a : bs.bp.TurnOrderQueue){
					if(a!=null){
						if(a.user==vic){
							bs.bp.TurnOrderQueue.set(bs.bp.TurnOrderQueue.indexOf(a),null);
						}
					}
					
				}
				
				//Update target for good measure
				bs.bs.targetUpdate();
			}
			
			//Prevent overheal.
			if(vic.tempStats[0]>vic.buffedStats[0]){
				vic.tempStats[0]=vic.buffedStats[0];
			}
		}
	}
	
	//For changes in Mp.
	public void bpChange(int bp, Schmuck s){
		int meterChange = bp;
		//Activate all on-gain-meter or on-spend-meter effects accordingly.
		if(meterChange < 0){
			meterChange = s.statusProcTime(17, bs, null, null, meterChange, 0, true, null);
		}
		else{
			meterChange = s.statusProcTime(18, bs, null, null, meterChange, 0, true, null);
			meterChange *= (1 + s.getRegenBonus());
		}
		
		//Prevent Mp from being negative or more that max.
		s.tempStats[1]+=meterChange;
		if(s.getCurrentBp()<0){
			s.setCurrentBp(0);
		}
		if(s.getCurrentBp()>s.getMaxBp()){
			s.setCurrentBp(s.getMaxBp());
		}
	}
	
	public int logScaleDamage(Schmuck perp, Schmuck vic){
		double Attack = perp.buffedStats[(int)(perp.getDamageStat()+2)];
		double Defense = vic.buffedStats[(int)(vic.getDefenseStat()+3)];
		int damage = (int)(Attack * Math.log10(Attack) * Math.log(1+Math.pow(Attack/Defense, 2))/Math.log(2));
		
		damage += perp.getAttackDamage();
		damage -= vic.getDamageReduction();
		
		if(damage <= 0){
			damage = 1;
		}
		
		return -damage;
	}
	
	//Returns true or false if a given ability hits or misses.
	public Boolean getAcc(Schmuck perp, Schmuck vic, int baseAcc){
		int acc = 0;
		if(vic.getBuffedLuk() != 0){
			acc = (int)(100*perp.getBuffedSkl()/vic.getBuffedLuk()+100*(perp.getBonusAcc()-vic.getBonusEva()));
		}
		else{
			acc = 1;
		}
		if((int)(Math.random()*100) <= acc){
			return true;
		}
		else{
			return false;
		}
	}
	
	//returns true or false if a given ability crits or not.
	public Boolean getCrit(Schmuck perp, Schmuck vic, Skills s){
		double crit = 0;
		if(vic.getBuffedLuk() != 0){
			crit = perp.getBuffedSkl()/(vic.getBuffedLuk() * vic.getBuffedLuk()) + perp.getCritChance() - vic.getCritAvoid() + s.getBaseCrit()/100;
		}
		else{
			crit = 1;
		}
		if(Math.random() <= crit){
			return true;
		}
		else{
			return false;
		}
	}
}
