package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PoisonAnim extends BattleAnimation{
	
	Schmuck s;
	static int frames = 8;
	public PoisonAnim(Schmuck s){
		super(frames);
		this.s = s;
	}
	
	public void animateEffect(int frame, Graphics g, BattleState bs){
		if(frame<2){
			s.setX(s.getX()-3);	
		}
		else if(frame<6){
			s.setX(s.getX()+3);	
		}
		else if(frame<8){
			s.setX(s.getX()-3);	
		}
	}
	
}
