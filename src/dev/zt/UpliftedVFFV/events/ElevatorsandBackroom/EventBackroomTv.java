package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomTv extends Event {

	public boolean selfswitch1=false;
	public EventBackroomTv(float x, float y, int idnum) {
		super(Assets.Tv,idnum,x, y);
		
	}
	

	
	public void run(){

	}
	
	public boolean isSolid(int i){
		return true;
	}
}
