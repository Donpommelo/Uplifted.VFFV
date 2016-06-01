package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpLiang extends Event {

	public static int stagenum = 1;			
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EmpLiang(float x, float y, int idnum) {
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
			d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-1.png",1,"Originally, we had a receptionist here to great newcomers to the offices.");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-1.png",1,"But we decided that was not the most productive use of office space. So now I work here instead.");
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
