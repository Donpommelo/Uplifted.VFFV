package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpLite extends Event {

	public static int stagenum = 1;			
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeF);
	public EmpLite(float x, float y, int idnum) {
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
			d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"It is the work that has no purpose that demonstrates true discipline.");
			super.Dialog(d, 0, this.getId(), true);

			
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
