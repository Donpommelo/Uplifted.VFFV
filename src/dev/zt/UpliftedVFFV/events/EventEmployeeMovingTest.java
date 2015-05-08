package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.entities.creatures.Creature;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;



public class EventEmployeeMovingTest extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
//	public static BufferedImage img=Assets.EmployeeM1;
//	public static Creature test;
	public EventEmployeeMovingTest(float x, float y, int idnum, Game g) {
		super(img,idnum,x, y);
		xPos=x;
		yPos=y;
//		test = new Creature(g,xPos,yPos,32,32,Assets.EmployeeM1);
	}
	

//	public void walkCycle(){
//		while(selfswitch1==false){
//			super.moveRight();
//	}
//	}
	
	public void run(){	
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
			super.moveUp();
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
			super.moveDown();
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM1));
			super.moveLeft();
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1));
			super.moveRight();
		}
		
	}
	


	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
