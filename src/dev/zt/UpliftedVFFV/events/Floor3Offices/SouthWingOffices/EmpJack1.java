package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpJack1 extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeM1;
	public static int stagenum = 0;
	public int move;
	public EmpJack1(float x, float y, int idnum) {
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
			Dialog[] d = new Dialog[4];
			d[0] = new Dialog("Employee","/CharacterBusts/Jack1small.png",1,"Hey there! Are you looking for something?/");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Yes. Yes I was. Do you know where Suite 521 is?/");
			d[2] = new Dialog("Employee","/CharacterBusts/Jack1small.png",1,"Hmm. Doesn't ring a bell. Sorry./");
			d[3] = new Dialog("Employee","/CharacterBusts/Jack1small.png",1,"But best of luck in finding it, wherever it is./There are some mighty strange places in this building./Hopefully this 'Suite 521' of yours ain't one of them./");
			super.Dialog(d, 3, this.getId(), true);
			this.setSelfswitch1(true);;
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/Jack1small.png",1,"Did you find what you were looking for yet?/Well, don't give up./");
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
				if(super.getX()>17){
					super.moveLeft();
				}
				break;
			case 3:
				if(super.getX()<23){
					super.moveRight();
				}
			}
			move = 0;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
