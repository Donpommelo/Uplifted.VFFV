package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class EventEmployee20 extends Event {

	public boolean selfswitch1=false;
	public String[] Choices={"Yes","No"};
	public static int stage=0;
	public static int finalstage=2;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EventEmployee20(float x, float y, int idnum) {
		super(img,idnum,x, y);
	
	}
	

	
	public void run(){	
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM1));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1));
		}
		if(selfswitch1==false){
			switch(stage){
			case 0: 
				super.Dialog(88, 89,this.getId());
				break;
			case 1:
				super.Dialog(90, 90,this.getId());
				super.ChoiceBranch(this.getId(), Choices);
				break;
			case 2:
				selfswitch1=true;
				stage=0;
			}
		}
		else{
			super.Dialog(88, 88,this.getId());
		}
			
			
	}
	
	public int getfinalstage() {
		return finalstage;
	}
	



	public int getstage() {
		return stage;
	}


	public void setstage(int stage) {
		EventEmployee20.stage = stage;
	}



	public void ChoiceMade(int i){
		switch(i){
		case 0:
			super.Dialog(91,92,this.getId());
			super.loot(new FishWater(), 1);
			break;
		case 1:
			super.Dialog(93,93,this.getId());
			break;
		}
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
