package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;
//import dev.zt.UpliftedVFFV.inventory.*;


public class EventTestBattle extends Event {

	public EventTestBattle(float x, float y, int idnum) {
		super(Assets.VendingMachine,idnum,x, y);
		
	}
	
	public void run(){
//		super.fite(2, this.id, true, true);
//		super.fite((int)(Math.random() * 24), this.id, true, true);
//		super.fite(21, this.id, true, true);

		super.fite(20, this.id, true, true);

	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean drawn(){
		return true;
	}
}
