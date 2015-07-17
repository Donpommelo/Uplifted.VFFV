package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventWaterCoolerInvisible extends Event {

	public boolean selfswitch1=false;
	public EventWaterCoolerInvisible(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
	
	public void run(){
//		super.Dialog(168, 168,this.getId());

	}
	
	public boolean isSolid(int i){
		return true;
	}
}
