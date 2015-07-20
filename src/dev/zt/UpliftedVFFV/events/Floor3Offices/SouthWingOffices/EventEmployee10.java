package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EventEmployee10 extends Event {

	public boolean selfswitch1=false;
	public static int stage=0;						
	public static int finalstage=1;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeF);
	public EventEmployee10(float x, float y, int idnum) {
		super(img,idnum,x, y);
	}
	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
		}
		
		switch(stage){
		case 0: 
			super.Dialog(77, 77,this.getId());
			break;
		case 1:
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
			stage = 0;
			break;
			
		}
	}


	public boolean isSolid(int i){
		return true;
	}
	
	public int getfinalstage() {
		return finalstage;
	}
	
	public int getstage() {
		return stage;
	}

	public void setstage(int stage) {
		EventEmployee10.stage = stage;
	}
}
