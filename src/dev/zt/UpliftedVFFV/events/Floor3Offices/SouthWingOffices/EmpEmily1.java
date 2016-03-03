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
			d[0] = new Dialog("Employee","/CharacterBusts/Emily1small.png",1,"You ought to spend more time in the Building with the rest of us./Being cooped up all day in an elevator can't be good for you./");
			super.Dialog(d, 0, this.getId(), true);

		}
	}
	
	public void walkCycle(){
		move++;
		if(move >= 250){
			int rand = (int)(Math.random()*4);
			switch(rand){
			case 0:
				super.moveUp();
				break;
			case 1:
				super.moveDown();
				break;
			case 2:
				if(super.getX()>17){
					super.moveLeft();
				}
				break;
			case 3:
				if(super.getX()<23){
					super.moveRight();
				}
				break;
			}
			move = 0;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
