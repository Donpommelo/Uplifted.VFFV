package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventCarlocLobbyInvisible extends Event {

	public static int stagenum = 3;	
	public static BufferedImage img = Assets.White;
	public EventCarlocLobbyInvisible(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		super.getGamestate().getEvents()[207].run();
	}
	
	public boolean loaded(){
		if(super.getQuest(5) == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
