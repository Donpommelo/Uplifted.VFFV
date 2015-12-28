package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthHallLongtoJCloset extends Event {


	public WarpSouthHallLongtoJCloset(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	}
	

	
	public void run(){
		if(!this.isSelfswitch1()){
			super.setVar(12, super.getVar(12)+1);
			this.setSelfswitch1(true);
		}
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/JanitorClosetSouth.txt", 5, 10,"Broom Closet");
	}
}
