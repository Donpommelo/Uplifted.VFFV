package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpWalker extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeF);
	public EmpWalker(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
		}
		
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"What are you guys doing?/");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Oh, we were just taking a short break from working hard./I thought a couple of games would bring back our laboring spirits./");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"The game is called The Neverending Walk of Self-Improvement./Its this dungeon-crawlwe about a depressed guy who descends into the Labyrinth in/search of spiritual fufillment./");
				d[3] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"I'd let you take a controller after this game ends, but as the name suggests,/the game never ends./");
				super.Dialog(d, 3, this.getId(), true);
				this.setSelfswitch1(true);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Any break that I'd need to take a break from doesn't count in my book./");
				super.Dialog(d, 0, this.getId(), true);

			}
			
			break;
		case 1:
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
			this.setstage(0);
			break;
			
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
