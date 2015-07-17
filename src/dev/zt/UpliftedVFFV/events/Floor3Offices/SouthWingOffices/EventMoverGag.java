package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventMoverGag extends Event {

	public boolean selfswitch1=false;
	public EventMoverGag(float x, float y, int idnum) {
		super(Assets.MoverGag,idnum,x, y);
	}
	
	public void run(){

	}

	public boolean isSolid(int i){
		return true;
	}
	
	public boolean drawn(){
		return !super.getSwitch(2);
	}
}
