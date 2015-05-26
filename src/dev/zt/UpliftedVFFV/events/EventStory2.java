package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventStory2 extends Event {

	boolean selfswitch1 = false;
	public EventStory2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
			super.Dialog(253, 256, this.getId());
			selfswitch1 = true;
			super.transport("res/Worlds/SouthOfficeHallway.txt", 40, 3,"");
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public boolean drawn(){
		return !selfswitch1 && Event.events[66].isSelfswitch1();
	}

}
