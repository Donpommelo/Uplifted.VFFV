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
		if(s.statuses.contains(stat)){
			s.statuses.get(s.statuses.indexOf(stat)).duration+=stat.duration;
		}
		else{
			s.statuses.add(stat);
		}
		bs.bp.bt.textList.add(stat.inflictText(s));
	}
	
	public void removeStatus(Schmuck s, status stat){
		for(int i=0; i<s.statuses.size(); i++){
			if(s.statuses.get(i).getName()!=null){
				if(s.statuses.get(i).getName().equals(stat.getName())){
					s.statuses.remove(i);
					bs.bp.bt.textList.add(stat.cureText(s));
					i--;
				}
			}
		}
		
	}
	
	public Boolean checkStatus(Schmuck s, status stat){
		Boolean aff = false;
		for(int i=0; i<s.statuses.size(); i++){
			if(s.statuses.get(i).getName()!=null){
				if(s.statuses.get(i).getName().equals(stat.getName())){
					aff = true;
				}
			}
		}
		return aff;
	}
	
	public void endofRound(){
		for(Schmuck s : battlers){
			for(int i=0; i<s.statuses.size(); i++){
				if(s.statuses.get(i)!=null){
					s.statuses.get(i).endofturnEffect(s);
					if(s.statuses.get(i).duration==0 && s.statuses.get(i).perm==false){
						s.statuses.remove(i);
						i--;
					}
					else{
						s.statuses.get(i).duration--;
					}

				}
				
			}
		}
	}
	
	public void endofFite(){
		for(Schmuck s : battlers){
			for(int i=0; i<s.statuses.size(); i++){
				if(s.statuses.get(i)!=null){
					if(s.statuses.get(i).removedEnd){
						s.statuses.remove(i);
						s.calcBuffs();
						i--;
					}
				}
			}
		}
	}
	
}
