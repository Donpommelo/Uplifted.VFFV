package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.world.EventManager;

public class EventWaitressCutscene extends Event {

	public static float xPos,yPos;
	public static int stagenum=16;		
	public static BufferedImage img=Assets.EmployeeF;
	public EventWaitressCutscene(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		xPos=x;
		yPos=y;
		this.test.runlast = 3;
	}
	
	public void run(){	
		test.setImgShown(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
			
		switch(this.getstage()){
		case 0: 
			super.cameraMove(700, 120, 50);
			super.moveLeft();
			break;
		case 1:
			super.moveLeft();
			break;
		case 2:
			super.moveLeft();
			break;
		case 3:
			super.moveLeft();
			break;
		case 4:
			super.moveLeft();
			break;
		case 5:
			super.moveLeft();
			break;
		case 6:		
			super.moveLeft();
			break;
		case 7:		
			super.moveLeft();
			break;
		case 8:		
			super.moveLeft();
			break;
		case 9:		
			super.moveLeft();
			break;
		case 10:
			Dialog[] d = new Dialog[7];
			d[0] = new Dialog("Employee","/CharacterBusts/SecurityGuardsmall.png",0,"What room are you delivering that food to?");
			d[1] = new Dialog("Employee","/CharacterBusts/ServeryFYellowsmall.png",1,"Suite 521, mister!");
			d[2] = new Dialog("Employee","/CharacterBusts/SecurityGuardsmall.png",0,"Mmmh. Smells delicious./What is it?");
			d[3] = new Dialog("Employee","/CharacterBusts/ServeryFYellowsmall.png",1,"Six orders of Lachiplatre, mister!/As usual!");
			d[4] = new Dialog("Employee","/CharacterBusts/SecurityGuardsmall.png",0,"Lachiplatre?/Again?/What do they even do with all that Lachiplatre?");
			d[5] = new Dialog("Employee","/CharacterBusts/SecurityGuardsmall.png",0,"Eat it?/Ugh.");
			d[6] = new Dialog("Employee","/CharacterBusts/SecurityGuardsmall.png",0,"Go on ahead./Don't want our higher ups getting hungry.");
			super.Dialog(d, 6, this.getId(), true);			
			break;
		case 11:
			super.moveDown();
			break;
		case 12:
			super.moveLeft();
			break;
		case 13:
			super.moveLeft();
			break;
		case 14:
			super.moveLeft();
			break;
		case 15:
			EventManager.getEvents()[(int)(this.getX())][(int)(this.getY())]=0;
			super.Timer(this.getId(), 30);
			break;
		case 16:
			super.cameraLock();
			this.setSelfswitch1(false);
			KeyManager.setCutsceneMode(false);
			Dialog[] d2 = new Dialog[10];
			d2[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Uh./Did you need a straw?");
			d2[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Forget the food for now!/This could be our ticket to Suite 521!");
			d2[2] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"That food was being delivered to Suite 521!/There must be an alternate route beyond that door!");
			d2[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"We could pretend to be making a food delivery!");
			d2[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"The guard said that Suite 521 always orders Lachiplatre!/If we have some of those, the guard ought to let us by!");
			d2[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Is that . . . ok?/I mean, I'm not authorized to handle food products.");
			d2[6] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Well, we aren't really delivering food, remember?/We're lying about that so we can access restricted areas of the building.");
			d2[7] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . .");
			d2[8] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Did you still want your food?");
			d2[9] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Oh right, yes./Just stick the meal into this plant's pot and hopefully it will reach me.");

			super.Dialog(d2, 9, this.getId(), true);
			break;
			}
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean drawn(){
		return this.isSelfswitch1();
	}
	
	public boolean loaded(){
		return this.isSelfswitch1();
	}
}
