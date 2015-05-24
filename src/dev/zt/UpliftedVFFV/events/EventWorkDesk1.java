package dev.zt.UpliftedVFFV.events;



import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventWorkDesk1 extends Event {

	public boolean selfswitch1=false;
	public EventWorkDesk1(float x, float y, int idnum) {
		super(Assets.WorkDesk1,idnum,x, y);
		
	
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
