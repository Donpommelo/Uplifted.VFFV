package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpBusdon extends Event {
	
	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EmpBusdon(float x, float y, int idnum) {
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
			Dialog[] d = new Dialog[3];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"The employee Super-Speed transport shuttle sure is useful to get from place to place. Sometimes I even forget I'm in a bus at all.");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"The bus works by reading the minds of its passengers and preemptively moving to their desired destination.");
			d[2] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"If you walk in with no destination in mind, then . . . Well, I don't really know. Never happens to me. I'm too purposeful.");
			super.Dialog(d,2, this.getId(), true);
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
