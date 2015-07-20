package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomBed1 extends Event {

	public boolean selfswitch1=false;
	public EventBackroomBed1(float x, float y, int idnum) {
		super(Assets.Bed1,idnum,x, y);
	}
	
	public void run(){
		super.Dialog(163, 163,this.getId());

	}

	public boolean isSolid(int i){
		return true;
	}
}
