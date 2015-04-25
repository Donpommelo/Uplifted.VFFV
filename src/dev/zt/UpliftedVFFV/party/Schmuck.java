package dev.zt.UpliftedVFFV.party;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Schmuck {
	
	public int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public int Lvl;
	public BufferedImage BattleSprite;
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public String name;
	public incapacitate i = new incapacitate();
	public Schmuck(String name,int hp,int bp,int pow,int def,int spd, int skl, int smart, int luk,BufferedImage sprite){
		this.MaxHp=hp;this.CurrentHp=hp;
		this.MaxBp=bp;this.CurrentBp=bp;
		this.BasePow=pow;this.BuffedPow=pow;
		this.BaseDef=def;this.BuffedDef=def;
		this.BaseSpd=spd;this.BuffedSpd=spd;
		this.BaseSkl=skl;this.BuffedSkl=skl;
		this.BaseInt=smart;this.BuffedInt=smart;
		this.BaseLuk=luk;this.BuffedLuk=luk;
		this.BattleSprite=sprite;
		this.name=name;
		this.skills = new ArrayList<Skills>();
		this.statuses = new ArrayList<status>();
	}
	
	public void hpChange(int hp){
		CurrentHp+=hp;
		if(CurrentHp<0){
			CurrentHp=0;
			statuses.add(i);
			
		}
		if(CurrentHp>MaxHp){
			CurrentHp=MaxHp;
		}
	}
	
	public void bpChange(int bp){
		CurrentBp+=bp;
		if(CurrentBp<0){
			CurrentBp=0;
		}
		if(CurrentBp>MaxBp){
			CurrentBp=MaxBp;
		}
	}
	
	public int getMaxHp() {
		return MaxHp;
	}

	public void setMaxHp(int maxHp) {
		MaxHp = maxHp;
	}

	public int getCurrentHp() {
		return CurrentHp;
	}

	public void setCurrentHp(int currentHp) {
		CurrentHp = currentHp;
	}

	public int getMaxBp() {
		return MaxBp;
	}

	public void setMaxBp(int maxBp) {
		MaxBp = maxBp;
	}

	public int getCurrentBp() {
		return CurrentBp;
	}

	public void setCurrentBp(int currentBp) {
		CurrentBp = currentBp;
	}
	
	public void learnSkill(Skills s){
		skills.add(s);
	}

	public int getBasePow() {
		return BasePow;
	}

	public void setBasePow(int basePow) {
		BasePow = basePow;
	}

	public int getBuffedPow() {
		return BuffedPow;
	}

	public void setBuffedPow(int buffedPow) {
		BuffedPow = buffedPow;
	}

	public int getBaseDef() {
		return BaseDef;
	}

	public void setBaseDef(int baseDef) {
		BaseDef = baseDef;
	}

	public int getBuffedDef() {
		return BuffedDef;
	}

	public void setBuffedDef(int buffedDef) {
		BuffedDef = buffedDef;
	}

	public int getBaseSpd() {
		return BaseSpd;
	}

	public void setBaseSpd(int baseSpd) {
		BaseSpd = baseSpd;
	}

	public int getBuffedSpd() {
		return BuffedSpd;
	}

	public void setBuffedSpd(int buffedSpd) {
		BuffedSpd = buffedSpd;
	}

	public int getBaseSkl() {
		return BaseSkl;
	}

	public void setBaseSkl(int baseSkl) {
		BaseSkl = baseSkl;
	}

	public int getBuffedSkl() {
		return BuffedSkl;
	}

	public void setBuffedSkl(int buffedSkl) {
		BuffedSkl = buffedSkl;
	}

	public int getBaseInt() {
		return BaseInt;
	}

	public void setBaseInt(int baseInt) {
		BaseInt = baseInt;
	}

	public int getBuffedInt() {
		return BuffedInt;
	}

	public void setBuffedInt(int buffedInt) {
		BuffedInt = buffedInt;
	}

	public int getBaseLuk() {
		return BaseLuk;
	}

	public void setBaseLuk(int baseLuk) {
		BaseLuk = baseLuk;
	}

	public int getBuffedLuk() {
		return BuffedLuk;
	}

	public void setBuffedLuk(int buffedLuk) {
		BuffedLuk = buffedLuk;
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
