package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomDesk1 extends Event {

	public boolean selfswitch1=false;
	public EventBackroomDesk1(float x, float y, int idnum) {
		super(Assets.WritingDesk1,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.Dialog(164, 164,this.getId());

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
