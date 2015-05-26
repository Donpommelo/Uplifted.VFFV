package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventJorge extends Event {

	public boolean selfswitch1=false;
	public boolean fightwon=false;
	public static int stage=0;						
	public static int finalstage=4;		
	public static BufferedImage img = Assets.Jorge1;
	public EventJorge(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
	
	public void run(){
			switch(stage){
			case 0: 
				if(!isSelfswitch1()){
					super.Dialog(98, 102,this.getId());
					
				}
				else{
					super.Dialog(107, 107,this.getId());
					stage=3;
				}
				break;
			case 1:
				super.Dialog(103, 105,this.getId());
				game.getAudiomanager().playMusic(4);
				break;
			case 2:
				super.fite(0,this.getId(), false, false);
				break;
			case 3:
				if(fightwon){
					setSelfswitch1(true);
					game.getAudiomanager().playMusic(2);
				}
				super.Dialog(106, 106,this.getId());
				break;
			case 4:
				stage = 0;
				break;
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
		EventJorge.stage = stage;
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
