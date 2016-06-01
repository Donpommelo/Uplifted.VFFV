package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLLandInnertoOuter extends Event {
	
	public static int stagenum = 0;
	public WarpLLandInnertoOuter(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand1.txt",(int)(gamestate.getPlayer().getPlayerX()/32)+16,11,"");
	}
}
