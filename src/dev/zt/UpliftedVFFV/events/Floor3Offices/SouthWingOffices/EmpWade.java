package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.misc.FishWater;

//This is commented as an example of slightly more complex event processing.
//This contains a choicebranch that branches into different dialog and event running
public class EmpWade extends Event {

	public String[] Choices={"Yes","No"};			//list of choices used in the choicebranch
	public static int stagenum = 2;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EmpWade(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
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
		if(!this.isSelfswitch1()){
			switch(this.getstage()){
			
			//This is the dialog that first occurs when the npc is spoken to
			case 0: 
				super.Dialog(88, 89,this.getId());
				break;
				
			//when a dialogstate is done running, it will increment the event stage if possible, then rerun the event.
			//this allow for the event to consist of many different parts.
			case 1:
				Dialog[] d = new Dialog[3];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Splash. Splash./");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Why is your cubical filled with water?/");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I got it as a souvenir from the Aquarium. Want some?/");
				super.Dialog(d, 2, this.getId(), true);
				super.ChoiceBranch(this.getId(), Choices);
				break;
			case 2:
				Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
				this.setSelfswitch1(true);
				this.setstage(0);
			}
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Water sure is great./");
			super.Dialog(d, 0, this.getId(), true);
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
			this.setstage(2);
		}
	}

	public void ChoiceMade(int i){
		switch(i){
		case 0:
			Dialog[] d1 = new Dialog[2];
			d1[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Here you go. Enjoy./");
			d1[1] = new Dialog("meep","/CharacterBusts/Arturo.png",0,"You Obtained Fishwater!/Fresh from the Fourth Floor Aquarium!./");
			super.Dialog(d1, 1, this.getId(), true);
			super.loot(new FishWater(), 1);
			break;
		case 1:
			Dialog[] d2 = new Dialog[2];
			d2[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Suit yourself./");
			super.Dialog(d2, 1, this.getId(), true);
			break;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
