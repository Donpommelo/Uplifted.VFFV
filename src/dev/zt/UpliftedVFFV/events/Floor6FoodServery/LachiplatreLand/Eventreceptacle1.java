package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.misc.ColoredPlasticBall;

public class Eventreceptacle1 extends Event {

	public static int stagenum = 3;
	public String[] Choices;			//list of choices used in the choicebranch
	public ArrayList <Item> balls;
	public Item ball1;
	public Item ball2;

	public static BufferedImage img=Assets.Monolith;
	
	public Eventreceptacle1(float x, float y, int idnum) {
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
			
			if(balls.size() < 2){
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"<Entry text>/");
				super.Dialog(d, 0, this.getId(), true);
				this.setstage(3);
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Write stuff here later./");
				super.Dialog(d1, 0, this.getId(), true);
			}			
			break;		
		case 1:
			Dialog[] d2 = new Dialog[1];
			d2[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Place first ball?/");
			super.Dialog(d2, 0, this.getId(), true);
			Choices = new String[balls.size()+1];
			Choices[0] = "Never Mind";
			for(int i = 0; i < balls.size();i++){
				Choices[i+1] = balls.get(i).getName()+" x"+super.itemNumCheck(balls.get(i));
			}
			super.ChoiceBranch(this.getId(), Choices, 200);
			
			break;
		case 2:
			Dialog[] d3 = new Dialog[1];
			d3[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Place second ball?/");
			super.Dialog(d3, 0, this.getId(), true);
			Choices = new String[balls.size()+1];
			Choices[0] = "Never Mind";
			for(int i = 0; i < balls.size();i++){
				Choices[i+1] = balls.get(i).getName()+" x"+super.itemNumCheck(balls.get(i));
			}
			super.ChoiceBranch(this.getId(), Choices, 200);
			break;
		case 3:
			if(ball1 != null && ball2 != null){
				int color1 = ball1.getCharges();
				int color2 = ball2.getCharges();
				int red = 0;
				int blue = 0;
				int yellow = 0;
				while(color1 > 8){
					color1 -= 9;
					yellow++;
				}
				while(color1 > 2){
					color1 -= 3;
					blue++;
				}
				while(color1 > 0){
					color1 -= 1;
					red++;
				}
				while(color2 > 8){
					color2 -= 9;
					yellow++;
				}
				while(color2 > 2){
					color2 -= 3;
					blue++;
				}
				while(color2 > 0){
					color2 -= 1;
					red++;
				}
				Item newBall = new ColoredPlasticBall(red,blue,yellow);
				if(newBall.getName() == "Grey Plastic Ball"){
					//Initiate fight with Discoloured One Mob
					ball1 = null;
					ball2 = null;
				}
				else{
					Dialog[] d4 = new Dialog[1];
					d4[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"<Obtain new colored ball> "+newBall.getName()+"!/");
					super.Dialog(d4, 0, this.getId(), true);
					super.loot(newBall, 1);
					ball1 = null;
					ball2 = null;
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
			if(ball1 == null){
				//uh
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You grab your balls and leave./");
				super.Dialog(d, 0, this.getId(), true);
			}
			else{
				super.loot(ball1, 1);
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You grab your balls and leave./(Obtained: "+ball1.getName()+")/");
				super.Dialog(d, 0, this.getId(), true);
			}
			this.setstage(3);
		}
		else{
			if(ball1 == null){
				ball1 = balls.get(i-1);
				super.loot(ball1, -1);
				this.setstage(2);
				this.run();
			}
			else{
				ball2 = balls.get(i-1);
				super.loot(ball2, -1);
				this.setstage(3);
				this.run();
			}
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
