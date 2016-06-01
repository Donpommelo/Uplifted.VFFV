package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;

public class EventBaker1 extends Event {

	public String[] Choices={"Nothing","Bagel","Baguette","Buttermilk Biscuit","Ciabatta","Cornbread","Croissant","English Muffin","Focaccia Bread","Hardtack","Multigrain","Naan","Pita Bread","Potato Bread","Preztel","Pumpernickle","Rye","Sesame Bun","Soda Bread","Sourdough","Speckendick","Sprouted Wheat","Steamed Bao","Texas Toast","Tortilla","Waffle","Whole Wheat"};			//list of choices used in the choicebranch
	public static int stagenum = 1;

	public Item bottle;
	public static BufferedImage img=Assets.Monolith;
	public EventBaker1(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		switch(this.getstage()){
		case 0:
			if(this.isSelfswitch1()){
				Dialog[] d1 = new Dialog[3];
				d1[0] = new Dialog("Baker","/CharacterBusts/ServeryMRedsmall.png",1,"Howdy there, coworker.");
				d1[1] = new Dialog("Baker","/CharacterBusts/ServeryMRedsmall.png",1,"You lookin' fer anythin'?");
				d1[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Uh... do you have anything here that could be put in a sandwich?");
				super.Dialog(d1, 2, this.getId(), true);
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Baker","/CharacterBusts/ServeryMRedsmall.png",1,"Need anythin' else?.");
				super.Dialog(d1, 2, this.getId(), true);
			}
			
			break;
		case 1:
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("Baker","/CharacterBusts/ServeryMRedsmall.png",1,"Aye./Here's this season's harvest.");
			super.ChoiceBranch(this.getId(), Choices, 300);
			super.Dialog(d1, 2, this.getId(), true);
			break;
		}
	}

	public void ChoiceMade(int i){
		String current = "";
		String addon = "";
		switch(super.getVar(32)){
		case 0:
			current = "Nothing";
			break;
		case 1:
			
			break;
		}
		
		Dialog[] d = new Dialog[2];

		
		switch(i){
		case 0:
			addon = "Nothing";
			break;
		case 1:
			addon = "TEMP1";
			break;
		}
		
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
