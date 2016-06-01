package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;

public class EventPurpleGate extends Event {

	public static int stagenum = 3;
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
				super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand2.txt",12,22,"");
				this.setstage(0);
			}
			else{
				if(balls.size() < 1){					
					Dialog[] d = new Dialog[2];
					d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A mysterious Purple arch with a ball-shaped receptacle.");
					d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You don't have anything to place into the hole.");
					super.Dialog(d, 1, this.getId(), true);
					this.setstage(2);
				}
				else{
					Dialog[] d1 = new Dialog[1];
					d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A mysterious Purple arch with a ball-shaped receptacle.");
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
			super.ChoiceBranch(this.getId(), Choices, 300);
			
			break;
		case 2:
			if(ball1 != null){
				int color1 = ball1.getCharges();
				if(color1 == 4){
					super.loot(ball1, -1);
					this.setSelfswitch1(true);
					Dialog[] d3 = new Dialog[1];
					d3[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The arch crackles with energy./A portal is reopened!");
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
		case 3:
			this.setstage(0);
			break;
		}
		
	}

	public void ChoiceMade(int i){
		if (i == 0){
			this.setstage(0);
		}
		else{
			ball1 = balls.get(i-1);
			this.setstage(2);
			this.run();
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
}
