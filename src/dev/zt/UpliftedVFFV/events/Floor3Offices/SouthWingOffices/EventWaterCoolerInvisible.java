package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventWaterCoolerInvisible extends Event {

	public boolean selfswitch1=false;
	public EventWaterCoolerInvisible(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
	
	public void run(){
		if(!this.selfswitch1){
			super.Dialog(289, 293,this.getId());
			this.selfswitch1 = true;
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}
}
