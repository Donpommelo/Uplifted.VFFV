package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthOfficetoBoardroom extends Event {


	public WarpSouthOfficetoBoardroom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}	

	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/BoardRoom1.txt",5,16,"");
	}



}
