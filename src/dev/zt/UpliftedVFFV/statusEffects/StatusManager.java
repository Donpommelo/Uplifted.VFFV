package dev.zt.UpliftedVFFV.statusEffects;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Battle.BattleProcessor;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

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
				bs.bp.bt.textList.add("You and everyone you care about are dead.");
			}			
		}
		
		//What happens if you gain a status you already had?
		
		//Case 0: New stat is not applied.
		if(stat.stackingEffect() == 0 && checkStatus(s,stat)){
			bs.bp.bt.textList.add(s.getName()+" is already "+stat.getName()+"!");
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
				break;
			}
			
			if(!stat.inflictText(s).equals("")){
				bs.bp.bt.textList.add(stat.inflictText(s));
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
						bs.bp.bt.textList.add(stat.getName()+" could not be removed!");
					}
					else{
						if(!s.statuses.get(i).cureText(s).equals("")){
							bs.bp.bt.textList.add(s.statuses.get(i).cureText(s));
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
					if(!s.statuses.get(i).cureText(s).equals("")){
						bs.bp.bt.textList.add(s.statuses.get(i).cureText(s));
					}
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
								bs.bp.bt.textList.add(s.statuses.get(i).cureText(s));
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
	
}
