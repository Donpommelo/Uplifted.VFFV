package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.TheTentativelyNamedFiles;


public class EmpAshli extends Event {

	public static int stagenum = 1;			
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeF);
	public EmpAshli(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
		}
		
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				this.setSelfswitch1(true);
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"Files . . ./");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"Deliver . . ./");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,". . . take . . ./");
				d[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained The <> Files!/");
				super.Dialog(d, 3, this.getId(), true);
				super.loot(new TheTentativelyNamedFiles(), 1);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,". . ./");
				super.Dialog(d, 0, this.getId(), true);
			}
			
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
			this.setstage(0);
			break;
			
		}
	}


	public boolean isSolid(int i){
		return true;
	}
	
}
