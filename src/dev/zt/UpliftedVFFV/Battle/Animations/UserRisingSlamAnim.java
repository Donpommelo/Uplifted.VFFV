package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;

public class UserRisingSlamAnim extends BattleAnimation{
	
	static int frames = 30;
	public UserRisingSlamAnim(){
		super(frames);
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		if(frame<25){
			a.user.setY(a.user.getY()-2);

		}
		else{
			a.user.setY(a.user.getY()+10);
		}
	}
}
