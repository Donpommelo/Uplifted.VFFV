package dev.zt.UpliftedVFFV.party;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.ActuallyNothing;
import dev.zt.UpliftedVFFV.ablities.DoorsofClosure;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.states.BattleState;
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
	
	//public int bonusAcc, bonusCrit, bonusScrip, bonusExp, bonusItem;
	public int[] bonusStats = {0,0,0,0,0};
	
	
//	public double RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public double[] elemRes = {.1,.1,.1,.1,.1,0};
	public double[] buffedRes;
	
	public int Lvl,exp,expCurrent;
	
	public int expDrop;
	public int scrDrop;
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();
	
	public boolean targetable;
	public boolean visible = true;
	public int flashDuration;
	public int x = 0;
	public int y = 0;
	public BufferedImage BattleSprite;
	public BufferedImage MenuSprite1;
	public ArrayList<Skills> skills;
	public TreeMap<Integer, Skills> levelSkills = new TreeMap<>();
	public ArrayList<status> statuses;
	public String name;
	public String bio;
	public Item itemSlot1,itemSlot2,itemSlot3;
//	public incapacitate i = new incapacitate();
	public Schmuck(String name,int lvl,BufferedImage sprite, int[] start, double[] growths,double[] elemRes){	
		this.BattleSprite=sprite;
		this.name=name;
		this.skills = new ArrayList<Skills>();
		this.statuses = new ArrayList<status>();
		this.Lvl=lvl;
		this.startStats=start;
		this.statGrowths=growths;
		this.buffedStats=start;
		this.elemRes = elemRes;
		this.buffedRes = elemRes;
		this.exp=0;
		int[] bonusStats = {0,0,0,0,0};
	}
	
	public Schmuck(String name,int lvl,BufferedImage sprite, BufferedImage msprite, int[] start, double[] growths,double[] elemRes){	
		this.BattleSprite=sprite;
		this.MenuSprite1 = msprite;
		this.name=name;
		this.skills = new ArrayList<Skills>();
		this.statuses = new ArrayList<status>();
		this.Lvl=lvl;
		this.startStats=start;
		this.statGrowths=growths;
		this.buffedStats=start;
		this.exp=0;
		this.elemRes = elemRes;
		this.buffedRes = elemRes;
		int[] bonusStats = {0,0,0,0,0};
	}
		
	public void hpChange(int hp){
		tempStats[0]+=hp;
		if(tempStats[0]<0){
			tempStats[0]=0;
			statuses.add(new incapacitate(this));
			
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
	
	public Action getAction(BattleState bs){
		return new Action(bs.bp.allies.get(0),bs.bp.allies.get(0),new StandardAttack(0),bs);
	
	}
	
	public void equip(Item i, int slot, InventoryManager meep){
		Item thing = null;
		switch(slot){
		case 1:
			thing = getItemSlot1();
			break;
		case 2:
			thing =  getItemSlot2();
			break;
		case 3:
			thing =  getItemSlot3();
			break;
		}
		if(meep.backpack.containsKey(i)){
			if(thing != null){
				thing.unEnchantment(this);
				meep.loot(thing,1);
				
			}
			thing = i;
			meep.use(i);
			switch(slot){
			case 1:
				setItemSlot1(i);
				break;
			case 2:
				setItemSlot2(i);
				break;
			case 3:
				setItemSlot3(i);
				break;
			}
			for(status s : i.getEnchantment(this)){
				this.statuses.add(s);
			}		
			calcBuffs();
		}			
	}	
	
	public Item getItemSlot1() {
		return itemSlot1;
	}

	public void setItemSlot1(Item itemSlot1) {
		this.itemSlot1 = itemSlot1;
	}

	public Item getItemSlot2() {
		return itemSlot2;
	}

	public void setItemSlot2(Item itemSlot2) {
		this.itemSlot2 = itemSlot2;
	}

	public Item getItemSlot3() {
		return itemSlot3;
	}

	public void setItemSlot3(Item itemSlot3) {
		this.itemSlot3 = itemSlot3;
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
	
	public double[] getElemRes(){
		return elemRes;
	}
	
	public double[] getBuffedRes(){
		return buffedRes;
	}
	
	public void lvlUp(int lvl){
		lvl--;
		setMaxHp(startStats[0]+(int)(lvl*statGrowths[0]));hpChange((int)(lvl*statGrowths[0]));
		setMaxBp(startStats[1]+(int)(lvl*statGrowths[1]));bpChange((int)(lvl*statGrowths[1]));
		setBasePow(startStats[2]+(int)(lvl*statGrowths[2]));setBuffedPow(getBasePow());
		setBaseDef(startStats[3]+(int)(lvl*statGrowths[3]));setBuffedDef(getBaseDef());
		setBaseSpd(startStats[4]+(int)(lvl*statGrowths[4]));setBuffedSpd(getBaseSpd());
		setBaseSkl(startStats[5]+(int)(lvl*statGrowths[5]));setBuffedSkl(getBaseSkl());
		setBaseInt(startStats[6]+(int)(lvl*statGrowths[6]));setBuffedInt(getBaseInt());
		setBaseLuk(startStats[7]+(int)(lvl*statGrowths[7]));setBuffedLuk(getBaseLuk());
		if(this.getLevelSkills().containsKey(Lvl)){
			learnSkill(this.getLevelSkills().get(Lvl));	
		}
	}
	
	public TreeMap<Integer, Skills> getLevelSkills() {
		return levelSkills;
	}

	public void calcBuffs(){
		for(int i=0; i <8; i++){
			buffedStats[i] = baseStats[i];
		}
		for(int i=0; i<6; i++){
			buffedRes[i] = elemRes[i];
		}
		for(int i=0; i<5; i++){
			bonusStats[i] = 0;
		}
		for(status s : this.statuses){
			s.statchanges(this);
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
	
	public TreeMap<Item, Double> getItemdrops() {
		return itemdrops;
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
	
	public String getBio() {
		return bio;
	}

	public BufferedImage getBattleSprite() {
		return BattleSprite;
	}
	
	public BufferedImage getMenuSprite() {
		return MenuSprite1;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getBonusAcc(){
		return bonusStats[0];
	}
	
	public void setBonusAcc(int bonus){
		bonusStats[0] = bonus;
	}
	
	public int getBonusCrit(){
		return bonusStats[1];
	}
	
	public void setBonusCrit(int bonus){
		bonusStats[1] = bonus;
	}
	
	public int getBonusScrip(){
		return bonusStats[2];
	}
	
	public void setBonusScrip(int bonus){
		bonusStats[2] = bonus;
	}
	
	public int getBonusExp(){
		return bonusStats[3];
	}
	
	public void setBonusExp(int bonus){
		bonusStats[3] = bonus;
	}
	
	public int getBonusItem(){
		return bonusStats[4];
	}
	
	public void setBonusItem(int bonus){
		bonusStats[4] = bonus;
	}
	
	public double getRedRes() {
		return buffedRes[0];
	}

	public void setRedRes(double buffedRedRes) {
		buffedRes[0] = buffedRedRes;
	}
	
	public double getBlueRes() {
		return buffedRes[1];
	}

	public void setBlueRes(double buffedBlueRes) {
		buffedRes[1] = buffedBlueRes;
	}
	
	public double getGreenRes() {
		return buffedRes[2];
	}

	public void setGreenRes(double buffedGreenRes) {
		buffedRes[2] = buffedGreenRes;
	}
	
	public double getYellowRes() {
		return buffedRes[3];
	}

	public void setYellowRes(double buffedYellowRes) {
		buffedRes[3] = buffedYellowRes;
	}
	
	public double getPurpleRes() {
		return buffedRes[4];
	}

	public void setPurpleRes(double buffedPurpleRes) {
		buffedRes[4] = buffedPurpleRes;
	}
	
	public double getVoidRes() {
		return buffedRes[5];
	}

	public void setVoidRes(double buffedVoidRes) {
		buffedRes[5] = buffedVoidRes;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getFlashDuration() {
		return flashDuration;
	}

	public void setFlashDuration(int flashDuration) {
		this.flashDuration = flashDuration;
	}
	
	
		
	
	
}
