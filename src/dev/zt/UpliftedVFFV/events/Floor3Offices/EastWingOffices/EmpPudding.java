package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.EnvenomEarth;

public class EmpPudding extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeF;
	public static int stagenum = 0;
	public int move;
	public EmpPudding(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		xPos=x;
		yPos=y;
		move = 0;
		this.test.runlast = 1;
	}
	
	public void run(){
		test.setImgShown(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		if (Player.runlast==0){
			this.test.runlast = 1;
		}
		if (Player.runlast==1){
			this.test.runlast = 0;
		}
		if (Player.runlast==2){
			this.test.runlast = 3;
		}
		if (Player.runlast==3){
			this.test.runlast = 2;
		}
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[5];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,". . . If I don't up the dosage soon, my coworkers might develop an immunity. . .");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Hey, you there! You seem like the sort of fellow who has had their fair share of poison.");
			d[2] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Here, you should take this./It's really fun to play with.");
			d[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained Envenomed Earth!/It makes you feel a little queasy.");
			d[4] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"If you have any kids, you should give it to them./They'll love it.");
			super.Dialog(d, 4, this.getId(), true);
			this.setSelfswitch1(true);
			super.loot(new EnvenomEarth(), 1);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"No matter how sick they get, my coworkers always seem to recover. My Green Alignment Points must be too low.");
			super.Dialog(d, 0, this.getId(), true);
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
//			this.setstage(1);
		}
	}
	
	public void walkCycle(){
		move++;
		if(move >= 150){
			int rand = (int)(Math.random()*4);
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

	public boolean isSolid(int i){
		return true;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
}
