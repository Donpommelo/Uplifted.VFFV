package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;


public class EventTestBattle extends Event {

	public EventTestBattle(float x, float y, int idnum) {
		super(Assets.Black,idnum,x, y);
		
	
	}
	
	public void run(){
//		super.fite(7, this.id, true, true);
		super.fite((int)(Math.random()*13), this.id, true, true);

	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean drawn(){
		return true;
	}
}
