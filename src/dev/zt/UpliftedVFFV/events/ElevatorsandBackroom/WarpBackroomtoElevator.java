package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;


public class WarpBackroomtoElevator extends Event {

	public BufferedImage[] scenes = new BufferedImage[2];
	public static int stagenum = 1;
	public WarpBackroomtoElevator(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
		scenes[0]=ImageLoader.loadImage("/Cutscenes/Intro1.png");
		scenes[1]=ImageLoader.loadImage("/Cutscenes/Intro2.png");
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			switch(this.getstage()){
			case 0:
				super.Cutscene(scenes, this.getId());
				super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 5, 9,"South Elevator");
				break;
			case 1:	
				this.setSelfswitch1(true);
				Dialog[] d = new Dialog[9];
				d[0] = new Dialog("Employee" ,"/CharacterBusts/3rdSouthOffices-1.png" ,1 ,"Hey. You're finally up./");
				d[1] = new Dialog("Operator" ,"/CharacterBusts/Player-1.png" ,0 ,"!!!/");
				d[2] = new Dialog("Operator" ,"/CharacterBusts/Player-1.png" ,0 ,"Oh. You surprised me. Sorry, I seem to have waken up late today. I hope I haven't kept/you waiting for too long. So, what floor for you?/");
				d[3] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I haven't been here too long. Not long enough to get any work done at least./Oh, and the Sixth Floor, please. As usual./");
				d[4] = new Dialog("Operator" ,"/CharacterBusts/Player-1.png" ,0 ,"Right away!/");
				d[5] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Oh, and one more thing./");
				d[6] = new Dialog("Operator" ,"/CharacterBusts/Player-1.png" ,0 ,"Hmm?/");
				d[7] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"My boss wanted me to warn you not to . . . uh. . ./Try not to . . . er . . . Don't go to the . . . um./Drat. I forgot. Oh well./");
				d[8] = new Dialog("Operator" ,"/CharacterBusts/Player-1.png" ,0 ,". . ./");
				super.Dialog(d, 8, this.getId(), true);
				break;
			}	
		}
		else{
			super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 5, 9,"South Elevator");
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
	public boolean isDoor(){
		return true;
	}

}
