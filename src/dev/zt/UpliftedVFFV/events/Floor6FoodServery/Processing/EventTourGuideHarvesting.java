package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventTourGuideHarvesting extends Event {

	public boolean fightwon=false;
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EventTourGuideHarvesting(float x, float y, int idnum) {
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

		Dialog[] d = new Dialog[10];
		d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Your tour begins here, in the Harvesting chamber.");
		d[1] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"This is where we harvest the Lachiplatre that forms the base of the many products you see in the Food Servery.");
		
		super.Dialog(d, 9, this.getId(), true);
		super.setQuest(13, 1);

	}
	
	public boolean isSolid(int i){
		return true;
	}
}
