package dev.zt.UpliftedVFFV.events.EventsCommon;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventSofa2 extends Event {

	public boolean selfswitch1=false;
	public EventSofa2(float x, float y, int idnum) {
		super(Assets.Sofa2,idnum,x, y);
		
	
	}
	

	
	public void run(){
//		super.Dialog(165, 165,this.getId());

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
