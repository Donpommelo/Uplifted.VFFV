package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.ManilaFolder;



public class EventAmdahlOffices extends Event {

	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EventAmdahlOffices(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			this.setSelfswitch1(true);
			Dialog[] d = new Dialog[3];
			d[0] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"Salutations my Elevator-Operating friend./Pray tell, what business brings you so far from the elevators?");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"");
			super.Dialog(d, 0, this.getId(), true);
		}
		else{
			
		}
	}
	
	
	public boolean isSolid(int i){
		return true;
	}
		
}
