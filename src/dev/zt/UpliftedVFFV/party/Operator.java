package dev.zt.UpliftedVFFV.party;


import java.util.ArrayList;






import dev.zt.UpliftedVFFV.ablities.DillyDally;
import dev.zt.UpliftedVFFV.ablities.DoorsofClosure;
import dev.zt.UpliftedVFFV.ablities.MotorGrinder;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Operator extends Schmuck{

	
	public int CurrentHp,CurrentMp;
	public int BuffedHp,BuffedMp,BuffedPow,BuffedDef,BuffedSpd,BuffedSkl,BuffedInt,BuffedLuk;
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public Operator() {
		super("Operator",50, 35, 17, 18, 17, 13, 12, 18,ImageLoader.loadImage("/CharacterBusts/Player-1.png"));
		this.skills = new ArrayList<Skills>(1);
		super.learnSkill(new DoorsofClosure(0));
		super.learnSkill(new MotorGrinder(0));


	}

}
