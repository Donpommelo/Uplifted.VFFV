package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.world.EventManager;

public class EventEmployeeIntro extends Event {

	public static float xPos,yPos;
	public boolean selfswitch1=false;
	public static int stage=0;						
	public static int finalstage=7;		
	public boolean drawn = true;
	public boolean solid = true;
	public static BufferedImage img=Assets.EmployeeM2;
	public static BufferedImage[] scenes = new BufferedImage[2]; 
	public EventEmployeeIntro(float x, float y, int idnum) {
		super(img,idnum,x, y);
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
			
		if(Player.getPlayerX()==128 && Player.getPlayerY()==128){
			switch(stage){
			case 0: 
				Event.events[this.getId()].test.runlast = 3;
				super.Dialog(10, 11,this.getId());
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
				selfswitch1 = true;
				Event.events[3].setOpen(false);
				super.Timer(this.getId(), 60);
				break;
			case 5:
				Event.events[3].setOpen(true);
				super.Timer(this.getId(), 30);
				break;
			case 6:		
				Event.events[3].setOpen(false);
				Event.events[40].setDrawn(true);
				super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 4, 4,"");
				super.Timer(this.getId(), 75);
				KeyManager.setCutsceneMode(false);
				break;
			case 7:
				super.Cutscene(scenes, this.getId());
				break;
			}
		}
		else{
			switch(stage){
			case 0: 
				super.Dialog(9,9,this.getId());	
				break;
			case 1:
				stage = 0;
				break;
			
		}
		}
			
	}
	
	public int getfinalstage() {
		return finalstage;
	}


	public int getstage() {
		return stage;
	}

	public void setstage(int stage) {
		EventEmployeeIntro.stage = stage;
	}
	
	public boolean isSelfswitch1() {
		return selfswitch1;
	}

	public void setSelfswitch1(boolean selfswitch1) {
		this.selfswitch1 = selfswitch1;
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public boolean drawn(){
		return drawn;
	}
}
