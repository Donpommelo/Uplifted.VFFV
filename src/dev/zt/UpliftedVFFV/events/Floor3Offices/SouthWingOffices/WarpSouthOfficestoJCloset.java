package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthOfficestoJCloset extends Event {
	
	public static int stagenum = 0;
	public WarpSouthOfficestoJCloset(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/JanitorClosetTutorial.txt", 5, 10,"Broom Closet");
	}
	
	public boolean isDoor(){
		return true;
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
