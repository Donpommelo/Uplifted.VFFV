package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Color;
import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.BattleState;

public class OpeningCircleTargetAnim extends BattleAnimation{
	
	boolean ally;
	BattleState bs;
	static int frames = 50;
	int color;
	public OpeningCircleTargetAnim(int c){
		super(frames);
		this.color = c;
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		switch(color){
		case 0:
			g.setColor(Color.RED);
			break;
		case 1:
			g.setColor(Color.BLUE);
			break;
		case 2:
			g.setColor(Color.GREEN);
			break;
		case 3:
			g.setColor(Color.YELLOW);
			break;
		case 4:
			g.setColor(Color.PINK);
			break;
		case 5:
			g.setColor(Color.BLACK);
			break;
		}
		int startx = a.getTarget().getX() + Assets.battleSprites[a.getTarget().battleSprite].getWidth()/2;
		int starty = a.getTarget().getY() + Assets.battleSprites[a.getTarget().battleSprite].getHeight()/2;

		g.drawOval(startx-frame*2, starty-frame*2, frame*4, frame*4);
	}
}
