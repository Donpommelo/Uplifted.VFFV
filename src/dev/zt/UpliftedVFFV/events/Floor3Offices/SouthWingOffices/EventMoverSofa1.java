package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventMoverSofa1 extends Event {

	public boolean selfswitch1=false;
	public EventMoverSofa1(float x, float y, int idnum) {
		super(Assets.MoverSofa1,idnum,x, y);
		
	
	}
	

	
	public void run(){
//		super.Dialog(165, 165,this.getId());

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean drawn(){
//		return !super.getSwitch(2);
		return false;
	}
}
