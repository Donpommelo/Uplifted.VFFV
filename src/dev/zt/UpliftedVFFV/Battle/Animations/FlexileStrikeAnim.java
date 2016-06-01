package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class FlexileStrikeAnim extends BattleAnimation{
	
	static int frames = 50;
	public FlexileStrikeAnim(){
		super(frames);
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		if(frame == 0){
			target = a.bs.bp.getSelectableEnemies(a.user).get((int)(Math.random()*a.bs.bp.getSelectableEnemies(a.user).size()));
		}
		int startx = target.getX() + Assets.battleSprites[target.battleSprite].getWidth()/2;
		int starty = target.getY() + Assets.battleSprites[target.battleSprite].getHeight()/2;

		g.drawOval(startx-frame*2, starty-frame*2, frame*4, frame*4);
	}
	
	
}
