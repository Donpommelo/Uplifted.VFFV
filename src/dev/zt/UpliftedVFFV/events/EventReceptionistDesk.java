package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class EventReceptionistDesk extends Event {

	public boolean selfswitch1=false;
	public EventReceptionistDesk(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		if(selfswitch1==false){
			super.Dialog(32, 36,this.getId());
			selfswitch1=true;
		}
		else{
			super.Dialog(37, 37,this.getId());
		}
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
