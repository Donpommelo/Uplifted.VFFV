package dev.zt.UpliftedVFFV.Battle;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.statusEffects.HealBlock;
import dev.zt.UpliftedVFFV.statusEffects.Invuln;
import dev.zt.UpliftedVFFV.statusEffects.MeterBlock;
import dev.zt.UpliftedVFFV.statusEffects.Purified;
import dev.zt.UpliftedVFFV.statusEffects.Undead;
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
		
	public void hpChange(int hp, Schmuck perp, Schmuck vic, int elem){
		int finalDamage = hp;
		if(finalDamage < 0){
			finalDamage += (int)(perp.getDamAmp()*hp);
			finalDamage -= (int)(vic.getDamRes()*hp);
			if(elem != 6){
				finalDamage -= (int)(hp*(double)(vic.getBonusStats()[elem+19]/100));
				finalDamage += (int)(hp*(double)(perp.getBuffedElemPoints()[elem]/100));
			}	
		}
		else{
			if( elem != 6){
				finalDamage += (int)(hp*(double)(perp.getBuffedElemPoints()[elem]/100));			
			}
		}
		finalDamage += (int)((finalDamage)*(Math.random() * 2 * (perp.getDamageVariance()+.1)-(perp.getDamageVariance()+.1)));
		String element = "";
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
		}
		if(!bs.bp.stm.checkStatus(vic, new incapacitate(vic))){
			if(finalDamage > 0){
				if(bs.bp.stm.checkStatus(vic, new HealBlock(0,vic,50))){
					bs.bp.bt.textList.add(vic.getName()+" was prevented from healing!");
				}
				else{
					bs.bp.bt.textList.add(vic.getName()+" restored "+finalDamage+" health!");
					for(int i=0; i<vic.statuses.size(); i++){
						if(vic.statuses.get(i)!=null){
							if(!bs.bp.stm.checkStatus(vic, new incapacitate(vic)) || vic.statuses.get(i).runWhenDead() || bs.bp.stm.checkStatus(vic, new Undead(vic, 10))){
								if(!bs.bp.stm.checkStatus(vic, new Purified(vic,0))){
									finalDamage = vic.statuses.get(i).onHealEffect(perp,vic, bs, finalDamage,elem);
								}
							}
						}
					}
					finalDamage *= (1+vic.getRegenBonus());
					vic.tempStats[0]+=finalDamage;
				}
			}
			else{
				if(bs.bp.stm.checkStatus(vic, new Invuln(0,vic,50))){
					bs.bp.bt.textList.add(vic.getName()+"'s Invulnerability prevented damage!");
				}
				else{
					bs.bs.flash(vic, 80);
					for(int i=0; i<perp.statuses.size(); i++){
						if(perp.statuses.get(i)!=null){
							if(!bs.bp.stm.checkStatus(perp, new incapacitate(perp)) || perp.statuses.get(i).runWhenDead() || bs.bp.stm.checkStatus(perp, new Undead(perp, 10))){
								if(!bs.bp.stm.checkStatus(perp, new Purified(perp,0))){
									finalDamage = perp.statuses.get(i).dealdamageEffect(perp,vic, bs, finalDamage,elem);
								}
							}
						}
					}
					for(int i=0; i<vic.statuses.size(); i++){
						if(vic.statuses.get(i)!=null){
							if(!bs.bp.stm.checkStatus(vic, new incapacitate(vic)) || vic.statuses.get(i).runWhenDead() || bs.bp.stm.checkStatus(vic, new Undead(vic, 10))){
								if(!bs.bp.stm.checkStatus(vic, new Purified(vic,0))){
									finalDamage = vic.statuses.get(i).takedamageEffect(perp,vic, bs, finalDamage,elem);
								}
							}
						}
					}
					bs.bp.bt.textList.add(vic.getName()+" received "+-finalDamage+" "+element+" damage!");
					vic.tempStats[0]+=finalDamage;
				}				
			}	
			if(vic.tempStats[0]<=0){
				vic.tempStats[0]=0;				
				for(int i=0; i<perp.statuses.size(); i++){
					if(perp.statuses.get(i)!=null){
						if(!bs.bp.stm.checkStatus(perp, new incapacitate(perp)) || perp.statuses.get(i).runWhenDead() || bs.bp.stm.checkStatus(perp, new Undead(perp, 10))){
							if(!bs.bp.stm.checkStatus(perp, new Purified(perp,0))){
								perp.statuses.get(i).onKill(perp,vic, bs);
							}
						}
					}
				}
				for(int i=0; i<vic.statuses.size(); i++){
					if(vic.statuses.get(i)!=null){
						if(!bs.bp.stm.checkStatus(vic, new incapacitate(vic)) || vic.statuses.get(i).runWhenDead() || bs.bp.stm.checkStatus(vic, new Undead(vic, 10))){
							if(!bs.bp.stm.checkStatus(vic, new Purified(vic,0))){
								vic.statuses.get(i).onDeath(perp,vic, bs);
							}
						}
					}
				}
				bs.bp.stm.addStatus(vic, new incapacitate(perp));
				for(Action a : bs.bp.TurnOrderQueue){
					if(a!=null){
						if(a.user==vic){
							bs.bp.TurnOrderQueue.set(bs.bp.TurnOrderQueue.indexOf(a),null);
						}
					}
					
				}
				bs.bs.targetUpdate();
			}
			if(vic.tempStats[0]>vic.buffedStats[0]){
				vic.tempStats[0]=vic.buffedStats[0];
			}
		}
	}

	public int damageSimulation(int hp, Schmuck perp, Schmuck vic, int elem, int acc){
		int finalDamage = hp;
		if(!bs.bp.em.getAcc(perp, vic,acc) || bs.bp.stm.checkStatus(perp, new Invuln(0,vic,50))){
			finalDamage = 0;
		}
		else{
			if(finalDamage < 0){
				finalDamage += (int)(perp.getDamAmp()*hp);
				finalDamage -= (int)(vic.getDamRes()*hp);
				if(elem != 6){
					finalDamage -= (int)(hp*(double)(vic.getBonusStats()[elem+19]/100));
					finalDamage += (int)(hp*(double)(perp.getBuffedElemPoints()[elem]/100));
				}	
			}
			else{
				if( elem != 6){
					finalDamage += (int)(hp*(double)(perp.getBuffedElemPoints()[elem]/100));			
				}
			}
			finalDamage += (int)((finalDamage)*(Math.random() * 2 * (perp.getDamageVariance()+.1)-(perp.getDamageVariance()+.1)));
		}
		return finalDamage;
	}
	
	public void bpChange(int bp, Schmuck s){
		int meterChange = bp;
		if(!bs.bp.stm.checkStatus(s, new MeterBlock(0,s,50))){
			
			if(meterChange < 0){
				for(int i=0; i<s.statuses.size(); i++){
					if(s.statuses.get(i)!=null){
						if(!bs.bp.stm.checkStatus(s, new incapacitate(s)) || s.statuses.get(i).runWhenDead() || bs.bp.stm.checkStatus(s, new Undead(s, 10))){
							if(!bs.bp.stm.checkStatus(s, new Purified(s,0))){
								meterChange = s.statuses.get(i).spendMeterEffect(s, bs, meterChange);
							}
						}
					}
				}
			}
			else{
				for(int i=0; i<s.statuses.size(); i++){
					if(s.statuses.get(i)!=null){
						if(!bs.bp.stm.checkStatus(s, new incapacitate(s)) || s.statuses.get(i).runWhenDead() || bs.bp.stm.checkStatus(s, new Undead(s, 10))){
							if(!bs.bp.stm.checkStatus(s, new Purified(s,0))){
								meterChange = s.statuses.get(i).gainMeterEffect(s, bs, meterChange);
							}
						}
					}
				}
				meterChange *= (1 + s.getRegenBonus());
			}
			s.tempStats[1]+=meterChange;
			if(s.getCurrentBp()<0){
				s.setCurrentBp(0);
			}
			if(s.getCurrentBp()>s.getMaxBp()){
				s.setCurrentBp(s.getMaxBp());
			}
		}
		else{
			bs.bp.bt.textList.add(s.getName()+" was prevented from restoring meter!");

		}
		
	}
	
	//Returns true or false if a given ability hits or misses.
	public Boolean getAcc(Schmuck perp, Schmuck vic, int baseAcc){
		int acc = (int)(100*perp.getBuffedSkl()/vic.getBuffedLuk()+100*(perp.getBonusAcc()-vic.getBonusEva()));
		if((int)(Math.random()*100) <= acc){
			return true;
		}
		else{
			return false;
		}
	}
	
	//returns true or false if a given ability crits or not.
	public Boolean getCrit(Schmuck perp, Schmuck vic, Skills s){
		double crit = perp.getBuffedSkl()/(vic.getBuffedLuk() * vic.getBuffedLuk()) + perp.getCritChance() + s.getBaseCrit()/100;
		if(Math.random() <= crit){
			return true;
		}
		else{
			return false;
		}
	}
}
