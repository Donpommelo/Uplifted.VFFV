package dev.zt.UpliftedVFFV.Battle;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

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
	
	public void hpChange(int hp, Schmuck s){
		s.tempStats[0]+=hp;
		if(s.tempStats[0]<0){
			s.tempStats[0]=0;
			bs.bp.stm.addStatus(s,s.i);
			for(Action a : bs.bp.TurnOrderQueue){
				if(a!=null){
					if(a.user==s){
						bs.bp.TurnOrderQueue.set(bs.bp.TurnOrderQueue.indexOf(a),null);
					}
				}
				
			}
		}
		if(s.tempStats[0]>s.baseStats[0]){
			s.tempStats[0]=s.baseStats[0];
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

}
