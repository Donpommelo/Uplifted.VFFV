package dev.zt.UpliftedVFFV.events;



import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomDesk2 extends Event {

	public boolean selfswitch1=false;
	public EventBackroomDesk2(float x, float y, int idnum) {
		super(Assets.WritingDesk2,idnum,x, y);
		
	
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
