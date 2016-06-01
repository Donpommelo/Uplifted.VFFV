package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.WaiterTray;

public class EventTourGuideWest extends Event {

	public boolean fightwon=false;
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EventTourGuideWest(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM1));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1
					));
		}
		if(super.itemNumCheck(new WaiterTray()) == 0){
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Hey you!/You're not in Processing or Distributions!");
			d[1] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"You must have taken a wrong turn somewhere, buddy!/You don't seem authorized to enter.");
			super.Dialog(d, 1, this.getId(), true);
		}
		else{
			switch(super.getQuest(13)){
			case 0:
				Dialog[] d = new Dialog[10];
				d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Oh? Another waiter?/You seem to be a new face around here.");
				d[1] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Welcome to the company Food Processing!/You must be here for factory Training!");
				d[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Well, actually we were just passing by./We were headed to Suite 521.");
				d[3] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,".../Well you see...");
				d[4] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"This Processing Plant may be one of the most important facilities in this building.");
				d[5] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Allowing untrained employees into Processing could be hazardous to the safety of coworkers and perhaps the company as a whole.");
				d[6] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"What sort of training?");
				d[7] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Our Processing Facility Readiness Program consists of a brief tour of facility machinery followed by a simple examination to confirm Processing Aptitude.");
				d[8] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Sounds simple enough./And we can proceed to Suite 521 afterwards?");
				d[9] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Yeah./Let me unlock that door over there so you can continue to the next stage of the Training Program.");

				super.Dialog(d, 9, this.getId(), true);
				this.setSelfswitch1(true);
				super.setQuest(13, 1);
				break;
			case 1:
			case 2:
				Dialog[] d2 = new Dialog[10];
				d2[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"You have a Training Program to complete.");
				super.Dialog(d2, 9, this.getId(), true);
				break;
			case 3:
				Dialog[] d3 = new Dialog[10];
				d3[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"QUEST END TEXT");
				super.Dialog(d3, 9, this.getId(), true);
				break;
			}
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
