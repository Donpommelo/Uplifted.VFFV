package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventEmployeeMovingTest extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeM1;//SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
//	public static BufferedImage img=Assets.EmployeeM1;
//	public static Creature test;
	public static int stage=0;						
	public static int finalstage=4;					
	public boolean selfswitch1;
	public int move;
	public static BufferedImage[] scenes = {Assets.EmployeeM1,Assets.EmployeeM2};
	public EventEmployeeMovingTest(float x, float y, int idnum) {
		super(img,idnum,x, y);
//		super(idnum, x, y, g);
		xPos=x;
		yPos=y;
//		test = new Creature(g,xPos,yPos,32,32,Assets.EmployeeM1);
//		walkCycle();
		move = 0;
	}
	

	public void walkCycle(){
		move++;
		if(move >= 300){
//			int rand = (int)(Math.random()*4);
			int rand = 0;
			switch(rand){
			case 0:
				super.moveUp();
				break;
			case 1:
				super.moveDown();
				break;
			case 2:
				super.moveLeft();
				 break;
			case 3:
				super.moveRight();
				break;
			}
			move = 0;
		}
	
	}
	
	public void run(){	
/*		if (Player.runlast==0){
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
		if(stage == finalstage){
			stage = 0;
		}
		else{*/
//			super.screenShake(20);
//		}	
//		super.Cutscene(scenes, this.getId());
	}
	
	public int getfinalstage() {
		return finalstage;
	}
	



	public int getstage() {
		return stage;
	}


	public void setstage(int stage) {
		EventEmployeeMovingTest.stage = stage;
	}
	
	
	public boolean isSolid(){
		return true;
	}
	
/*	public boolean drawn(){
		return false;
	}*/
}
