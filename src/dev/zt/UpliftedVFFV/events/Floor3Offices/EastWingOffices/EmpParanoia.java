package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.FaithlessCloak;
import dev.zt.UpliftedVFFV.inventory.equipables.Paperweight;
import dev.zt.UpliftedVFFV.inventory.equipables.UsurpersChemSet;



public class EmpParanoia extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EmpParanoia(float x, float y, int idnum) {
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
			case 0: 
				Dialog[] d = new Dialog[5];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"You c . . . can't trust anyone around here!/");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"They're all a bunch of. . . backstabbing, lying, self-serving. . ./");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"I swear, I'm getting relocated to South Offices by the end of next quarter./I can't take this anymore./");
				d[3] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"You seem like a nice enough fellow./I don't know what you're doing around here, but you should take this./");
				d[4] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained the Faithless Cloak!/");
				super.Dialog(d, 4, this.getId(), true);	
				super.loot(new FaithlessCloak(), 1);
				break;
			case 1:
				this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
				this.setSelfswitch1(true);
				this.setstage(0);
				break;
			}
		
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Hopefully I won't need this at my next job./");
			super.Dialog(d, 0, this.getId(), true);
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
			this.setstage(1);
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}

}
