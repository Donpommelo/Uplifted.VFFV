package dev.zt.UpliftedVFFV.events.EventsCommon;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventSmudge2 extends Event {

	public boolean selfswitch1=false;
	public EventSmudge2(float x, float y, int idnum) {
		super(Assets.Smudge2,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.Dialog(166, 166,this.getId());

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public boolean runnable(){
		return false;
	}
}
