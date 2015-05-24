package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event21 extends Event {


	public Event21(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		if(Event.events[66].isSelfswitch1()){
			super.transport("res/Worlds/Lobby.txt", 13, 4,"");
		}
		else{
			super.Dialog(108, 108,this.getId());
		}
		
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return !Event.events[66].isSelfswitch1();
	}

}
