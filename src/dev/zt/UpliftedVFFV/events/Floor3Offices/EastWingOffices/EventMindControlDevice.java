package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventMindControlDevice extends Event {

	public String[] Choices={"Never Mind","0","1","2","3","4","5","6","7","8"};			//list of choices used in the choicebranch

	public static int stagenum = 1;
	//Change texture later
	public static BufferedImage img=Assets.Monolith;
	public EventMindControlDevice(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		switch(this.getstage()){
		case 0: 
			if(this.isSelfswitch1()){
				this.setSelfswitch1(true);
				Dialog[] d1 = new Dialog[5];
				d1[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"What is this thing?/");
				d1[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"I think I've seen these before./They're designed to emit mind-altering waves that can have all manner of effects/on the psyches of nearby entities./");
				d1[2] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Although it is strange to see one here. . .//Hey! Look, an instruction manual!/");
				d1[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"'East Wing Mind-Control Device/To use, set dial to desired frequency.'/");
				d1[4] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"'CAUTION. While waves are inaudible to Employees, Monsters may become enraged and/more aggressive!'/");
				super.Dialog(d1, 4, this.getId(), true);
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A Monster-Angering Device./");
				super.Dialog(d1, 0, this.getId(), true);
			}
			break;		
		case 1:
			int dial = super.getVar(13);
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Set Dial? Current Level: "+dial+".");
			super.Dialog(d1, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices);
			break;
		}
	}

	public void ChoiceMade(int i){
		if(i == 0){
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You decide not to mess with the device./");
			super.Dialog(d1, 0, this.getId(), true);
			}
		else if(i-1 == super.getVar(13)){
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You keep the dial set the way it is./");
			super.Dialog(d1, 0, this.getId(), true);
			}
		else if(i-1 > super.getVar(13)){
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You turn the dial up./You faintly hear a high-pitched noise./");
			super.Dialog(d1, 0, this.getId(), true);
			}
		else if(i-1 < super.getVar(13) && i !=0 ){
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You turn the dial down./The building feels quieter./");
			super.Dialog(d1, 0, this.getId(), true);
			}
		if(i !=0){
			super.setVar(13, i-1);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
