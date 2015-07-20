package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventJorgeInvisible extends Event {

	public boolean selfswitch1=false;
	public boolean fightwon=false;
	public static int stage=0;						
	public static int finalstage=3;		
	public static BufferedImage img = Assets.White;
	public EventJorgeInvisible(float x, float y, int idnum) {
		super(img,idnum,x, y);
	}
	
	public void run(){
		Event.events[66].run();
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public int getfinalstage() {
		return finalstage;
	}

	public int getstage() {
		return stage;
	}

	public void setstage(int stage) {
		EventJorgeInvisible.stage = stage;
	}
	
	public boolean isFightwon() {
		return fightwon;
	}

	public void setFightwon(boolean fightwon) {
		this.fightwon = fightwon;
	}
	
	public boolean getSelfSwitch1(){
		return selfswitch1;
	}
}
