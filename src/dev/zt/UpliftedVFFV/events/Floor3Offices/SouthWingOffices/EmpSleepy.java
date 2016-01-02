package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.consummables.SmellingSalt;



public class EmpSleepy extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(4,Assets.EmployeeF);
	public EmpSleepy(float x, float y, int idnum) {
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
		
		if(!this.isSelfswitch1()){
			switch(this.getstage()){
			case 0: 
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Aw shucks. Just my luck./");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"I left my phone in this room, but when I came back to get it, there was a meeting going/on that I was supposed to attend, and now I'm stuck here./");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Hey, why don't you take one of these?/I always keep a couple on me in case I pass out from boredom./");
				d[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You Obtained the Smellingsalt!/Consume to revive incapacitated allies!/");
				super.Dialog(d, 3, this.getId(), true);	
				super.loot(new SmellingSalt(), 1);
				break;
			case 1:
				Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
				this.setSelfswitch1(true);
				this.setstage(0);
				break;
			}
		
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"You'll need those Smellingsalts to stay awake if you're here for the meeting./");
			super.Dialog(d, 0, this.getId(), true);
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
			this.setstage(1);
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}

}
