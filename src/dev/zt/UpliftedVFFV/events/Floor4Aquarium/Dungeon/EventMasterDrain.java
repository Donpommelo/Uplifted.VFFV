package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventMasterDrain extends Event {

	public String[] Choices={"None of them","South Drain","East Drain","West Drain","Master Drain"};			//list of choices used in the choicebranch
	public static int stagenum = 1;
	//Change texture later
	public static BufferedImage img=Assets.Monolith;
	public EventMasterDrain(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				this.setSelfswitch1(true);
				Dialog[] d1 = new Dialog[2];
				d1[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"This lever looks like all the others./But more important.");
				d1[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"There seem to be additional options./Wanna try one?/");
				super.Dialog(d1,1, this.getId(), true);
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("meep","/CharacterBusts/Artur0.png",0,"Master Water Pump./Controls flow of water in and out of pressurized chamber./");
				super.Dialog(d1, 0, this.getId(), true);
				
			}
			break;		
		case 1:
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Pull which lever?/");
			if(super.getSwitch(28)){
				Choices[1] = "South Drain (Off)";
			}
			else{
				Choices[1] = "South Drain (On)";
			}
			if(super.getSwitch(29)){
				Choices[2] = "East Drain (Off)";
			}
			else{
				Choices[2] = "East Drain (On)";
			}
			if(super.getSwitch(30)){
				Choices[3] = "West Drain (Off)";
			}
			else{
				Choices[3] = "West Drain (On)";
			}
			if(super.getSwitch(31)){
				Choices[4] = "Master Drain (Off)";
			}
			else{
				Choices[4] = "Master Drain (On)";
			}
			super.Dialog(d1, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices, 500);
			break;
		}
	}

	public void ChoiceMade(int i){
		if(i == 0){
			int drainPulled = i + 27;
			super.setSwitch(drainPulled, !super.getSwitch(drainPulled));
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You pull the switch./You hear the sound of rushing water elsewhere.");
			super.Dialog(d1, 0, this.getId(), true);
		}
		if(i == 4 && super.getVar(23)==3){
			super.setVar(23, 4);
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You see a Dolphin pass through the pipes.");
			super.Dialog(d1, 0, this.getId(), true);
		}
		if(i==4){
			if(super.getSwitch(31)){
				super.setSwitch(34, true);
			}
			else{
				super.setSwitch(34, false);
			}
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
