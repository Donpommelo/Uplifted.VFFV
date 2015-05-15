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
	public static BufferedImage img=Assets.EmployeeM1;//SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
//	public static BufferedImage img=Assets.EmployeeM1;
//	public static Creature test;
	public EventEmployeeMovingTest(float x, float y, int idnum) {
		super(img,idnum,x, y);
//		super(idnum, x, y, g);
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
			super.moveUp();
		}
		if (Player.runlast==1){
			super.moveDown();
		}
		if (Player.runlast==2){
			super.moveLeft();
		}
		if (Player.runlast==3){
			super.moveRight();
		}
		
	}
	


	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
	
/*	public boolean isExist(){
		return false;
	}*/
}
