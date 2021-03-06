package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

//This is commented as an example of slightly more complex event processing.
//This contains a choicebranch that branches into different dialog and event running
public class EmpCooley extends Event {

	public String[] Choices={"Yes","No"};			//list of choices used in the choicebranch
	public static int stagenum = 2;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EmpCooley(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM1));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1));
		}
		if(!this.isSelfswitch1()){
			switch(this.getstage()){
			
			//This is the dialog that first occurs when the npc is spoken to
			case 0: 
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I reckon the more time I waste at this water cooler, the less work I have to do.");
				super.Dialog(d1, 0, this.getId(), true);
				break;
				
			//when a dialogstate is done running, it will increment the event stage if possible, then rerun the event.
			//this allow for the event to consist of many different parts.
			case 1:
				Dialog[] d2 = new Dialog[1];
				d2[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Say, wanna learn something cool?");
				super.Dialog(d2, 0, this.getId(), true);
				super.ChoiceBranch(this.getId(), Choices, 100);
				break;
			case 2:
				
				this.setstage(0);
			}
		}
		else{
			Dialog[] d2 = new Dialog[1];
			d2[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"If you get attacked by a Red-Aligned enemy, don't forget to stop, drop and roll.");
			super.Dialog(d2, 0, this.getId(), true);
			this.setstage(2);
		}
	}

	public void ChoiceMade(int i){
		switch(i){
		case 0:
			Dialog[] d = new Dialog[11];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Many abilities and creatures are aligned to one of several elements. These elements are color-coded for your convenience.");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Do you see the Blue tab on this water cooler?/When pressed, a stream of cold water comes out.");
			d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"This is because coldness and water are commonly associated with the Blue element . . .");
			d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I see.");
			d[4] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Likewise, the Red tab represents the Red elemental alignment.");
			d[5] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"That's why, when pressed, it releases a destructive gout of fire.");
			d[6] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"There are several other elements, each with their own unique abilities, strengths and weaknesses.");
			d[7] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"A character's affinity for an element can be measured by his Color Points. Your Color Points can be examined from the menu under 'Party'.");
			d[8] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Each Color Point improves the effectiveness of skills of that color, as well as affecting your Elemental Resistances. Boost any one Color enough and become Elementally Aligned!");
			d[9] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Elementally Aligned units receive a boost when using abilities of the same color, as well as gaining special, elementally infused standard attacks!");
			d[10] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Well . . . that's all I got. Time to go back to counting wrinkles on the carpet.");
			super.Dialog(d, 10, this.getId(), true);
			this.setSelfswitch1(true);
			break;
		case 1:
			Dialog[] d2 = new Dialog[1];
			d2[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Oh. Well, if you change your mind, I'll probably still be here.");
			super.Dialog(d2, 0, this.getId(), true);
			break;
		}
	}

	public boolean isSolid(int i){
		return true;
	}
}
