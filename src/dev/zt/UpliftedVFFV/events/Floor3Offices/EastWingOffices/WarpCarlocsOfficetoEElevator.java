package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCarlocsOfficetoEElevator extends Event {
	
	public static int stagenum = 0;
	public WarpCarlocsOfficetoEElevator(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(super.getQuest(5) > 6){
			game.getAudiomanager().playMusic(1, true);
			super.getGamestate().getEvents()[215].setOpen(false);
			super.getGamestate().getEvents()[215].setFrames(6);
			super.transport("/Worlds/ElevatorsandBackroom/EastElevator.txt", 5, 7,"East Elevator");
		}
		else{
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The door is locked./");
			d[1] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"You shouldn't be poking around in other people's offices./");
			super.Dialog(d, 1, this.getId(), true);

		}
	}
}
