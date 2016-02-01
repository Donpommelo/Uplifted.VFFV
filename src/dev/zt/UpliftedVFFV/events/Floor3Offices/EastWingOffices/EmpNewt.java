package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.NewtonCradle;



public class EmpNewt extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EmpNewt(float x, float y, int idnum) {
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
				Dialog[] d = new Dialog[3];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Have you ever stolen something from a coworker, only to realize you didn't want it?/");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Anyways, why don't you take this?/And don't tell anyone I gave it to you./");
				d[2] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained the Newton's Cradle!/");
				super.Dialog(d, 2, this.getId(), true);	
				super.loot(new NewtonCradle(), 1);
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
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Sometimes, it's enough that others have less./");
			super.Dialog(d, 0, this.getId(), true);
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
			this.setstage(1);
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}

}
