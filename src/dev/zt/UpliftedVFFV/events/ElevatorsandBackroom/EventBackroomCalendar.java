package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomCalendar extends Event {

	public boolean selfswitch1=false;
	public EventBackroomCalendar(float x, float y, int idnum) {
		super(Assets.Calendar,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.Dialog(166, 166,this.getId());

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
