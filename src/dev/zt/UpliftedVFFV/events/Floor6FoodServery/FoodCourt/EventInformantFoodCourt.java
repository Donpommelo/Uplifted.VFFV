package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventInformantFoodCourt extends Event {

	public boolean fightwon=false;
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.Informant);
	public EventInformantFoodCourt(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.Informant));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.Informant));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.Informant));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.Informant));
		}
		if(!this.isSelfswitch1()){
			switch(super.getQuest(3)){
			case 2:
				super.setQuest(3, 3);
				Dialog[] d = new Dialog[12];
				d[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"<Gives Quest>");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"");
				super.Dialog(d, 11, this.getId(), true);
				break;
			case 3:
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"");
				super.Dialog(d1, 0, this.getId(), true);
				break;
			case 4:
				Dialog[] d2 = new Dialog[11];
				d2[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"");
				d2[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"");
				//loot rewards
				super.Dialog(d2, 10, this.getId(), true);
				super.setQuest(3, 5);
				this.setSelfswitch1(true);
				break;
			}
		}
		else{
			if(!this.isSelfswitch2()){
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"");
				this.setSelfswitch2(true);
				super.Dialog(d, 3, this.getId(), true);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"");
				super.Dialog(d, 0, this.getId(), true);
			}
			
		}
			
	}
	
	
	public boolean loaded(){
		boolean drawn = false;
		if(super.getQuest(3) >= 2){
			drawn = true;
		}
		return drawn;
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
