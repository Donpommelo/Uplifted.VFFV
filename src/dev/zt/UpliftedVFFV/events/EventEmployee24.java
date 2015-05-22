package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class EventEmployee24 extends Event {

	public boolean selfswitch1=false;
	public static BufferedImage img=SpriteSorter.SpriteSort(7,Assets.EmployeeF);
	public EventEmployee24(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
	

	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
		}
			super.Dialog(112, 113,this.getId());
		

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}