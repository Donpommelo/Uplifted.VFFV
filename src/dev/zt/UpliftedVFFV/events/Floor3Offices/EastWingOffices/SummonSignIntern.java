package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.PenPal;

public class SummonSignIntern extends Event {


	public static int stagenum = 1;
	//Change texture later
	public static BufferedImage img=Assets.Monolith;
	public SummonSignIntern(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		super.Summon(new PenPal(1), this.getId());
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
