package dev.zt.UpliftedVFFV.events;



import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventElevatorWallWave extends Event {

	public boolean selfswitch1=false;
	public EventElevatorWallWave(float x, float y, int idnum) {
		super(Assets.ElevatorWave,idnum,x, y);
		
	
	}
	

	
	public void run(){


	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
