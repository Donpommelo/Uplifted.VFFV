package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Color;
import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class SingleProjAnim extends BattleAnimation{
	
	static int frames = 50;
	int color;
	public SingleProjAnim(int c){
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
		int startx = a.getUser().getX() + Assets.battleSprites[a.getUser().battleSprite].getWidth()/2;
		int starty = a.getUser().getY() + Assets.battleSprites[a.getUser().battleSprite].getHeight()/2;

		g.fillOval(startx+frame*(a.getTarget().getX()-a.getUser().getX())/50, starty+frame*(a.getTarget().getY()-a.getUser().getY())/50, 20, 20);	}
}