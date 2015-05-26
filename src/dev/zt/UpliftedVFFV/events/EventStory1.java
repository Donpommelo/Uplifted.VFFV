package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventStory1 extends Event {

	boolean selfswitch1 = false;
	public EventStory1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.Dialog(251, 252, this.getId());
		selfswitch1 = true;
		super.transport("/Worlds/Lobby.txt", 7, 8,"");
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public boolean drawn(){
		return !selfswitch1;
	}

}
