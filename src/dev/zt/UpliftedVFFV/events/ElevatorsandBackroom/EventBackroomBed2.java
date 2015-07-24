package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomBed2 extends Event {

	public boolean selfswitch1=false;
	public EventBackroomBed2(float x, float y, int idnum) {
		super(Assets.Bed2,idnum,x, y);
	}
	
	public void run(){
		Event.events[79].run();
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
