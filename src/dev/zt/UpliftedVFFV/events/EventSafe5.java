package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.FadedSash;
import dev.zt.UpliftedVFFV.inventory.FishWater;
import dev.zt.UpliftedVFFV.inventory.MedPak;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventSafe5 extends Event {


	static BufferedImage img = Assets.SafeClosed;
	boolean selfswitch1 = false;
	public String[] Choices={"Yes","No"};			
	public static int stage=0;						
	public static int finalstage=2;	
	public EventSafe5(float x, float y, int idnum) {
		super(img,idnum,x, y);
	}
	
	public void run(){
		switch(stage){
		case 0:
			if(!selfswitch1){
				super.Dialog(184, 185,this.getId());
				Event.events[this.getId()].setTex(Assets.SafeOpened);
			}
			else{
				super.Dialog(186, 186,this.getId());
			}
			break;
		case 1:
			super.Dialog(186, 186,this.getId());
			super.ChoiceBranch(this.getId(), Choices);
			break;
		case 2:
			selfswitch1=true;
			stage=0;
			break;
		}
		
		
	}
	
	public int getfinalstage() {
		return finalstage;
	}

	public int getstage() {
		return stage;
	}


	public void setstage(int stage) {
		EventSafe5.stage = stage;
	}

	public void ChoiceMade(int i){
		switch(i){
		case 0:
			super.transport("/Worlds/LightRoom.txt", 1, 19,"???");
//			super.Dialog(215, 215,this.getId());
			break;
		case 1:
			super.Dialog(216, 216,this.getId());
			break;
		}
	}
	
	public boolean isSolid(){
		return true;
	}
}
