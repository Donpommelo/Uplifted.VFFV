package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.UsurpersChemSet;

public class EmpArchie extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeM2;
	public static int stagenum = 0;
	public int move;
	public EmpArchie(float x, float y, int idnum) {
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
		Dialog[] d = new Dialog[2];
		d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Wow. Did you know that the surface of this planet is mostly water?");
		d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I guess we're pretty lucky to have ended up on land, then. I mean, the odds really weren't in our favor.");
		super.Dialog(d, 1, this.getId(), true);
	}
	
	public void walkCycle(){
		move++;
		if(move >= 200){
			int rand = (int)(Math.random()*4);
			switch(rand){
			case 0:
				if(super.getY() > 16){
					super.moveUp();
				}
				break;
			case 1:
				super.moveDown();
				break;
			case 2:
				if(super.getX() > 6){
					super.moveLeft();
				}
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
