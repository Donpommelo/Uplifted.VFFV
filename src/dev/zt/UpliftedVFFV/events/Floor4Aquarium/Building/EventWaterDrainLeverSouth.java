package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventWaterDrainLeverSouth extends Event {

	public String[] Choices={"Sure, why not?","Wait, no!"};			//list of choices used in the choicebranch
	public static int stagenum = 1;
	//Change texture later
	public static BufferedImage img=Assets.Monolith;
	public EventWaterDrainLeverSouth(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				this.setSelfswitch1(true);
				if(super.getQuest(8) == 0){
					Dialog[] d1 = new Dialog[4];
					d1[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hey, what does this lever do?/");
					d1[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"No idea. Maybe it's a part of the exhibit?/");
					d1[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Should I pull it?/");
					d1[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"If you want./I'm sure Management would've roped it off if it was dangerous./");
					super.Dialog(d1, 3, this.getId(), true);
				}
				else{
					Dialog[] d1 = new Dialog[3];
					d1[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hey, what does this lever do?/");
					d1[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"No idea. Hey! Is that a dolphin inside that tank?/That must be the Strikebreaker that the Ringmaster was looking for!/");
					d1[2] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"The Dolphin Unionizers must've thrown him in here to make their demands heard!/I wonder if pulling that lever will help . . ./");
					super.Dialog(d1, 2, this.getId(), true);
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
					d1[0] = new Dialog("meep","/CharacterBusts/Artur0.png",0,"South Water Pump./Controls flow of water in and out of pressurized chamber./");
					super.Dialog(d1, 0, this.getId(), true);
				}
			}
			break;		
		case 1:
			Dialog[] d1 = new Dialog[1];
			if(super.getSwitch(28)){
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
			Dialog[] d1 = new Dialog[1];
			if(super.getSwitch(28)){
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You turn the pump OFF./Water drains from the clear chamber./");
			}
			else{
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You turn the pump ON./Water fills the clear chamber./");
			}
			super.setSwitch(28, !super.getSwitch(8));
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
