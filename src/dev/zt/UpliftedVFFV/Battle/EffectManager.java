package dev.zt.UpliftedVFFV.Battle;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EffectManager {
	
	public ArrayList<Schmuck> team;
	public ArrayList<Schmuck> enemy;
	public GameState gs;
	public BattleState bs;
	
	public EffectManager(Game g, BattleState bs, GameState gs){
		this.gs=gs;
		this.bs=bs;
//		this.team=bs.bp.allies;
//		this.enemy=bs.bp.enemy;		
	}
	
	public void hpChange(int hp, Schmuck perp, Schmuck vic){
		boolean invulnerable = false;
		for(status st : vic.statuses){
			if(st.getName().equals("Invulnerable")){
				invulnerable = true;
				bs.bp.bt.textList.add(vic.getName()+" took no damage.");
			}
		}
		if(!invulnerable){	
			if(hp > 0){
				bs.bp.bt.textList.add(vic.getName()+" restored "+hp+" health!");
			}
			else{
				bs.bp.bt.textList.add(vic.getName()+" received "+-hp+" damage!");
				
			}
			vic.tempStats[0]+=hp;
			
			if(hp<0){
				bs.bs.flash(vic, 51);
				for(int i=0; i<vic.statuses.size(); i++){
					if(vic.statuses.get(i)!=null){
						vic.statuses.get(i).takedamageEffect(perp,vic, bs, hp);
					}
				}
			}
			if(vic.tempStats[0]<=0){
				vic.tempStats[0]=0;
				bs.bp.stm.addStatus(vic,new incapacitate(perp));
				bs.bp.currentlySelected = 0;
				for(int i=0; i<perp.statuses.size(); i++){
					if(perp.statuses.get(i)!=null){
						perp.statuses.get(i).onKill(perp,vic, bs);
					}
				}
				for(int i=0; i<vic.statuses.size(); i++){
					if(vic.statuses.get(i)!=null){
						vic.statuses.get(i).onDeath(perp,vic, bs);
					}
				}
				for(Action a : bs.bp.TurnOrderQueue){
					if(a!=null){
						if(a.user==vic){
							bs.bp.TurnOrderQueue.set(bs.bp.TurnOrderQueue.indexOf(a),null);
						}
					}
					
				}
				bs.bs.targetUpdate();
			}
			if(vic.tempStats[0]>vic.baseStats[0]){
				vic.tempStats[0]=vic.baseStats[0];
			}
		}
		
	}
	
	public void hpChange(int hp, Schmuck perp, Schmuck vic, int elem){
		boolean invulnerable = false;
		for(status st : vic.statuses){
			if(st.getName().equals("Invulnerable")){
				invulnerable = true;
				bs.bp.bt.textList.add(vic.getName()+" took no damage.");
			}
		}
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
		}
		if(!invulnerable){
			hp = (int)(hp*(1-vic.buffedRes[elem]));
			if(hp > 0){
				bs.bp.bt.textList.add(vic.getName()+" restored "+hp+" health!");
			}
			else{
				bs.bp.bt.textList.add(vic.getName()+" received "+-hp+" "+element+" damage!");
			}
			vic.tempStats[0]+=hp;
			if(hp<0){
				bs.bs.flash(vic, 51);
				for(int i=0; i<vic.statuses.size(); i++){
					if(vic.statuses.get(i)!=null){
						vic.statuses.get(i).takedamageEffect(perp,vic, bs, hp);
					}
				}
			}
			if(vic.tempStats[0]<=0){
				vic.tempStats[0]=0;
				bs.bp.stm.addStatus(vic, new incapacitate(perp));
				for(int i=0; i<perp.statuses.size(); i++){
					if(perp.statuses.get(i)!=null){
						perp.statuses.get(i).onKill(perp,vic, bs);
					}
				}
				for(int i=0; i<vic.statuses.size(); i++){
					if(vic.statuses.get(i)!=null){
						vic.statuses.get(i).onDeath(perp,vic, bs);
					}
				}
				for(Action a : bs.bp.TurnOrderQueue){
					if(a!=null){
						if(a.user==vic){
							bs.bp.TurnOrderQueue.set(bs.bp.TurnOrderQueue.indexOf(a),null);
						}
					}
					
				}
				bs.bs.targetUpdate();
			}
			if(vic.tempStats[0]>vic.baseStats[0]){
				vic.tempStats[0]=vic.baseStats[0];
			}
		}
		
	}
	
	public void bpChange(int bp, Schmuck s){
		s.tempStats[1]+=bp;
		if(s.tempStats[1]<0){
			s.tempStats[1]=0;
		}
		if(s.tempStats[1]>s.baseStats[1]){
			s.tempStats[1]=s.baseStats[1];
		}
	}
	
	public int getAcc(Schmuck perp, Schmuck vic){
		int acc = 100*perp.getBuffedSkl()/vic.getBuffedLuk()+perp.getBonusAcc();
		return acc;
	}

}
