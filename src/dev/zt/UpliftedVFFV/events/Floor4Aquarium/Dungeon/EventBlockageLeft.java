package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventBlockageLeft extends Event {

	public boolean fightwon=false;
	public static int stagenum = 3;
	public static BufferedImage img = Assets.Monolith;
	public EventBlockageLeft(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
			switch(this.getstage()){
			case 0:
				//Fite blockage
				super.fite(24,this.getId(), false, false);
				break;
			case 1:
				if(fightwon){
					setSelfswitch1(true);
					super.setSwitch(35, true);
					super.setVar(22, super.getVar(22)+1);
				}
				//Put some kinda flushing sound or whatever
				super.fade(-1, this.getId());
				break;
			case 2:
				super.Timer(this.getId(), 50);
				super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/DrainRoom.txt",8,10,"");
				break;
			case 3:
				this.fade(1, this.getId());
				break;
			}			
	}
	
	public boolean drawn(){
		return !super.getSwitch(35);
	}
	
	public boolean loaded(){
		return !super.getSwitch(35);
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
	public boolean isFightwon() {
		return fightwon;
	}

	public void setFightwon(boolean fightwon) {
		this.fightwon = fightwon;
	}

}
