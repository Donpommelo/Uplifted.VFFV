package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event40 extends Event {


	public Event40(float x, float y, int idnum) {
		super(Assets.SafeOpened,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/ExtraStorageRoom.txt", 3, 3,"South Wing Office");
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}

}
