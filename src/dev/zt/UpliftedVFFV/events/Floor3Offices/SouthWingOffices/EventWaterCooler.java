package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventWaterCooler extends Event {

	public boolean selfswitch1=false;
	public EventWaterCooler(float x, float y, int idnum) {
		super(Assets.WaterCooler,idnum,x, y);
		
	
	}
	

	
	public void run(){


	}

	public boolean isSolid(){
		return true;
	}
}
