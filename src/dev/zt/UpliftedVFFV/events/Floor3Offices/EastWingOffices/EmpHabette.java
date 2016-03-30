package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpHabette extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeF);
	public EmpHabette(float x, float y, int idnum) {
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
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Hmm? You're still around?");
			switch(super.getQuest(5)){
			case 0:
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"See you around.");
				break;
			case 1:
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Attaboy.");
				break;
			case 2:
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Look at you go.");
				break;
			case 3:
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Halfway there.");
				break;
			}
			super.Dialog(d, 0, this.getId(), true);
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
			this.setstage(0);
			break;
			
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
