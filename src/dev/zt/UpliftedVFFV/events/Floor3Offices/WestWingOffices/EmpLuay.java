package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpLuay extends Event {

	public static int stagenum = 1;			
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EmpLuay(float x, float y, int idnum) {
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
			if(!this.isSelfswitch1()){
				this.setSelfswitch1(true);
				Dialog[] d = new Dialog[3];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-1.png",1,"Do you know how West Wing Offices manages its high rate of productivity?/");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-1.png",1,"By making necessary sacrifices./");
				d[2] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained the Sleepytime Surprise!/");
				super.Dialog(d, 2, this.getId(), true);
			}
			else{
				this.setSelfswitch1(true);
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-1.png",1,"Sleep eludes me, but this quarter's report shall not./");
				super.Dialog(d, 0, this.getId(), true);
			}
			
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}


	public boolean isSolid(int i){
		return true;
	}
	
}
