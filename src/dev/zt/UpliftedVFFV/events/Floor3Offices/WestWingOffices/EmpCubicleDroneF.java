package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpCubicleDroneF extends Event {

	public static int stagenum = 0;			
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeF);
	public EmpCubicleDroneF(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		Dialog[] d = new Dialog[1];
		d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,". . ./");
		super.Dialog(d, 0, this.getId(), true);
		
	}


	public boolean isSolid(int i){
		return true;
	}
	
}
