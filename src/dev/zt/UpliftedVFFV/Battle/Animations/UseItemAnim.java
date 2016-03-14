package dev.zt.UpliftedVFFV.Battle.Animations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.states.BattleState;

public class UseItemAnim extends BattleAnimation{
	
	boolean ally;
	BattleState bs;
	Item used;
	static int frames = 65;
	public UseItemAnim(Item i){
		super(frames);
		this.used = i;
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		int xLoc = 0;
		if(frame<25){
			xLoc = 10 * frame;
		}
		else if(frame<40){
			xLoc = 250 + 1*(frame-25);
		}
		else{
			xLoc = 265 + 10*(frame-40);
		}
		g.drawImage(used.getImage(),xLoc,200,null);

	}
}
