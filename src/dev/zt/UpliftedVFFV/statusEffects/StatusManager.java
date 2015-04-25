package dev.zt.UpliftedVFFV.statusEffects;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class StatusManager {

	public ArrayList<Schmuck> team;
	public ArrayList<Schmuck> enemy;
	public GameState gs;
	public BattleState bs;
	
	public StatusManager(Game g, BattleState bs, GameState gs){
		this.gs=gs;
		this.bs=bs;
//		this.team=bs.bp.allies;
//		this.enemy=bs.bp.enemy;
		
		
	}
	
	public void addStatus(Schmuck s, status stat){
		if(s.statuses.contains(stat)){
			s.statuses.get(s.statuses.indexOf(stat)).duration++;
		}
		else{
			s.statuses.add(stat);
		}
		bs.bp.bt.textList.add(stat.inflictText(s));
	}
	
	public void removeStatus(Schmuck s, status stat){
		if(s.statuses.contains(stat)){
			s.statuses.remove(stat);
		}
		bs.bp.bt.textList.add(stat.cureText(s));
	}
	
	public void endofRound(){
		for(Schmuck s : team){
			for(status stat : s.statuses){
				stat.duration--;
				if(stat.duration==0){
					s.statuses.remove(stat);
				}
			}
		}
		for(Schmuck s : enemy){
			for(status stat : s.statuses){
				stat.duration--;
				if(stat.duration==0){
					s.statuses.remove(stat);
				}
			}
		}
	}
	
}
