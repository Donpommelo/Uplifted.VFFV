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
		s.CurrentHp+=hp;
		if(s.CurrentHp<0){
			s.CurrentHp=0;
			bs.bp.stm.addStatus(s,s.i);
			
		}
		if(s.CurrentHp>s.MaxHp){
			s.CurrentHp=s.MaxHp;
		}
	}
	
	public void bpChange(int bp, Schmuck s){
		s.CurrentBp+=bp;
		if(s.CurrentBp<0){
			s.CurrentBp=0;
		}
		if(s.CurrentBp>s.MaxBp){
			s.CurrentBp=s.MaxBp;
		}
	}

}
