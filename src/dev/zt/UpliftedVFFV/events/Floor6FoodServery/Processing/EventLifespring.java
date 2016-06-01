package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;

public class EventLifespring extends Event {

	public String[] Choices={"Sure","Nah"};			//list of choices used in the choicebranch
	public static int stagenum = 1;

	public Item bottle;
	public static BufferedImage img=Assets.Monolith;
	public EventLifespring(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		for(Item i : super.getGamestate().inventorymanager.backpack.keySet()){
			if(i.getName() == "Magic Bottle"){
				bottle = i;
			}
		}
		if(bottle == null){
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A flowing spring of some sort of mysterious liquid./");
			d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"If you had a suitable container, you could probably bottle some of it.//If for whatever reason you wanted to do that./");
			super.Dialog(d, 1, this.getId(), true);
			this.setstage(1);
		}
		else{
			switch(this.getstage()){
			case 0: 
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A flowing spring of some sort of mysterious liquid./");
				super.Dialog(d1, 0, this.getId(), true);
				
				break;		
			case 1:
				Dialog[] d2 = new Dialog[1];
				d2[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Refill Bottle?/");
				super.Dialog(d2, 0, this.getId(), true);
				super.ChoiceBranch(this.getId(), Choices, 100);
				break;
			}
		}
		
	}

	public void ChoiceMade(int i){
		if(i == 0){
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You refill your bottle at the spring./");
			super.Dialog(d1, 0, this.getId(), true);
			bottle.setCharges(3);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
