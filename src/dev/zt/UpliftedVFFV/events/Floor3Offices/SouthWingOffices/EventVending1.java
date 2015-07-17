package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventVending1 extends Event {

	public boolean selfswitch1=false;
	public EventVending1(float x, float y, int idnum) {
		super(Assets.VendingMachine,idnum,x, y);
	}
	
	public void run(){

	}
	
	public boolean isSolid(int i){
		return true;
	}
}
