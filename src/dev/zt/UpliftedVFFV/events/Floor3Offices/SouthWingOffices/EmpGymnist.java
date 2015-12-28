package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpGymnist extends Event {
	
	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EmpGymnist(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
		
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM1));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1));
		}
		switch(this.getstage()){
		case 0: 
			Dialog[] d = new Dialog[3];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I. . . I've done it! Oh, this is wonderful!/");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"What happened?/");
			d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I've finally succeeded in tricking myself into believing I've accomplished something great./Hah. Classic./");
			super.Dialog(d, 2, this.getId(), true);
			break;
		case 1:
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
