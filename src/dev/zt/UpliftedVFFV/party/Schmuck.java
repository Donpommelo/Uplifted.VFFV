package dev.zt.UpliftedVFFV.party;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.ablities.Skills;

public class Schmuck {
	
	public int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public BufferedImage BattleSprite;
	public Skills[] skills;
	public String name;
	public Schmuck(String name,int hp,int bp,int pow,int def,int spd, int skl, int smart, int luk,BufferedImage sprite){
		this.MaxHp=hp;this.CurrentHp=hp;
		this.MaxBp=bp;this.CurrentBp=bp;
		this.BasePow=pow;this.BuffedPow=pow;
		this.BaseDef=def;this.BuffedDef=def;
		this.BaseSpd=spd;this.BuffedSpd=spd;
		this.BattleSprite=sprite;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public BufferedImage getBattleSprite() {
		return BattleSprite;
	}


	public void attack(Schmuck victim){
		victim.CurrentHp-=this.BuffedPow*this.BuffedPow/victim.BaseDef;
		
	}
	
	public void cast(int skillindex){
		
	}
	
	
	
}
