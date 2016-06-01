package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventWaterDrainLeverWest extends Event {

	public String[] Choices={"Sure, why not?","Wait, no!"};			//list of choices used in the choicebranch
	public static int stagenum = 1;
	//Change texture later
	public static BufferedImage img=Assets.Monolith;
	public EventWaterDrainLeverWest(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				this.setSelfswitch1(true);
				switch(super.getVar(23)){
				case 0:
					Dialog[] d1 = new Dialog[3];
					d1[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hey, look at that. A lever./");
					d1[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Interesting. Wanna pull it?/");
					d1[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I'm pretty fond of levers./");
					super.Dialog(d1,2, this.getId(), true);
					break;
				case 1:
					Dialog[] d2 = new Dialog[3];
					d2[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hey, look at that. Another lever./");
					d2[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Hmm. The last time we pushed one of these, nothing terrible happened . . ./");
					super.Dialog(d2,1, this.getId(), true);
					break;
				case 2:
					Dialog[] d3 = new Dialog[3];
					d3[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hopefully this is the last lever.");
					d3[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Lets pull it quickly and get this quest over with./");
					super.Dialog(d3, 1, this.getId(), true);
					break;
				}
			}
			else{
				if(super.getQuest(8) == 0){
					Dialog[] d1 = new Dialog[1];
					d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",0,"It's a lever connected to an elaborate looking machine./");
					super.Dialog(d1, 0, this.getId(), true);
				}
				else{
					Dialog[] d1 = new Dialog[1];
					d1[0] = new Dialog("meep","/CharacterBusts/Artur0.png",0,"West Water Pump./Controls flow of water in and out of pressurized chamber./");
					super.Dialog(d1, 0, this.getId(), true);
				}
			}
			break;		
		case 1:
			Dialog[] d1 = new Dialog[1];
			if(!super.getSwitch(28)){
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Turn OFF?/");
			}
			else{
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Turn ON?/");
			}
			super.Dialog(d1, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices, 100);
			break;
		}
	}

	public void ChoiceMade(int i){
		if(i == 0){
			if(super.getSwitch(30)){
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You turn the pump OFF./Water drains from the clear chamber./");
				super.Dialog(d, 1, this.getId(), true);
			}
			else{
				if(super.getVar(23) == 2){

					if(super.getQuest(8) > 0){
						Dialog[] d1 = new Dialog[3];
						d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You turn the pump ON./Water fills the clear chamber. You see a Dolphin pass through the pipes./");
						d1[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hey, that pipe doesn't lead back to the Ringmaster. It seems to go further West . . ./");
						d1[2] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Odd. Should we be on the lookout for more drain switches?/");
						super.Dialog(d1, 2, this.getId(), true);
					}
					else{
						Dialog[] d1 = new Dialog[1];
						d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You turn the pump ON./Water fills the clear chamber. You see a Dolphin pass through the pipes./");
						super.Dialog(d1, 0, this.getId(), true);
					}
					super.setVar(23, 3);
					if(super.getSwitch(31)){
						super.setVar(23, 4);
					}
				}
				else{
					Dialog[] d2 = new Dialog[1];
					d2[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You turn the pump ON./Water fills the clear chamber. You see a Dolphin pass through the pipes./");
					super.Dialog(d2, 1, this.getId(), true);
				}
			}
			super.setSwitch(30, !super.getSwitch(8));
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
