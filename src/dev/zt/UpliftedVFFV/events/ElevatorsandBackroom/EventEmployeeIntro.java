package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.world.EventManager;

public class EventEmployeeIntro extends Event {

	public static float xPos,yPos;
	public static int stagenum=7;		
	public boolean drawn = true;
	public boolean solid = true;
	public static BufferedImage img=Assets.EmployeeM2;
	public static BufferedImage[] scenes = new BufferedImage[2]; 
	public EventEmployeeIntro(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		xPos=x;
		yPos=y;
		Event.events[this.getId()].test.runlast = 3;
		scenes[0]=ImageLoader.loadImage("/Cutscenes/Intro3.png");
		scenes[1]=ImageLoader.loadImage("/Cutscenes/Intro4.png");
	}
	
	public void run(){	
		test.setImgShown(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
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
			
		if(gamestate.getPlayer().getPlayerX()==192 && gamestate.getPlayer().getPlayerY()==224){
			switch(this.getstage()){
			case 0: 
				Event.events[this.getId()].test.runlast = 3;
				Dialog[] d1 = new Dialog[2];
				d1[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Thank you./");
				d1[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Have a nice day./");
				super.Dialog(d1, 1, this.getId(), true);
				KeyManager.setCutsceneMode(true);
				break;
			case 1:
				super.moveRight();
				break;
			case 2:
				super.moveUp();
				break;
			case 3:
				Event.events[3].setOpen(true);
				super.moveUp();
				break;
			case 4:
				EventManager.getEvents()[(int)(this.getX())][(int)(this.getY())]=0;
				drawn = false;
				solid = false;
				this.setSelfswitch1(true);
				Event.events[3].setOpen(false);
				super.Timer(this.getId(), 60);
				break;
			case 5:
				Event.events[3].setOpen(true);
				super.Timer(this.getId(), 30);
				break;
			case 6:		
				Event.events[3].setOpen(false);
				Event.events[52].setDrawn(true);
				super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 6, 7,"");
				super.Timer(this.getId(), 75);
				KeyManager.setCutsceneMode(false);
				break;
			case 7:
				super.Cutscene(scenes, this.getId());
				break;
			}
		}
		else{
			switch(this.getstage()){
			case 0: 
				Dialog[] d2 = new Dialog[1];
				d2[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Take me to floor Six, please. I need to get to work, and you¡¦re the only one who knows/how to use this Elevator thing./");
				super.Dialog(d2, 0, this.getId(), true);
				break;
			case 1:
				this.setstage(0);
				break;
			
			}
		}
			
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean drawn(){
		return drawn;
	}
}
