package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpAndretheTall extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeM2;
	public static int stagenum = 0;
	public int move;
	public EmpAndretheTall(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		xPos=x;
		yPos=y;
		move = 0;
		this.test.runlast = 1;
	}
	
	public void run(){
		test.setImgShown(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
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
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("Employee","/CharacterBusts/AndreThe1.png",1,"Ugh. An Ill Rat bit me and now I feel a little queasy.");
			d[1] = new Dialog("Employee","/CharacterBusts/AndreThe1.png",1,"I better drop by the 7th Floot Infirmary for medicine.");
			super.Dialog(d, 1, this.getId(), true);
			this.setSelfswitch1(true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/AndreThe1.png",1,"Whatever you're looking for, I can't see it from up here.");
			super.Dialog(d,0, this.getId(), true);
		}
	}
	
	public void walkCycle(){
		move++;
		if(move >= 250){
			int rand = (int)(Math.random()*4);
			switch(rand){
			case 0:
				if(super.getY()>14){
					super.moveUp();
				}
				break;
			case 1:
				if(super.getY()<21)
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
