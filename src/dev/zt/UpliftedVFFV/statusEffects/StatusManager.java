package dev.zt.UpliftedVFFV.statusEffects;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Battle.BattleProcessor;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class StatusManager {

	public ArrayList<Schmuck> team;
	public ArrayList<Schmuck> enemy;
	public ArrayList<Schmuck> battlers;
	public GameState gs;
	public BattleState bs;
	
	public StatusManager(Game g, BattleState bs, GameState gs, BattleProcessor bp){
		this.gs=gs;
		this.bs=bs;
		this.team=bp.allies;
		this.enemy=bp.enemy;
		this.battlers = bp.battlers;
		
	}
	
	public void addStatus(Schmuck s, status stat){
		if(stat.getName().equals("incapacitated")){
			for(int i=0; i<s.statuses.size(); i++){
				if(s.statuses.get(i)!=null){
					if(s.statuses.get(i).perm != true){
						s.statuses.remove(i);
					}
				}
			}
			if(bs.bs.alliesSelectable.contains(s) && !checkStatus(s,new incapacitate(s)) && bs.bs.alliesSelectable.size() == 1){
				bs.bp.bt.addScene("You and everyone you care about are dead.");
			}			
		}
		
		//What happens if you gain a status you already had?
		
		//Case 0: New stat is not applied.
		if(stat.stackingEffect() == 0 && checkStatus(s,stat)){
			bs.bp.bt.addScene(s.getName()+" is already "+stat.getName()+"!");
		}
		else{
			switch(stat.stackingEffect()){
			
			case 0:
				s.statuses.add(stat);
				break;
			//Case 1: Old stat's duration is increased
			case 1:
				if(checkStatus(s,stat)){
					if(!findStatus(s,stat).perm){
						findStatus(s,stat).setDuration(findStatus(s,stat).getDuration()+stat.duration);
					}
				}
				else{
					s.statuses.add(stat);
				}
				break;
			
			//Case 2: Both stats are added.
			case 2:
				s.statuses.add(stat);
				break;
			
			//Case 3: The New stat replaces the old one.	
			case 3:
				if(checkStatus(s,stat)){
					if(!findStatus(s,stat).perm){
						s.statuses.remove(findStatus(s,stat));
					}
				}
				s.statuses.add(stat);	
				break;
				
			//Case 4: Both stats are removed.
			case 4:
				if(checkStatus(s,stat)){
					if(!findStatus(s,stat).perm){
						s.statuses.remove(findStatus(s,stat));
					}
				}
				else{
					s.statuses.add(stat);
				}
				break;
			//Case 5: Stack ++
			case 5:
				if(checkStatus(s,stat)){
					findStatus(s,stat).stack++;
				}
				else{
					s.statuses.add(stat);
				}
				break;	
			}
			
			
			if(!stat.inflictText(s).equals("")){
				bs.bp.bt.addScene(stat.inflictText(s));
			}
			
			//Activate all of the target's on-status effects.
			s.onNewStatus(stat, bs);
		}		
		
		int j;
		boolean flag = true;
		status temp;
		while (flag){
			flag=false;
			for(j=0; j<s.statuses.size()-1; j++){
				if(s.statuses.get(j) != null && s.statuses.get(j+1) != null){
					if(s.statuses.get(j).getPriority() > s.statuses.get(j+1).getPriority()){
						temp = s.statuses.get(j);
						s.statuses.set(j,s.statuses.get(j+1));
						s.statuses.set(j+1,temp);
						flag = true;
					}
				}
			}
		}
	}
	
	//Removes a nonpermanent status.
	public void removeStatus(Schmuck s, status stat){
		for(int i=0; i<s.statuses.size(); i++){
			if(s.statuses.get(i).getName()!=null){
				if(s.statuses.get(i).getName().equals(stat.getName())){
					if(s.statuses.get(i).perm){
						bs.bp.bt.addScene(stat.getName()+" could not be removed!");
					}
					else{
						if(!s.statuses.get(i).cureText(s).equals("")){
							bs.bp.bt.addScene(s.statuses.get(i).cureText(s));
						}
						s.statuses.remove(i);
						i--;
					}
				}
			}
		}
	}
	
	//Removes permanent stuff too
	public void hardRemoveStatus(Schmuck s, status stat){
		for(int i=0; i<s.statuses.size(); i++){
			if(s.statuses.get(i).getName()!=null){
				if(s.statuses.get(i).getName().equals(stat.getName())){
					s.statuses.remove(i);
					i--;	
				}
			}
		}
	}
	
	public Boolean checkStatus(Schmuck s, status stat){
		Boolean aff = false;
		for(status st :s.statuses){
			if(st.getName()!=null){			
				if(st.getName().equals(stat.getName())){					
					aff = true;
				}
			}
		}
		return aff;
	}
	
	public status findStatus(Schmuck s, status stat){
		int index = 0;
		for(int i=0; i<s.statuses.size(); i++){
			if(s.statuses.get(i).getName()!=null){
				if(s.statuses.get(i).getName().equals(stat.getName())){
					index = i;
				}
			}
		}
		return s.statuses.get(index);
	}
	
	public void endofRound(BattleState bs){
		for(Schmuck s : battlers){
			s.endofRoundEffects(bs);
		}
		for(Schmuck s : battlers){
			for(int i=0; i<s.statuses.size(); i++){
				if(s.statuses.get(i)!=null){
					if(!checkStatus(s, new incapacitate(s)) || s.statuses.get(i).runWhenDead() || checkStatus(s, new Undead(10))){
						if(s.statuses.get(i).duration==0){
							if(!s.statuses.get(i).cureText(s).equals("")){
								bs.bp.bt.addScene(s.statuses.get(i).cureText(s));
							}
							hardRemoveStatus(s, s.statuses.get(i));
							i--;
						}
						else if(s.statuses.get(i).decay){
							s.statuses.get(i).duration--;
						}
					}
				}
			}
		}
		
	}
	
	public void endofFite(){
		for(Schmuck s : battlers){
			s.endofFightEffects(bs);
		}
		for(Schmuck s : battlers){
			for(int i=0; i<s.statuses.size(); i++){
				if(s.statuses.get(i)!=null){					
					if(s.statuses.get(i).removedEnd){
						hardRemoveStatus(s,s.statuses.get(i));
						s.calcBuffs(bs);
						i--;
					}
				}
			}
		}
	}
	
	public status randomBad(int duration, Schmuck s){
		status status = new Stunned(duration,s,50);
		int statnum = (int)(Math.random()*29);
		switch(statnum){
		case 0:
			status = new Asleep(duration,s,50);
			break;
		case 1:
			status = new Berzerk(duration,s,50);
			break;
		case 2:
			status = new Blind(duration,s,50);
			break;
		case 3:
			status = new Combustibility(duration,s,50);
			break;
		case 4:
			status = new Contagious(duration,s,50);
			break;
		case 5:
			status = new Delicious(duration,.50,s,50);
			break;
		case 6:
			status = new Disarmed(duration,s,50);
			break;
		case 7:
			status = new ElemBlock(duration,(int)(Math.random()*7),s,50);
			break;
		case 8:
			status = new Frozen(duration,s,50);
			break;
		case 9:
			status = new HealBlock(duration,s,50);
			break;
		case 10:
			status = new Hypochondriac(duration,s,50);
			break;
		case 11:
			status = new Impatient(duration,0.25,s,50);
			break;
		case 12:
			status = new Impotent(duration,s,50);
			break;
		case 13:
			status = new Insolvent(duration,s,50);
			break;
		case 14:
			status = new Intimidated(duration,0.5,s,50);
			break;
		case 15:
			status = new Isolated(duration,s,50);
			break;
		case 16:
			status = new MeterBlock(duration,s,50);
			break;
		case 17:
			status = new Negative(duration,s,50);
			break;
		case 18:
			status = new Paralysis(duration,s,50);
			break;
		case 19:
			status = new Poisoned(duration,s,50);
			break;
		case 20:
			status = new Pursued(duration,s,50);
			break;
		case 21:
			status = new Silenced(duration,s,50);
			break;
		case 22:
			status = new Unresistant(duration,s,50);
			break;
		case 23:
			status = new StatBuffMult(duration,2,.8,s,50);
			break;
		case 24:
			status = new StatBuffMult(duration,3,.8,s,50);
			break;
		case 25:
			status = new StatBuffMult(duration,4,.8,s,50);
			break;
		case 26:
			status = new StatBuffMult(duration,5,.8,s,50);
			break;
		case 27:
			status = new StatBuffMult(duration,6,.8,s,50);
			break;
		case 28:
			status = new StatBuffMult(duration,7,.8,s,50);
			break;
		}
		return status;
	}
	
}
