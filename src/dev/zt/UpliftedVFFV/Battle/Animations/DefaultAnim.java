package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DefaultAnim extends BattleAnimation{
	
	static int frames = 80;
	public DefaultAnim(){
		super(frames);
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		g.setColor(new Color(255, 0, 0));
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		int startx = a.getUser().getX() + Assets.battleSprites[a.getUser().battleSprite].getWidth()/2;
		int starty = a.getUser().getY() + Assets.battleSprites[a.getUser().battleSprite].getHeight()/2;

		g.drawString(a.skill.getName(), startx+frame*(a.getTarget().getX()-a.getUser().getX())/80, starty+frame*(a.getTarget().getY()-a.getUser().getY())/80);
	}
	
	public void animateEffect(int frame, Graphics g, BattleState bs){
		g.setColor(new Color(255, 0, 0));
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.drawString("MEEP",300,200);
	}
}
