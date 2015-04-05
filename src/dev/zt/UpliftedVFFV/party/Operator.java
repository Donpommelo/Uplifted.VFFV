package dev.zt.UpliftedVFFV.party;


import dev.zt.UpliftedVFFV.gfx.ImageLoader;

public class Operator extends Schmuck{

	
	public int CurrentHp,CurrentMp;
	public int BuffedHp,BuffedMp,BuffedPow,BuffedDef,BuffedSpd,BuffedSkl,BuffedInt,BuffedLuk;
	public Operator() {
		super("Operator",50, 35, 17, 18, 15, 13, 12, 18,ImageLoader.loadImage("/CharacterBusts/Player-1.png"));
		

	}

}
