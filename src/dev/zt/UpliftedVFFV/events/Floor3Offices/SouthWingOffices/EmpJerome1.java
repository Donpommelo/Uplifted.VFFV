package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpJerome1 extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeM2;
	public static int stagenum = 0;
	public int move;
	public EmpJerome1(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		xPos=x;
		yPos=y;
		move = 0;
		Event.getEvents()[this.getId()].test.runlast = 1;
	}
	
	public void run(){
		test.setImgShown(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		if (Player.runlast==0){
			Event.getEvents()[this.getId()].test.runlast = 1;
		}
		if (Player.runlast==1){
			Event.getEvents()[this.getId()].test.runlast = 0;
		}
		if (Player.runlast==2){
			Event.getEvents()[this.getId()].test.runlast = 3;
		}
		if (Player.runlast==3){
			Event.getEvents()[this.getId()].test.runlast = 2;
		}
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[7];
			d[0] = new Dialog("Employee","/CharacterBusts/Gerome1small.png",1,"Hello there. Which offices do you come from?/");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Offices?/");
			d[2] = new Dialog("Employee","/CharacterBusts/Gerome1small.png",1,"Which offices? South, East, West or. . . Er. . .whatever the fourth one was?/");
			d[3] = new Dialog("Employee","/CharacterBusts/Gerome1small.png",1,"I woulda wagered you were a West Office Employee, but you seemed a little too/. . . lively, y'know? But you looked too nice to be from East Wing./And I haven't seen you around South./");
			d[4] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Oh. I'm not from any of the offices. I'm the Operator. I work in the Elevators./");
			d[5] = new Dialog("Employee","/CharacterBusts/Gerome1small.png",1,"Elevators? We have elevators in this building?/I guess I've always been more of a stairs person anyways./");
			d[6] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Stairs. . ./");
			super.Dialog(d, 6, this.getId(), true);
			this.setSelfswitch1(true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/Gerome1small.png",1,"Remind me to try that elevator thing some time./");
			super.Dialog(d, 0, this.getId(), true);
		}
	}
	
	public void walkCycle(){
		move++;
		if(move >= 200){
			int rand = (int)(Math.random()*4);
			switch(rand){
			case 0:
				super.moveUp();
				break;
			case 1:
				super.moveDown();
				break;
			case 2:
				if(super.getX()>16){
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
