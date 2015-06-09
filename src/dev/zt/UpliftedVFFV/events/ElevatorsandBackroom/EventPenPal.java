package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.PenPal;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class EventPenPal extends Event {

	public boolean selfswitch1=false;
	public boolean solid;
	public boolean drawn = false;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.PenPal);
	public EventPenPal(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
	

	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.PenPal));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.PenPal));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.PenPal));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.PenPal));
		}
		if(selfswitch1==false){
			super.Dialog(12, 17,this.getId());
			super.setSwitch(1, true);
			selfswitch1=true;
		}
		else{
			super.Dialog(27, 27,this.getId());
		}

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean drawn(){
		return drawn;
	}
	
	public boolean isDrawn() {
		return drawn;
	}

	public void setDrawn(boolean drawn) {
		this.drawn = drawn;
	}

	

	public boolean isSelfswitch1() {
		return selfswitch1;
	}

	public void setSelfswitch1(boolean selfswitch1) {
		this.selfswitch1 = selfswitch1;
	}
	
	
}
