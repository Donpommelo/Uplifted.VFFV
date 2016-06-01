package dev.zt.UpliftedVFFV.events.Floor1Reception;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthRoom1toSouthMain extends Event {
	
	public static int stagenum = 0;
	public WarpSouthRoom1toSouthMain(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[307].setOpen(false);
		super.getGamestate().getEvents()[307].setFrames(6);
		super.transport("/Worlds/Floor1Reception/SouthLobbyMain.txt", 5, 17,"");
	}
}
