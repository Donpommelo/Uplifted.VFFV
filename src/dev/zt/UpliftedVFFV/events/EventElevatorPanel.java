package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.party.PenPal;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class EventElevatorPanel extends Event {

	public boolean selfswitch1=false;					//whether employeeIntro has left the elevator yet
	public boolean selfswitch2=false;					//whether the Pen Pal's floor has been recruited yet 
	public String[] Choices={"1: Reception","2: Bathhouse","3: Offices","4: Aquarium","5: Management","6: Food Services","7: Infirmary","8: Orchestral Cathedral","9: Little America","11: Justice Park","12: Gallery of Lights"};
	public static int stage=0;
	public static int finalstage=1;

	public EventElevatorPanel(float x, float y, int idnum) {
		super(Assets.ElevatorPanel,idnum,x, y);
	
	}
	

	
	public void run(){	
//		System.out.print(stage);
		if(!Event.events[40].isSelfswitch1() && Event.events[65].isSelfswitch1()){		//if EmployeeIntro has already left + Pen
																						//Pal has not been talked to, nothing happens
		}
		else{
			switch(stage){													//if Pen Pal had been recruited, panel cannot be used until
			case 0: 														//tutorial is over + Jorge beaten
				if(this.isSelfswitch2()){
					super.Dialog(97, 97,this.getId());
				}
				else{														//otherwise choices are present.
					super.Dialog(63, 63,this.getId());					
					super.ChoiceBranch(this.getId(), Choices,200);
				}
				break;
			case 1:
				if(this.isSelfswitch2()){										//if Pen Pal has been recruited, its event is erased
					Event.events[40].setDrawn(false);
					super.transport("/Worlds/SouthElevator.txt", 4, 4,"");
				}
				stage=0;
				break;
			}
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
//		if(elevatorOn){										
			
//		}
		
		if(!Event.events[40].isSelfswitch1()){
			if(!Event.events[65].isSelfswitch1()){
				if(i == 5){
					super.screenShake(50);
//					GameState.setFloor(6);
					Event.events[65].run();	
					this.setSelfswitch1(true);
				}
				else{
					super.Dialog(28,28,this.getId());
				}
			}
		}
		else{
			if(Event.events[40].isSelfswitch1()){
				switch(i){
				case 0:
					super.Dialog(28,28,this.getId());
					break;
				case 1:
					super.Dialog(28,28,this.getId());
					break;
				case 2:
					super.screenShake(50);
					super.Dialog(18,26,this.getId());
					super.recruit(new PenPal());
					this.setSelfswitch2(true);
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
			
		}
		
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
