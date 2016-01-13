package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpCartographer extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeM1;
	public static int stagenum = 0;
	public int move;
	public EmpCartographer(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		xPos=x;
		yPos=y;
		move = 0;
		this.test.runlast = 3;
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
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Say, are you new to this office? You should take a Pocket Map./ This building can really be a maze sometimes./");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Thank you sir!/");
			d[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hey, wait! This is just a blank sheet of paper!/");
			d[3] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"You're supposed to fill it in yourself as you explore. Saves us the effort of making/new maps whenever we renovate./");
			super.Dialog(d, 3, this.getId(), true);
			this.setSelfswitch1(true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"If this building was well designed, its employees wouldn't need maps./");	
			super.Dialog(d, 0, this.getId(), true);
		}
	}
	
	public void walkCycle(){
		move++;
		if(move >= 200){
			int rand = (int)(Math.random()*4);
			switch(rand){
			case 0:
				if(this.getY()>10){
					super.moveUp();
				}
				break;
			case 1:
				if(this.getX()<12){
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
