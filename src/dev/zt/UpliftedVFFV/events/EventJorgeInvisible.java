package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

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
		if(selfswitch1==false){
			switch(stage){
			case 0: 
				super.Dialog(98, 105,this.getId());
				break;
			case 1:
				super.fite(0,this.getId(), false);
				break;
			case 2:
				super.Dialog(106, 106,this.getId());
				if(fightwon){
					selfswitch1=true;
				}
				break;
			case 3:
				stage = 0;
				break;
			}			
		}
		else{
			super.Dialog(107, 107,this.getId());
			stage=3;
		}	
	}
	
	public boolean isSolid(){
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
}