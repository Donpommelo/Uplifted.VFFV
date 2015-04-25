package dev.zt.UpliftedVFFV.party;


import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BossJorge extends Schmuck{

	
	public int CurrentHp,CurrentMp;
	public int BuffedHp,BuffedMp,BuffedPow,BuffedDef,BuffedSpd,BuffedSkl,BuffedInt,BuffedLuk;
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public BossJorge() {
		super("Jorge",100,50, 12, 20, 17, 8, 10, 5,ImageLoader.loadImage("/CharacterBusts/3rdSouthOffices-5.png"));
		

	}
	
//	public Action getAction(){
//		Math.random()
		
//	}

}
