package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpLil extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeF;
	public static int stagenum = 0;
	public int move;
	public EmpLil(float x, float y, int idnum) {
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
			this.setSelfswitch1(true);
			Dialog[] d = new Dialog[5];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"I thought I saw you earlier./Were my coworkers leading you in circles?/");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Well, no hard feelings I hope. They do that to everyone./And not just to be mean. It teaches people a valuable lesson./");
			d[2] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Approaching the same thing from a different perspective can lead to new insights!/Retreading familiar locations can open your eyes to unexpected secrets!/");
			d[3] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,". . ./");
			d[4] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Nah. I'm kidding. They're just jerks./");
			super.Dialog(d, 4, this.getId(), true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Did you take what I said to heart?/Is that why you're still hanging around here?/");
			super.Dialog(d, 0, this.getId(), true);

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
				if(super.getY() < 17){
					super.moveDown();
				}
				break;
			case 2:
				if(super.getX() > 15){
					super.moveLeft();
				}
				break;
			case 3:
				if(super.getX() < 24){
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
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
}
