package dev.zt.UpliftedVFFV.events;



import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventElevatorFloor extends Event {

	public boolean selfswitch1=false;
	public EventElevatorFloor(float x, float y, int idnum) {
		super(Assets.ElevatorFloorMark,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.Dialog(166, 166,this.getId());

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
