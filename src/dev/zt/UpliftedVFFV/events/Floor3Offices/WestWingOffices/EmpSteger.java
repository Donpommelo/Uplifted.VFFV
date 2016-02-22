package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpSteger extends Event {

	public static int stagenum = 1;			
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeF);
	public EmpSteger(float x, float y, int idnum) {
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

			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"To the South is a Bus Stop that can take you to East Offices if you'd like./It is a useful shortcut for those who travel frequently./");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"The less time spent commuting, the more productive the employee./");
			super.Dialog(d, 1, this.getId(), true);

			
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
