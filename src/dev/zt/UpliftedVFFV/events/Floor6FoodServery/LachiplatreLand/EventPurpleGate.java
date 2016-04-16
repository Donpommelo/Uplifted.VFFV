package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;

public class EventPurpleGate extends Event {

	public static int stagenum = 2;
	public String[] Choices;			//list of choices used in the choicebranch
	public ArrayList <Item> balls;
	public Item ball1;

	public static BufferedImage img=Assets.Monolith;
	
	public EventPurpleGate(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		balls = new ArrayList<Item>();
		for(Item i : super.getGamestate().inventorymanager.backpack.keySet()){
			if(i.getName().contains("Plastic Ball")){
				balls.add(i);
			}
		}
		switch(this.getstage()){
		case 0:
			if(this.isSelfswitch1()){
				super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/FieldsofLachiplatre.txt",15,41,"");
				this.setstage(2);
			}
			else{
				if(balls.size() < 1){
					Dialog[] d = new Dialog[1];
					d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"<Entry text>/");
					super.Dialog(d, 0, this.getId(), true);
					this.setstage(2);
				}
				else{
					Dialog[] d1 = new Dialog[1];
					d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Write stuff here later./");
					super.Dialog(d1, 0, this.getId(), true);
				}
			}		
			break;		
		case 1:
			Dialog[] d2 = new Dialog[1];
			d2[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Place ball?/");
			super.Dialog(d2, 0, this.getId(), true);
			Choices = new String[balls.size()+1];
			Choices[0] = "Never Mind";
			for(int i = 0; i < balls.size();i++){
				Choices[i+1] = balls.get(i).getName()+" x"+super.itemNumCheck(balls.get(i));
			}
			super.ChoiceBranch(this.getId(), Choices, 200);
			
			break;
		case 2:
			if(ball1 != null){
				int color1 = ball1.getCharges();
				if(color1 == 4){
					super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/FieldsofLachiplatre.txt",15,41,"");
					super.loot(ball1, -1);
					this.setSelfswitch1(true);
					Dialog[] d3 = new Dialog[1];
					d3[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A door unlocks./");
					super.Dialog(d3, 0, this.getId(), true);
				}
				else{
					Dialog[] d3 = new Dialog[1];
					d3[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Nothing happens./");
					super.Dialog(d3, 0, this.getId(), true);
				}

			}
			else{
				this.setstage(0);
			}
			break;
		}
		
	}

	public void ChoiceMade(int i){
		if (i == 0){
			this.setstage(0);
		}
		else{
			if(ball1 == null){
				ball1 = balls.get(i-1);
				this.setstage(2);
				this.run();
			}
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
