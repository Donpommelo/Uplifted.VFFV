package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.consummables.FennelDonut;



public class EmpDonutGuy extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM2);
	public EmpDonutGuy(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM2));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM2));
		}
		
		if(!this.isSelfswitch1()){
			switch(this.getstage()){
			case 0: 
				Dialog[] d = new Dialog[2];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Hey, today was my day to get breakfast for the office, but Mick isn't here because of a/kidney stone or whatever./You can have his donut if you want./");
				d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Some guy gave you a Donut!/It seems to be one of those strange, niche flavors./");
				super.Dialog(d, 1, this.getId(), true);	
				super.loot(new FennelDonut(),1);
				break;
			case 1:
				Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
				this.setSelfswitch1(true);
				this.setstage(0);
				break;
			}
		
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Mick always had the worse taste in donuts./");
			super.Dialog(d, 0, this.getId(), true);
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
			this.setstage(1);
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}

}
