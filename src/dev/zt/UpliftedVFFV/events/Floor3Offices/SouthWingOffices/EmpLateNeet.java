package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpLateNeet extends Event {

	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM2);
	public EmpLateNeet(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM2));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM2));
		}
		Dialog[] d = new Dialog[1];
		d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I regret taking for granted my long hours of unemployed freetime./");
		super.Dialog(d, 0, this.getId(), true);	}

	public boolean isSolid(int i){
		return true;
	}
}
