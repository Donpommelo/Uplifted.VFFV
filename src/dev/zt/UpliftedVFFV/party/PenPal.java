package dev.zt.UpliftedVFFV.party;


import java.util.ArrayList;

import dev.zt.UpliftedVFFV.ablities.DillyDally;
import dev.zt.UpliftedVFFV.ablities.DoorsofClosure;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PenPal extends Schmuck{

	
	
	public int CurrentHp,CurrentMp;
	public int BuffedHp,BuffedMp,BuffedPow,BuffedDef,BuffedSpd,BuffedSkl,BuffedInt,BuffedLuk;
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public PenPal() {
		super("Pen Pal",42, 40, 15, 17, 12, 22, 25, 16,ImageLoader.loadImage("/CharacterBusts/Player-5.png"));


	}

}
