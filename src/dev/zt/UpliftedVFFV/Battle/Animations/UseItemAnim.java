package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class UseItemAnim extends BattleAnimation{
	
	boolean ally;
	BattleState bs;
	Item used;
	Schmuck s;
	static int frames = 100;
	public UseItemAnim(Item i,Schmuck s){
		super(frames);
		this.used = i;
		this.s = s;
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		if(frame < 40){
			g.drawImage(used.getIcon(),a.getUser().getX()+a.user.getBattleSprite().getWidth()/2,
					a.user.getY()-frame,null);
		}
		else {
			g.drawImage(used.getIcon(),a.getUser().getX()+a.user.getBattleSprite().getWidth()/2,
					a.user.getY()-40,null);
		}
	}
	
	public void animateEffect(int frame, Graphics g, BattleState bs){
		if(frame < 40){
			g.drawImage(used.getIcon(),s.getX()+s.getBattleSprite().getWidth()/2,
					s.getY()-frame,null);
		}
		else {
			g.drawImage(used.getIcon(),s.getX()+s.getBattleSprite().getWidth()/2,
					s.getY()-40,null);
		}
	}
	
}
