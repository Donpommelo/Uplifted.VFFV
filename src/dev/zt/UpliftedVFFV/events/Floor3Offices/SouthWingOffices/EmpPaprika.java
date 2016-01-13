package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.Paperweight;



public class EmpPaprika extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeF);
	public EmpPaprika(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		}
		if (Player.runlast==1){
			Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
		}
		if (Player.runlast==2){
			Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
		}
		if (Player.runlast==3){
			Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
		}
		
		if(!this.isSelfswitch1()){
			switch(this.getstage()){
			case 0: 
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Oh no. My paperwork is trapped underneath an insurmountably heavy boulder./");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Surely it would be unreasonable to expect me to work given the circumstances./");
				d[2] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You Obtained the Paperweight!/Equipment can be used from the menu!/");
				d[3] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Hey!  I . . .uh. . .thanks. . ./");
				super.Dialog(d, 3, this.getId(), true);	
				super.loot(new Paperweight(), 1);
				break;
			case 1:
				Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
				this.setSelfswitch1(true);
				this.setstage(0);
				break;
			}
		
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Drat. All my paperwork blew away./");
			super.Dialog(d, 0, this.getId(), true);
			Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
			this.setstage(1);
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}

}
