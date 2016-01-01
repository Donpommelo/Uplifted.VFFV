package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpJClosettoSouthOffices extends Event {
	
	public static int stagenum = 0;
	public WarpJClosettoSouthOffices(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthWingSection1.txt", 13, 16,"South Offices");
	}
}
