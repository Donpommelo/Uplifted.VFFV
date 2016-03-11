package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.AquariumPass;

public class EventPassChecker extends Event {

	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EventPassChecker(float x, float y, int idnum) {
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
		switch(this.getstage()){
		case 0: 
			if(super.itemNumCheck(new AquariumPass()) == 0){
				if(!this.isSelfswitch1()){
					Dialog[] d = new Dialog[6];
					d[0] = new Dialog("Ticket Checker","/CharacterBusts/3rdSouthOffices-1.png",1,"Hello there! Welcome to the Aquarium! Do you have an aquarium pass?/");
					d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"An Aquarium pass?/");
					d[2] = new Dialog("Ticket Checker","/CharacterBusts/3rdSouthOffices-1.png",1,"Necessary measure kid. Can’t let ya in without one./Otherwise everyone would be here, and then no work would get done./");
					d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Where can I get an aquarium pass?/");
					d[4] = new Dialog("Ticket Checker","/CharacterBusts/3rdSouthOffices-1.png",1,"Heh, well I work here, so I’m the only person in this building who doesn’t need one./Guess that makes me the worst person to ask that question to./");
					d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I'll look around . . ./");
					super.Dialog(d, 5, this.getId(), true);
					this.setSelfswitch1(true);
				}
				else{
					Dialog[] d = new Dialog[2];
					d[0] = new Dialog("Ticket Checker","/CharacterBusts/3rdSouthOffices-1.png",1,"If you don't have an Aquarium Pass, I can't let you into the Aquarium Tunnel./");
					d[1] = new Dialog("Ticket Checker","/CharacterBusts/3rdSouthOffices-1.png",1,"Please have one before you return./It breaks my heart a little every time I have to turn you down./");
					super.Dialog(d, 1, this.getId(), true);
				}
			}
			else{
				if(!this.isSelfswitch1()){
					Dialog[] d = new Dialog[5];
					d[0] = new Dialog("Ticket Checker","/CharacterBusts/3rdSouthOffices-1.png",1,"Hello there! Welcome to the Aquarium! Do you have an aquarium pass?/");
					d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"An Aquarium pass?/");
					d[2] = new Dialog("Ticket Checker","/CharacterBusts/3rdSouthOffices-1.png",1,"Necessary measure kid. Can’t let ya in without one./Otherwise everyone would be here, and then no work would get done./");
					d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Do you mean like this one here?/");
					d[4] = new Dialog("Ticket Checker","/CharacterBusts/3rdSouthOffices-1.png",1,"Yeah! That's it! That means you can enter the Aquarium Tunnel now!/Enjoy the exhibit. Oh, and don't spoil the ending for me./I haven't seen it yet!/");
					super.Dialog(d, 4, this.getId(), true);
					this.setSelfswitch1(true);
				}
				else{
					Dialog[] d = new Dialog[1];
					d[0] = new Dialog("Ticket Checker","/CharacterBusts/3rdSouthOffices-1.png",1,"Enjoy the Aquarium Tunnel./But not too much! Your coworkers still need you!/");
					super.Dialog(d, 0, this.getId(), true);
				}
			}
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}
	
	
	public boolean isSolid(int i){
		return true;
	}
		
}
