package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventRingMaster extends Event {

	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EventRingMaster(float x, float y, int idnum) {
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
			if(!this.isSelfswitch1()){
				Dialog[] d = new Dialog[9];
				d[0] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"Oh . . . this is terrible. Whatever will we do?");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Excuse me sir, is there a problem?");
				d[2] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"The Dolphin performances! They're doomed! Oh, surely my employment is finished.");
				d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Woah, calm down. Are the . . . dolphins missing?");
				d[4] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"Even worse. They've unionized!");
				d[5] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"Higher wages, better working conditions . . . Their demands are ridiculous!");
				d[6] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"I called in a Dolphin Strikebreaker to resolve the problem, but he hasn't shown up yet. Probably intimidation.");
				d[7] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"Typical strongarm union tactics . . ./Hey, if you see the guy, bring him to me, will you?");
				d[8] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"<Quest Text>");
				super.Dialog(d, 8, this.getId(), true);
				
				super.setQuest(8, 1);
				this.setSelfswitch1(true);
			}
			else{
				if(super.getVar(23) == 4){
					if(this.isSelfswitch2()){
						Dialog[] d = new Dialog[2];
						d[0] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"<TEMP>");
						d[1] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"<Write stuff later>");
						super.Dialog(d, 1, this.getId(), true);
					}
					else{
						Dialog[] d = new Dialog[4];
						d[0] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"Oh it's you!/You'll be delighted to know that the Dolphin Strikebreaker turned up eventually!");
						d[1] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"Sadly, he's gotten a bad bout of pneumonia from all the ruckus and the show will have to be cancelled anyways.");
						d[2] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"But at least he's alive and safe. That was your doing, no? You should take this as a token of gratitude nonetheless.");
						d[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You Obtained ...");
						this.setSelfswitch2(true);
						super.Dialog(d, 3, this.getId(), true);
					}
				}
				else{
					Dialog[] d = new Dialog[2];
					d[0] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"Any luck finding the Strikebreaker? I don't know how much longer we can amuse this crowd otherwise.");
					d[1] = new Dialog("Ringmaster","/CharacterBusts/3rdSouthOffices-1.png",1,"Just let him know that Management is on our side. Those communist union thugs can't hurt him.");
					super.Dialog(d, 1, this.getId(), true);
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
