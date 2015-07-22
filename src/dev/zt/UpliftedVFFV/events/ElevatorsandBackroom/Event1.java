package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;


public class Event1 extends Event {


	public boolean selfswitch1=false;	
	public BufferedImage[] scenes = new BufferedImage[2];
	public static int stage=0;						
	public static int finalstage=1;	
	public Event1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		scenes[0]=ImageLoader.loadImage("/Cutscenes/Intro1.png");
		scenes[1]=ImageLoader.loadImage("/Cutscenes/Intro2.png");
	}
	
	public void run(){
		if(!selfswitch1){
			switch(stage){
			case 0:
				super.Cutscene(scenes, this.getId());
				super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 3, 6,"South Elevator");
				break;
			case 1:
				
				super.Dialog(0,8,this.getId());	
				selfswitch1= true;
				break;
			}	
		}
		else{
			super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 3, 6,"South Elevator");
		}
		
	}
	public int getfinalstage() {
		return finalstage;
	}

	public int getstage() {
		return stage;
	}
	
	public void setstage(int stage) {
		Event1.stage = stage;
	}
	
	public boolean isSelfswitch1() {
		return selfswitch1;
	}

	public void setSelfswitch1(boolean selfswitch1) {
		this.selfswitch1 = selfswitch1;
	}
	
	public boolean isSolid(int i){
		return true;
	}
	public boolean isDoor(){
		return true;
	}

}
