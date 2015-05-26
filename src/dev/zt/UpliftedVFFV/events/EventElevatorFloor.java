package dev.zt.UpliftedVFFV.events;



import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventElevatorFloor extends Event {

	public boolean selfswitch1=false;
	public EventElevatorFloor(float x, float y, int idnum) {
		super(Assets.ElevatorFloorMark,idnum,x, y);
		
	
	}
	

	
	public void run(){


	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return false;
	}
}
