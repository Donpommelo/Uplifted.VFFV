package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.FennelDonut;



public class EventEmployee11 extends Event {

	public boolean selfswitch1=false;
	public static int stage=0;						
	public static int finalstage=1;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM2);
	public EventEmployee11(float x, float y, int idnum) {
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
		
		if(selfswitch1==false){
			switch(stage){
			case 0: 
				super.Dialog(74, 75,this.getId());
				super.loot(new FennelDonut(),1);
				break;
			case 1:
				Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
				selfswitch1 = true;
				stage = 0;
				break;
				
			}
		
		}
		else{
			super.Dialog(76, 76,this.getId());
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
			stage = 1;
		}

	}
	
	public boolean isSolid(){
		return true;
	}
	
	public int getfinalstage() {
		return finalstage;
	}
	
	public int getstage() {
		return stage;
	}


	public void setstage(int stage) {
		EventEmployee11.stage = stage;
	}
}
