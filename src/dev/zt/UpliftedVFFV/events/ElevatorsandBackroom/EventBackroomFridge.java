package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.consumables.RandomFoodMedium;

public class EventBackroomFridge extends Event {

	public static int stagenum = 0;
	public EventBackroomFridge(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			this.setSelfswitch1(true);
		
		Dialog[] d = new Dialog[2];
		d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A Fridge./Inside you find  . . . something?/");
		d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Use 'Z' to check your inventory!/");
		super.Dialog(d, 1, this.getId(), true);
		super.loot(new RandomFoodMedium(), 1);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A Fridge./You've already taken everything inside./");
			super.Dialog(d, 0, this.getId(), true);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
