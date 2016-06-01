package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpWestTransitiontoWestOfficesIntro extends Event {
	
	public static int stagenum = 0;
	public WarpWestTransitiontoWestOfficesIntro(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/WestWingOffices/WestIntroOffices.txt",(int)(gamestate.getPlayer().getPlayerX()/32)+28,36,"");
	}
}
