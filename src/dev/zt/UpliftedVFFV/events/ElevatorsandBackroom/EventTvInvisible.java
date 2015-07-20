package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventTvInvisible extends Event {

	public boolean selfswitch1=false;
	public EventTvInvisible(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.Dialog(165, 165,this.getId());

	}
	
	public boolean isSolid(int i){
		return true;
	}
}
