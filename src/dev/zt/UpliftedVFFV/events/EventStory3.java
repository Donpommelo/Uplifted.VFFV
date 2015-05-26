package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;



public class EventStory3 extends Event {

	boolean selfswitch1 = false;
	public static int stage=0;						
	public static int finalstage=2;	
	public BufferedImage[] scenes = new BufferedImage[2];
	public EventStory3(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		scenes[0]=ImageLoader.loadImage("/Cutscenes/Intro1.png");
		scenes[1]=ImageLoader.loadImage("/Cutscenes/Intro2.png");
	
	}
	

	
	public void run(){
		switch(stage){
		case 0:	
			super.Dialog(257, 273, this.getId());
			break;
		case 1:
			super.Dialog(274, 274, this.getId());
//			super.Cutscene(scenes, this.getId());
			break;
		case 2:
			super.Dialog(275, 279, this.getId());
			selfswitch1 = true;
			super.transport("res/Worlds/backroom.txt", 3, 4,"");
			break;
		}

			
	}


	public int getfinalstage() {
		return finalstage;
	}


	public int getstage() {
		return stage;
	}
	
	public void setstage(int stage) {
		EventStory3.stage = stage;
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public boolean drawn(){
		return !selfswitch1 && Event.events[66].isSelfswitch1();


	}

}
