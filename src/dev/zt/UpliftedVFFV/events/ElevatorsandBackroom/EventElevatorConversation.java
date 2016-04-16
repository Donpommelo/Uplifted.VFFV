package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventElevatorConversation extends Event {

	public boolean drawn = false;
	public static int stagenum = 0;
	public int convId;
	public static BufferedImage img=Assets.PenPal;
	public EventElevatorConversation(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		
	}
		
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,img));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,img));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,img));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,img));
		}
		switch(convId){
		case 1:
			break;
		case 1000:
			//Random conversations
			break;
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean loaded(){
		if(super.getQuest(1) > 2){
			if(super.getVar(28) < super.getVar(27)){
				super.setVar(28,super.getVar(28)+1);
				convId = super.getVar(28);
				return true;
			}
			else{
				if(Math.random() < .30){
					convId = 1000;
					return true;
				}
				else{
					return false;
				}
			}
		}
		else{
			return false;
		}
		
	}
	
}
