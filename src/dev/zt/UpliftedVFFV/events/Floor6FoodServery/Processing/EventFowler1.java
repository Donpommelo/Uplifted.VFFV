package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;

public class EventFowler1 extends Event {

	public String[] Choices={"Nothing","Duck","Egg Salad","Fried Egg","Grilled Chicken","Scrambled Egg","Shredded Chicken","Turkey"};			//list of choices used in the choicebranch
	public static int stagenum = 1;

	public Item bottle;
	public static BufferedImage img=Assets.Monolith;
	public EventFowler1(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		switch(this.getstage()){
		case 0:
			if(this.isSelfswitch1()){
				Dialog[] d1 = new Dialog[3];
				d1[0] = new Dialog("Butcher","/CharacterBusts/ServeryMRedsmall.png",1,"Eh? Customers?/I don't usually meet with customers directly...");
				d1[1] = new Dialog("Butcher","/CharacterBusts/ServeryMRedsmall.png",1,"What do you need?");
				d1[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I ... uh ... need to make a sandwich.");
				super.Dialog(d1, 2, this.getId(), true);
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Butcher","/CharacterBusts/ServeryMRedsmall.png",1,"Oh, its you again.");
				super.Dialog(d1, 2, this.getId(), true);
			}
			
			break;
		case 1:
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("Butcher","/CharacterBusts/ServeryMRedsmall.png",1,"Well, what can I getcha, then?");
			super.ChoiceBranch(this.getId(), Choices, 300);
			super.Dialog(d1, 2, this.getId(), true);
			break;
		}
	}

	public void ChoiceMade(int i){
		String current = "";
		String addon = "";

		current = Choices[super.getVar(32)];
		
		Dialog[] d = new Dialog[2];

		
		addon = Choices[i];
		
		if(i != 0){
			
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You add the "+addon+" to your Sandwich.");
			
			if(super.getVar(32) == 0){
				super.Dialog(d, 0, this.getId(), true);

			}
			else{
				d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The "+addon+" displaces your "+current+" which falls to the floor messily.");
				super.Dialog(d, 1, this.getId(), true);
			}
			
			super.setVar(32, i);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
