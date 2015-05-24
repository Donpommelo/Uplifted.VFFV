package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventTestBattle extends Event {

	public EventTestBattle(float x, float y, int idnum) {
		super(Assets.Black,idnum,x, y);
		
	
	}
	
	public void run(){
			super.fite(5, this.id, true);

	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean drawn(){
		return false;
	}
}
