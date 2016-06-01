package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Color;
import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class VariableVoltageAnim extends BattleAnimation{
	
	static int frames = 30;
	public VariableVoltageAnim(){
		super(frames);
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		if(frame == 0){
			target = a.bs.bp.getSelectableEnemies(a.user).get((int)(Math.random()*a.bs.bp.getSelectableEnemies(a.user).size()));
		}
		g.setColor(Color.YELLOW);
		int startx = target.getX() + Assets.battleSprites[target.battleSprite].getWidth()/2;
		int starty = target.getY() + Assets.battleSprites[target.battleSprite].getHeight()/2;

		g.drawOval(startx-frame*2, starty-frame*2, frame*4, frame*4);
	}
	
	
}
