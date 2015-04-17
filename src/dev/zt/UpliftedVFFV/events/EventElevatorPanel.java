package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class EventElevatorPanel extends Event {

	public boolean selfswitch1=false;
	public String[] Choices={"1","2","3","4","5","6","7","8","9","11","12","Violence"};
	public static int stage=0;
	public static int finalstage=1;

	public EventElevatorPanel(float x, float y, int idnum) {
		super(Assets.ElevatorPanel,idnum,x, y);
	
	}
	

	
	public void run(){	
//		System.out.print(stage);
		switch(stage){
		case 0: 
			super.Dialog(63, 63,this.getId());
			super.ChoiceBranch(this.getId(), Choices);
			break;
		case 1:
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
		EventElevatorPanel.stage = stage;
	}



	public void ChoiceMade(int i){
		switch(i){
		case 0:
			super.Dialog(28,28,this.getId());
			break;
		case 1:
			super.Dialog(28,28,this.getId());
			break;
		case 2:
			super.Dialog(28,28,this.getId());
			break;
		case 3:
			super.Dialog(28,28,this.getId());
			break;
		case 4:
			super.Dialog(28,28,this.getId());
			break;
		case 5:
			super.Dialog(28,28,this.getId());
			break;
		case 6:
			super.Dialog(28,28,this.getId());
			break;
		case 7:
			super.Dialog(28,28,this.getId());
			break;
		case 8:
			super.Dialog(28,28,this.getId());
			break;
		case 9:
			super.Dialog(28,28,this.getId());
			break;
		case 10:
			super.Dialog(28,28,this.getId());
			break;
		case 11:
			super.Dialog(28,28,this.getId());
			break;

		}
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
