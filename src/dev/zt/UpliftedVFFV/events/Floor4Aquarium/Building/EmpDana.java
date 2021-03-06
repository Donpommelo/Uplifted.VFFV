package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpDana extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeF;
	public static int numstage = 0;
	public int move;
	public EmpDana(float x, float y, int idnum) {
		super(img,idnum,x, y, numstage);
		xPos=x;
		yPos=y;
		move = 0;
		this.test.runlast = 0;
	}
	
	public void run(){
		test.setImgShown(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
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
		d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Where do employees get Aquarium Passes?");
		d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"Is this some kind of secret club or something? They never tell me anything around here.");
		super.Dialog(d,1, this.getId(), true);
	}
	
	public void walkCycle(){
		move++;
		if(move >= 150){
			int rand = (int)(Math.random()*4);
			switch(rand){
			case 0:
				if(super.getY() > 22){
					super.moveUp();
				}
				break;
			case 1:
				if(super.getY() < 30){
					super.moveDown();
				}
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
}
