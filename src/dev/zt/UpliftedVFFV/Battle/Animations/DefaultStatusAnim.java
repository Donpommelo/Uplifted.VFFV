package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DefaultStatusAnim extends BattleAnimation{
	
	static int frames = 100;
	status st;
	Schmuck s;
	public DefaultStatusAnim(status st, Schmuck s){
		super(frames);
		this.st = st;
		this.s = s;
	}
	
	public void animateEffect(int frame, Graphics g, BattleState bs){
		if(frame < 40){
			g.drawString(st.getName(), s.getX()+s.getBattleSprite().getWidth()/2, s.getY()-frame + 70);
		}
		else {
			g.drawString(st.getName(), s.getX()+s.getBattleSprite().getWidth()/2, s.getY()+30);
		}
	}
}
