package dev.zt.UpliftedVFFV.party;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
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
	public int[] buffedStats = {0,0,0,0,0,0,0,0};
	public int[] tempStats = {10,10};
	
	
	//public int bonusAcc, bonusEva, bonusScrip, bonusExp, bonusItem, fortune,elemAlignment,damAmp,damRes,itemPow,equipPow,
	//bonusML, combatFreq,mpCost,bonusInit,damageVariance, critChance, critMulti, healPower,RedRes,BlueRes,GreenRes,YellRes;
	//PurpRes,VoidRes, RunawayBonus, DiscountBonus, SummonPower

	public double[] bonusStats = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	
//	public double RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public int[] elemPoints;
	public int[] buffedElemPoints = {0,0,0,0,0,0};
	
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
	
	public Item[] items = {null,null,null,null,null};
	public int itemSlots;
	public Schmuck itemDummy;	
	public String name;
	public String bio;
	public Schmuck(String name,int lvl,BufferedImage sprite, int[] start, double[] growths,int[] elem, int exp, int script){	
		this.BattleSprite=sprite;
		this.name=name;
		this.skills = new ArrayList<Skills>();
		this.statuses = new ArrayList<status>();
		this.Lvl=lvl;
		this.startStats=start;
		this.statGrowths=growths;
//		this.buffedStats=start;
		this.elemPoints = elem;
		this.exp=0;
		this.bonusStats = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		this.itemSlots = 4;
		this.itemDummy = new Schmuck();
		this.expDrop = exp;
		this.scrDrop = script;
	}
	
	public Schmuck(String name,int lvl,BufferedImage sprite, BufferedImage msprite, int[] start, double[] growths,int[] elem){	
		this.BattleSprite=sprite;
		this.MenuSprite1 = msprite;
		this.name=name;
		this.skills = new ArrayList<Skills>();
		this.statuses = new ArrayList<status>();
		this.Lvl=lvl;
		this.startStats=start;
		this.statGrowths=growths;
//		this.buffedStats=start;
		this.exp=0;
		this.elemPoints = elem;
		this.bonusStats = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		this.itemSlots = 4;
		this.itemDummy = new Schmuck();
	}
	
	public Schmuck(){
		this.name = "Item Dummy";
		//for itemdummy
	}
		
	public void hpChange(int hp){
		tempStats[0]+=hp;
		if(tempStats[0]<0){
			tempStats[0]=0;
			statuses.add(new incapacitate(this));
			for(int i=0; i<statuses.size(); i++){
				if(statuses.get(i)!=null){
					if(statuses.get(i).perm != true){
						statuses.remove(i);
					}
				}
			}
			
		}
		if(tempStats[0]>buffedStats[0]){
			tempStats[0]=buffedStats[0];
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
	
	//Character stats are set upon initial creation
	public void calcStats(int lvl){
		lvl--;
		
		for(int i = 0 ; i< this.startStats.length; i++){
			int argh = startStats[i];
			buffedStats[i] = argh;			
		}
		
		for(int i = 0 ; i< this.elemPoints.length; i++){
			int argh = elemPoints[i];
			buffedElemPoints[i] = argh;			
		}
		
		setBaseHp(startStats[0]+(int)(lvl*statGrowths[0]));setCurrentHp(getBaseHp());
		setBaseBp(startStats[1]+(int)(lvl*statGrowths[1]));setCurrentBp(getBaseBp());
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
		if(meep.backpack.containsKey(i)){
			if(slot < itemSlots){
				if(items[slot] != null){
					meep.loot(items[slot],1);
					items[slot].unEnchantment(this);
				}
				meep.use(i);
				items[slot] = i;
				for(int j=0; j<this.statuses.size(); j++){
					if(statuses.get(j) != null){
						if(statuses.get(j).perp.equals(itemDummy)){
							statuses.remove(j);
							j--;
						}
					}					
				}
				for(Item it : items){
					if(it != null){
						for(status s : it.getEnchantment(this)){
							this.statuses.add(s);
						}
					}
					
				}
				
				calcBuffs(null);
			}
		}
		
	}
	
	public Schmuck getItemDummy(){
		return itemDummy;
	}
	
	public int getItemSlots(){
		return itemSlots;
	}
	
	public Item[] getItems(){
		return items;
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
	
	public int[] getElemPoints(){
		return elemPoints;
	}
	
	public int[] getBuffedElemPoints(){
		return buffedElemPoints;
	}
	
	public double[] getBonusStats(){
		return bonusStats;
	}
	
	public void lvlUp(int lvl){
		lvl--;
		setBaseHp(startStats[0]+(int)(lvl*statGrowths[0]));hpChange((int)(lvl*statGrowths[0]));
		setBaseBp(startStats[1]+(int)(lvl*statGrowths[1]));bpChange((int)(lvl*statGrowths[1]));
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

	public void calcBuffs(BattleState bs){

		for(int i=0; i <baseStats.length; i++){
			buffedStats[i] = baseStats[i];
		}
		for(int i=0; i<elemPoints.length; i++){
			buffedElemPoints[i] = elemPoints[i];
		}
		for(int i=0; i<bonusStats.length; i++){
			bonusStats[i] = 0;
		}
		int j;
		boolean flag = true;
		status temp;
		while (flag){
			flag=false;
			for(j=0; j<this.statuses.size()-1; j++){
				if(this.statuses.get(j) != null && this.statuses.get(j+1) != null){
					if(this.statuses.get(j).getPriority() > this.statuses.get(j+1).getPriority()){
						temp = this.statuses.get(j);
						this.statuses.set(j,this.statuses.get(j+1));
						this.statuses.set(j+1,temp);
						flag = true;
					}
				}
			}
		}
		for(status s : this.statuses){
			if(s != null){
				s.statchanges(this);
			}
		}
		this.setRedRes((this.getRedPoints()+this.getBluePoints()+this.getYellowPoints()-this.getGreenPoints()-this.getPurplePoints()));
		this.setBlueRes((-this.getRedPoints()+this.getBluePoints()+this.getYellowPoints()+this.getGreenPoints()-this.getPurplePoints()));
		this.setGreenRes((this.getRedPoints()-this.getBluePoints()-this.getYellowPoints()+this.getGreenPoints()+this.getPurplePoints()));
		this.setYellowRes((-this.getRedPoints()-this.getBluePoints()+this.getYellowPoints()+this.getGreenPoints()+this.getPurplePoints()));
		this.setPurpleRes((this.getRedPoints()+this.getBluePoints()-this.getYellowPoints()-this.getGreenPoints()+this.getPurplePoints()));
		this.setVoidRes(this.getVoidPoints()/100);
		for(int i = 0 ; i< this.getBuffedElemPoints().length; i++){
			if(this.buffedElemPoints[i] > this.getPrismaticPoints()){
				this.setElemAlignment(i+1);
				i = this.getBuffedElemPoints().length;
				if(bs != null){
					bs.bp.bt.textList.add(this.getName()+" became elementally aligned! "+i);
				}
			}
			else{
				this.setElemAlignment(0);
			}
		}

		if(this.getCurrentHp()>this.getMaxHp()){
			this.setCurrentHp(this.getMaxHp());
		}
		if(this.getCurrentBp()>this.getMaxBp()){
			this.setCurrentBp(this.getMaxBp());
		}		
	}
	
	public int getMaxHp() {
		return buffedStats[0];
	}

	public void setMaxHp(int maxHp) {
		buffedStats[0] = maxHp;
	}

	public int getCurrentHp() {
		return tempStats[0];
	}

	public void setCurrentHp(int currentHp) {
		tempStats[0] = currentHp;
	}

	public int getMaxBp() {
		return buffedStats[1]+buffedStats[6]/2;
	}

	public void setMaxBp(int maxBp) {
		buffedStats[1] = maxBp;
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
	
	public void forgetSkill(Skills s){
		if(skills.contains(s)){
			skills.remove(s);
		}
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
	
	public int getBaseHp() {
		return baseStats[0];
	}

	public void setBaseHp(int baseHp) {
		baseStats[0] = baseHp;
	}
	
	public int getBaseBp() {
		return baseStats[1]+buffedStats[6]/2;
	}

	public void setBaseBp(int baseBp) {
		baseStats[1] = baseBp;
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
	
	public double getBonusAcc(){
		return bonusStats[0];
	}
	
	public void setBonusAcc(double bonus){
		bonusStats[0] = bonus;
	}
	
	public double getBonusEva(){
		return bonusStats[1];
	}
	
	public void setBonusEva(double bonus){
		bonusStats[1] = bonus;
	}
	
	public double getBonusScrip(){
		return bonusStats[2];
	}
	
	public void setBonusScrip(double bonus){
		bonusStats[2] = bonus;
	}
	
	public double getBonusExp(){
		return bonusStats[3];
	}
	
	public void setBonusExp(double bonus){
		bonusStats[3] = bonus;
	}
	
	public double getBonusItem(){
		return bonusStats[4];
	}
	
	public void setBonusItem(double bonus){
		bonusStats[4] = bonus;
	}
	
	public double getFortune(){
		return bonusStats[5];
	}
	
	public void setFortune(double bonus){
		bonusStats[5] = bonus;
	}
	
	public double getElemAlignment(){
		return bonusStats[6];
	}
	
	public void setElemAlignment(double bonus){
		bonusStats[6] = bonus;
	}
	
	public double getDamAmp(){
		return bonusStats[7];
	}
	
	public void setDamAmp(double bonus){
		bonusStats[7] = bonus;
	}
	public double getDamRes(){
		return bonusStats[8];
	}
	
	public void setDamRes(double bonus){
		bonusStats[8] = bonus;
	}
	
	public double getItemPow(){
		return bonusStats[9];
	}
	
	public void setItemPow(double bonus){
		bonusStats[9] = bonus;
	}
	public double getEquipPow(){
		return bonusStats[10];
	}
	
	public void setEquipPow(double bonus){
		bonusStats[10] = bonus;
	}
	
	public double getBonusML(){
		return bonusStats[11];
	}
	
	public void setBonusML(double bonus){
		bonusStats[11] = bonus;
	}
	
	public double getCombatFreq(){
		return bonusStats[12];
	}
	
	public void setCombatFreq(double bonus){
		bonusStats[12] = bonus;
	}
	
	public double getMpCost(){
		return bonusStats[13];
	}
	
	public void setMpCost(double bonus){
		bonusStats[13] = bonus;
	}
	
	public double getBonusInit(){
		return bonusStats[14];
	}
	
	public void setBonusInit(double bonus){
		bonusStats[14] = bonus;
	}
	
	public double getDamageVariance(){
		return bonusStats[15];
	}
	
	public void setDamageVariance(double bonus){
		bonusStats[15] = bonus;
	}
	
	public double getCritChance(){
		return bonusStats[16];
	}
	
	public void setCritChance(double bonus){
		bonusStats[16] = bonus;
	}
	
	public double getCritMulti(){
		return bonusStats[17];
	}
	
	public void setCritMulti(double bonus){
		bonusStats[17] = bonus;
	}
	
	public double getHealPower(){
		return bonusStats[18];
	}
	
	public void setHealPower(double bonus){
		bonusStats[18] = bonus;
	}
	
	public double getRedRes() {
		return bonusStats[19];
	}

	public void setRedRes(double buffedRedRes) {
		bonusStats[19] = buffedRedRes;
	}
	
	public double getBlueRes() {
		return bonusStats[20];
	}

	public void setBlueRes(double buffedBlueRes) {
		bonusStats[20] = buffedBlueRes;
	}
	
	public double getGreenRes() {
		return bonusStats[21];
	}

	public void setGreenRes(double buffedGreenRes) {
		bonusStats[21] = buffedGreenRes;
	}
	
	public double getYellowRes() {
		return bonusStats[22];
	}

	public void setYellowRes(double buffedYellowRes) {
		bonusStats[22] = buffedYellowRes;
	}
	
	public double getPurpleRes() {
		return bonusStats[23];
	}

	public void setPurpleRes(double buffedPurpleRes) {
		bonusStats[23] = buffedPurpleRes;
	}
	
	public double getVoidRes() {
		return bonusStats[24];
	}

	public void setVoidRes(double buffedVoidRes) {
		bonusStats[24] = buffedVoidRes;
	}
	
	public double getRunawayBonus() {
		return bonusStats[25];
	}

	public void setRunawayBonus(double runaway) {
		bonusStats[25] = runaway;
	}
	
	public int getRedPoints(){
		return buffedElemPoints[0];
	}
	
	public void setRedPoints(int red){
		buffedElemPoints[0] = red;
	}
	
	public int getBluePoints(){
		return buffedElemPoints[1];
	}
	
	public void setBluePoints(int blue){
		buffedElemPoints[1] =blue;
	}
	
	public int getGreenPoints(){
		return buffedElemPoints[2];
	}
	
	public void setGreenPoints(int green){
		buffedElemPoints[2] = green;
	}
	
	public int getYellowPoints(){
		return buffedElemPoints[3];
	}
	
	public void setYellowPoints(int yellow){
		buffedElemPoints[3] = yellow;
	}
	
	public int getPurplePoints(){
		return buffedElemPoints[4];
	}
	
	public void setPurplePoints(int purple){
		buffedElemPoints[4] = purple;
	}
	
	public int getVoidPoints(){
		return buffedElemPoints[5];
	}
	
	public void setVoidPoints(int meep){
		buffedElemPoints[5] = meep;
	}
	
	public int getPrismaticPoints(){
		return buffedElemPoints[0] + buffedElemPoints[1] + buffedElemPoints[2] + buffedElemPoints[3] + buffedElemPoints[4];
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
