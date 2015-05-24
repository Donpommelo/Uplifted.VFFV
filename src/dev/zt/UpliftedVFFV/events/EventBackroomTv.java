package dev.zt.UpliftedVFFV.events;



import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomTv extends Event {

	public boolean selfswitch1=false;
	public EventBackroomTv(float x, float y, int idnum) {
		super(Assets.Tv,idnum,x, y);
		
	
	}
	

	
	public void run(){
		

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
