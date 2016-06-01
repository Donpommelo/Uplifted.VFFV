package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpGoodman extends Event {

	public static int stagenum = 1;			
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EmpGoodman(float x, float y, int idnum) {
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
			d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-1.png",1,"This company was founded on a basis of selflessness and community.");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-1.png",1,"Those in the present must toil if a better world is to be inherited by those of the future.");
			d[2] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-1.png",1,"Those in the past who sacrificed then as we do now must be remembered and revered. Otherwise stability and security may be taken for granted.");
			super.Dialog(d, 2, this.getId(), true);
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
