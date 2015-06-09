package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class EventEmployee44 extends Event {

	public boolean selfswitch1=false;
	public static int stage=0;						
	public static int finalstage=1;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM2);
	public EventEmployee44(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
	

	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM2));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM2));
		}
		switch(stage){
		case 0: 
			super.Dialog(250, 250,this.getId());
			break;
		case 1:
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
			stage = 0;
			break;
			
		}
		

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public int getfinalstage() {
		return finalstage;
	}
	



	public int getstage() {
		return stage;
	}


	public void setstage(int stage) {
		EventEmployee44.stage = stage;
	}
}
