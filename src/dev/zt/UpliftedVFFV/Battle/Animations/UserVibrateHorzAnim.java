package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;

public class UserVibrateHorzAnim extends BattleAnimation{
	
	static int frames = 8;
	public UserVibrateHorzAnim(){
		super(frames);
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		if(frame<2){
			a.user.setX(a.user.getX()-3);	
		}
		else if(frame<6){
			a.user.setX(a.user.getX()+3);	
		}
		else if(frame<8){
			a.user.setX(a.user.getX()-3);	
		}
	}
}
