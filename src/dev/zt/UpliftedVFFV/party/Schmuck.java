package dev.zt.UpliftedVFFV.party;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.ablities.DoorsofClosure;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Schmuck {
	
//	public int startHp=0,startBp=0,startPow=0, startDef=0, startSpd=0, startSkl=0, startLuk=0, startInt=0;
	public int[] startStats;
//	public static double hpGrowth=0, bpGrowth=0, powGrowth=0, defGrowth=0, spdGrowth=0, sklGrowth=0, intGrowth=0, lukGrowth=0;
	public double[] statGrowths;
//	public int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int[] baseStats = {0,0,0,0,0,0,0,0};
	public int[] buffedStats;
	public int[] tempStats = {10,10};
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public int Lvl,exp,expCurrent;
	public int expDrop;
	public int scrDrop;
	public BufferedImage BattleSprite;
	public ArrayList<Skills> skills;
	public TreeMap<Integer, Skills> levelSkills = new TreeMap<>();
	public ArrayList<status> statuses;
	public String name;
	public incapacitate i = new incapacitate();
	public Schmuck(String name,int lvl,BufferedImage sprite, int[] start, double[] growths){	
		this.BattleSprite=sprite;
		this.name=name;
		this.skills = new ArrayList<Skills>();
		this.statuses = new ArrayList<status>();
		this.Lvl=lvl;
		this.startStats=start;
		this.statGrowths=growths;
//		this.baseStats=start;
		this.buffedStats=start;
		this.exp=0;
//		calcStats(startStats,statGrowths,lvl);
	}
	
	public void hpChange(int hp){
		tempStats[0]+=hp;
		if(tempStats[0]<0){
			tempStats[0]=0;
			statuses.add(i);
		}
		if(tempStats[0]>baseStats[0]){
			tempStats[0]=baseStats[0];
		}
	}
	
	public void bpChange(int bp){
		tempStats[1]+=bp;
		if(tempStats[1]<0){
			tempStats[1]=0;
		}
		if(tempStats[1]>baseStats[1]){
			tempStats[1]=baseStats[1];
		}
		
	}
	
	public void expGain(int[] start,double[] growth, int xp){
		exp+=xp;
		while(exp>=Math.pow(Lvl,2)*10){
//		if(exp>=Lvl*100){
			Lvl++;
			lvlUp(Lvl);
		}
	}
	
	public void calcStats(int lvl){
		lvl--;
		setMaxHp(startStats[0]+(int)(lvl*statGrowths[0]));setCurrentHp(getMaxHp());
		setMaxBp(startStats[1]+(int)(lvl*statGrowths[1]));setCurrentBp(getMaxBp());
		setBasePow(startStats[2]+(int)(lvl*statGrowths[2]));setBuffedPow(getBasePow());
		setBaseDef(startStats[3]+(int)(lvl*statGrowths[3]));setBuffedDef(getBaseDef());
		setBaseSpd(startStats[4]+(int)(lvl*statGrowths[4]));setBuffedSpd(getBaseSpd());
		setBaseSkl(startStats[5]+(int)(lvl*statGrowths[5]));setBuffedSkl(getBaseSkl());
		setBaseInt(startStats[6]+(int)(lvl*statGrowths[6]));setBuffedInt(getBaseInt());
		setBaseLuk(startStats[7]+(int)(lvl*statGrowths[7]));setBuffedLuk(getBaseLuk());
	}
	

	public int getLvl() {
		return Lvl;
	}
	
	public int getExp() {
		return exp;
	}
	
	public int[] getStartStats() {
		return startStats;
	}

	public double[] getStatGrowths() {
		return statGrowths;
	}
	
	public void lvlUp(int lvl){
		lvl--;
		setMaxHp(startStats[0]+(int)(lvl*statGrowths[0]));setCurrentHp(getCurrentHp()+(int)(lvl*statGrowths[0]));
		setMaxBp(startStats[1]+(int)(lvl*statGrowths[1]));setCurrentBp(getCurrentBp()+(int)(lvl*statGrowths[1]));
		setBasePow(startStats[2]+(int)(lvl*statGrowths[2]));setBuffedPow(getBasePow());
		setBaseDef(startStats[3]+(int)(lvl*statGrowths[3]));setBuffedDef(getBaseDef());
		setBaseSpd(startStats[4]+(int)(lvl*statGrowths[4]));setBuffedSpd(getBaseSpd());
		setBaseSkl(startStats[5]+(int)(lvl*statGrowths[5]));setBuffedSkl(getBaseSkl());
		setBaseInt(startStats[6]+(int)(lvl*statGrowths[6]));setBuffedInt(getBaseInt());
		setBaseLuk(startStats[7]+(int)(lvl*statGrowths[7]));setBuffedLuk(getBaseLuk());
		if(levelSkills.containsKey(Lvl)){
			learnSkill(levelSkills.get(Lvl));
		}
	}
	
	public int getMaxHp() {
		return baseStats[0];
	}

	public void setMaxHp(int maxHp) {
		baseStats[0] = maxHp;
	}

	public int getCurrentHp() {
		return tempStats[0];
	}

	public void setCurrentHp(int currentHp) {
		tempStats[0] = currentHp;
	}

	public int getMaxBp() {
		return baseStats[1];
	}

	public void setMaxBp(int maxBp) {
		baseStats[1] = maxBp;
	}

	public int getCurrentBp() {
		return tempStats[1];
	}

	public void setCurrentBp(int currentBp) {
		tempStats[1] = currentBp;
	}
	
	public void learnSkill(Skills s){
		skills.add(s);
	}
	
	public int getExpDrop() {
		return expDrop;
	}

	public int getScrDrop() {
		return scrDrop;
	}
	
	public int getBasePow() {
		return baseStats[2];
	}

	public void setBasePow(int basePow) {
		baseStats[2] = basePow;
	}

	public int getBuffedPow() {
		return buffedStats[2];
	}

	public void setBuffedPow(int buffedPow) {
		buffedStats[2] = buffedPow;
	}

	public int getBaseDef() {
		return baseStats[3];
	}

	public void setBaseDef(int baseDef) {
		baseStats[3] = baseDef;
	}

	public int getBuffedDef() {
		return buffedStats[3];
	}

	public void setBuffedDef(int buffedDef) {
		buffedStats[3] = buffedDef;
	}

	public int getBaseSpd() {
		return baseStats[4];
	}

	public void setBaseSpd(int baseSpd) {
		baseStats[4] = baseSpd;
	}

	public int getBuffedSpd() {
		return buffedStats[4];
	}

	public void setBuffedSpd(int buffedSpd) {
		buffedStats[4] = buffedSpd;
	}

	public int getBaseSkl() {
		return baseStats[5];
	}

	public void setBaseSkl(int baseSkl) {
		baseStats[5] = baseSkl;
	}

	public int getBuffedSkl() {
		return buffedStats[5];
	}

	public void setBuffedSkl(int buffedSkl) {
		buffedStats[5] = buffedSkl;
	}

	public int getBaseInt() {
		return baseStats[6];
	}

	public void setBaseInt(int baseInt) {
		baseStats[6] = baseInt;
	}

	public int getBuffedInt() {
		return buffedStats[6];
	}

	public void setBuffedInt(int buffedInt) {
		buffedStats[6] = buffedInt;
	}

	public int getBaseLuk() {
		return baseStats[7];
	}

	public void setBaseLuk(int baseLuk) {
		baseStats[7] = baseLuk;
	}

	public int getBuffedLuk() {
		return buffedStats[7];
	}

	public void setBuffedLuk(int buffedLuk) {
		buffedStats[7] = buffedLuk;
	}

	public String getName() {
		return name;
	}

	public BufferedImage getBattleSprite() {
		return BattleSprite;
	}


	public void attack(Schmuck victim){
		victim.tempStats[0]-=this.buffedStats[2]*this.buffedStats[2]/victim.buffedStats[3];
		
	}
	
	public void cast(int skillindex){
		
	}
	
	
	
}
