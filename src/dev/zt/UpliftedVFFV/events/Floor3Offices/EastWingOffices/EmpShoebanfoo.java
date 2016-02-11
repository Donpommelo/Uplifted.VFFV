package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.UsurpersChemSet;

public class EmpShoebanfoo extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeM2;
	public static int stagenum = 0;
	public int move;
	public EmpShoebanfoo(float x, float y, int idnum) {
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
			Dialog[] d = new Dialog[6];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Rrrgh. That Carloc . . . Who does she think she is?/");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Bossing us around like that . . . I swear one of these days . . ./I'm going to . . ./");
			d[2] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,". . . Oh./I . . . uh . . . didn't see you there./D . . . did you hear anything?/");
			d[3] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"You . . . aren't going to tell Carloc I said anything, right?/Please?/");
			d[4] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"What if I give you something?/Uh . . . here! Yeah, take this. Just don't say anything to Carloc./");
			d[5] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained the Usurper's Chemistry Set!/");
			super.setSelfswitch1(true);
			super.Dialog(d, 5, this.getId(), true);
			super.loot(new UsurpersChemSet(), 1);
		} 
		else{ 
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"You didn't mention this me to Carloc, did you?/No, you must not have. I feel like I would be able to tell./");
			super.Dialog(d, 0, this.getId(), true);
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
			this.setstage(1);
		}
	}
	
	public void walkCycle(){
		move++;
		if(move >= 200){
			int rand = (int)(Math.random()*4);
			switch(rand){
			case 0:
				if(super.getY()>17){
					super.moveUp();
				}
				break;
			case 1:
				super.moveDown();
				break;
			case 2:
				if(super.getX()>11){
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
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
}
