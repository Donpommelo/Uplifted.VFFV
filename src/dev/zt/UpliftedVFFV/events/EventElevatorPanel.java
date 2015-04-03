package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class EventElevatorPanel extends Event {

	public boolean selfswitch1=false;
	public String[] Choices={"1","2","3","4","5","6","7","8","9","11","12","Violence"};
	public EventElevatorPanel(float x, float y, int idnum) {
		super(Assets.ElevatorPanel,idnum,x, y);
	
	}
	

	
	public void run(){	
		super.Dialog(24, 24);
		
		super.ChoiceBranch(this.getId(), Choices);
		
		

			
			
	}
	
	public void ChoiceMade(int i){
		switch(i){
		case 0:
			super.Dialog(26,27);
			break;
		case 1:
			super.Dialog(28,29);
			break;
		case 2:
			super.Dialog(30,31);
			break;
		case 3:
			super.Dialog(32,33);
			break;
		case 4:
			super.Dialog(34,35);
			break;
		case 5:
			super.Dialog(36,37);
			break;
		case 6:
			super.Dialog(38,39);
			break;
		case 7:
			super.Dialog(40,43);
			break;
		case 8:
			super.Dialog(44,45);
			break;
		case 9:
			super.Dialog(46,49);
			break;
		case 10:
			super.Dialog(50,53);
			break;
		case 11:
			super.Dialog(54,56);
			break;

		}
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
