package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpEmily1 extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeF;
	public static int numstage = 0;
	public int move;
	public EmpEmily1(float x, float y, int idnum) {
		super(img,idnum,x, y, numstage);
		xPos=x;
		yPos=y;
		move = 0;
		Event.events[this.getId()].test.runlast = 0;
	}
	
	public void run(){
		test.setImgShown(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
		if (Player.runlast==0){
			Event.events[this.getId()].test.runlast = 1;
		}
		if (Player.runlast==1){
			Event.events[this.getId()].test.runlast = 0;
		}
		if (Player.runlast==2){
			Event.events[this.getId()].test.runlast = 3;
		}
		if (Player.runlast==3){
			Event.events[this.getId()].test.runlast = 2;
		}
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[3];
			d[0] = new Dialog("Employee","/CharacterBusts/Emily1small.png",1,"?/");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Good morning. Is something wrong?/");
			d[2] = new Dialog("Employee","/CharacterBusts/Emily1small.png",1,"Oh, no. Not at all. Its just that. . . I didn't know you ever left your elevator./Seeing you out here just came to me as a bit of a shock./");
			super.Dialog(d, 2, this.getId(), true);
			this.setSelfswitch1(true);
		}
		else{
			Dialog[] d = new Dialog[3];
			d[0] = new Dialog("Employee","/CharacterBusts/Emily1small.png",1,"Good to see you. You ought to get out of your elevator more often.//");
			super.Dialog(d, 0, this.getId(), true);

		}
	}
	
	public void walkCycle(){
		move++;
		if(move >= 300){
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
}
