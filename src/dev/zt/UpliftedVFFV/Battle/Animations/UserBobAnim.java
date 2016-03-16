package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;

public class UserBobAnim extends BattleAnimation{
	
	static int frames = 20;
	public UserBobAnim(){
		super(frames);
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		if(frame<10){
			a.user.setY(a.user.getY()+3);	
		}
		else{
			a.user.setY(a.user.getY()-3);
		}
	}
}
