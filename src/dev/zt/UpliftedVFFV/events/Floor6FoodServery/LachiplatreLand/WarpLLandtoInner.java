package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLLandtoInner extends Event {
	
	public static int stagenum = 0;
	public WarpLLandtoInner(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand1Inner.txt",(int)(gamestate.getPlayer().getPlayerX()/32)-16,42,"");
	}
}
