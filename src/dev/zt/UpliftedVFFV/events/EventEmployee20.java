package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


//This is commented as an example of slightly more complex event processing.
//This contains a choicebranch that branches into different dialog and event running
public class EventEmployee20 extends Event {

	public boolean selfswitch1=false;				//selfswitches do exactly what they did in rpgmaker. except i can name them funny things if i want
	public String[] Choices={"Yes","No"};			//list of choices used in the choicebranch
	public static int stage=0;						//stage is the variable that determines which stage the event is in
	public static int finalstage=2;					//finalstage determines the maximum amount of stages
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
			
			//This is the dialog that first occurs when the npc is spoken to
			case 0: 
				super.Dialog(88, 89,this.getId());
				break;
				
			//when a dialogstate is done running, it will increment the event stage if possible, the rerun the event.
			//this allow for the event to consist of many different parts.
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
			stage=2;
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
