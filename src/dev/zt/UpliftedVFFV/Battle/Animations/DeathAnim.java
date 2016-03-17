package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DeathAnim extends BattleAnimation{
	
	static int frames = 100;
	Schmuck vic;
	public DeathAnim(Schmuck vic){
		super(frames);
		this.vic = vic;
	}
	
	public void animateEffect(int frame, Graphics g, BattleState bs){
		if(!bs.allies.contains(vic)){
			Graphics2D g2d = (Graphics2D) g;
			float alpha = 1f;
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha + frame * -0.01f));
		    g2d.drawImage(vic.getBattleSprite(), vic.getX(), vic.getY(), null);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
		}
	    if(frame == 0 || frame == 99){
		    bs.bs.targetUpdate();
	    }
	}
}
