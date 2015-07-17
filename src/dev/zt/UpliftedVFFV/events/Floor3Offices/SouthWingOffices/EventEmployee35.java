package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventEmployee35 extends Event {

	public boolean selfswitch1=false;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM2);
	public EventEmployee35(float x, float y, int idnum) {
		super(img,idnum,x, y);	
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
		if(!selfswitch1){
			super.Dialog(194, 201,this.getId());
			selfswitch1 = true;
		}
		else{
			switch((int)(Math.random()*13)){
			case 0:
				super.Dialog(202, 202,this.getId());
				break;
			case 1:
				super.Dialog(203, 203,this.getId());
				break;
			case 2:
				super.Dialog(204, 204,this.getId());
				break;
			case 3:
				super.Dialog(205, 205,this.getId());
				break;
			case 4:
				super.Dialog(206, 206,this.getId());
				break;
			case 5:
				super.Dialog(207, 207,this.getId());
				break;
			case 6:
				super.Dialog(208, 208,this.getId());
				break;
			case 7:
				super.Dialog(209, 209,this.getId());
				break;
			case 8:
				super.Dialog(210, 210,this.getId());
				break;
			case 9:
				super.Dialog(211, 211,this.getId());
				break;
			case 10:
				super.Dialog(212, 212,this.getId());
				break;
			case 11:
				super.Dialog(213, 213,this.getId());
				break;
			case 12:
				super.Dialog(214, 214,this.getId());
				break;				
			}
		}
	}

	public boolean isSolid(int i){
		return true;
	}
}
