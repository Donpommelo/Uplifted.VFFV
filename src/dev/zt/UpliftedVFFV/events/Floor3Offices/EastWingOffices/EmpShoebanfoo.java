package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.Paperweight;
import dev.zt.UpliftedVFFV.inventory.equipables.UsurpersChemSet;



public class EmpShoebanfoo extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EmpShoebanfoo(float x, float y, int idnum) {
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
				Dialog[] d = new Dialog[6];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Rrrgh. That Carloc . . .Who does she think she is?");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Bossing us around like that. . . I swear one of these days. . ./I'm going to . . ./");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,". . .Oh./I . . . uh. . . didn't see you there.");
				d[3] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"You. . . aren't going to tell Carloc I said anything, right?/Please?/");
				d[4] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"What if I give you something?/Uh. . . here! Yeah, take this. Just don't say anything to Carloc./");
				d[5] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained the Usurper's Chemistry Set!/");
				super.Dialog(d, 5, this.getId(), true);	
				super.loot(new UsurpersChemSet(), 1);
				break;
			case 1:
				this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
				this.setSelfswitch1(true);
				this.setstage(0);
				break;
			}
		
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"You didn't mention this me to Carloc, did you?/No, you must not have. I feel like I would be able to tell./");
			super.Dialog(d, 0, this.getId(), true);
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
			this.setstage(1);
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}

}
