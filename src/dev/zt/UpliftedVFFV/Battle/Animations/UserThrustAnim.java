package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;

public class UserThrustAnim extends BattleAnimation{
	
	static int frames = 30;
	public UserThrustAnim(){
		super(frames);
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		if(frame<5){
			if(a.bs.bp.allies.contains(a.user)){
				a.user.setX(a.user.getX()+10);
			}
			else{
				a.user.setX(a.user.getX()-10);
			}
		}
		else{
			if(a.bs.bp.allies.contains(a.user)){
				a.user.setX(a.user.getX()-2);
			}
			else{
				a.user.setX(a.user.getX()+2);
			}	
		}
	}
}
