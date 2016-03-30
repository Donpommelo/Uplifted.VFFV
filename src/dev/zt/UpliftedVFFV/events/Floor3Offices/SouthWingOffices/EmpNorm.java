package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpNorm extends Event {
	
	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EmpNorm(float x, float y, int idnum) {
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
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I could have sworn my cubical was here yesterday, but now there seems to be a hallway instead.");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I wonder if this is some sort of practical joke.");
			super.Dialog(d, 1, this.getId(), true);
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
