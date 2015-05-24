package dev.zt.UpliftedVFFV.events;



import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventMoverGag extends Event {

	public boolean selfswitch1=false;
	public EventMoverGag(float x, float y, int idnum) {
		super(Assets.MoverGag,idnum,x, y);
		
	
	}
	

	
	public void run(){


	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean drawn(){
		return !Event.events[66].isSelfswitch1();
	}
}
