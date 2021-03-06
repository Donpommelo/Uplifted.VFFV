package dev.zt.UpliftedVFFV.party;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.Purified;
import dev.zt.UpliftedVFFV.statusEffects.Undead;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Schmuck implements Serializable{
	
	private static final long serialVersionUID = -7556561902401868149L;
	
	public int[] startStats;
	public double[] statGrowths;
	public int[] baseStats = {0,0,0,0,0,0,0,0};
	public int[] buffedStats = {0,0,0,0,0,0,0,0};
	public int[] tempStats = {10,10};
	
	//Bonus stats:
	//bonusAcc, bonusEva, bonusScrip, bonusExp, bonusItem, fortune,elemAlignment,damAmp,damRes,itemPow,equipPow,
	//bonusML, combatFreq,mpCost,bonusInit,damageVariance, critChance, critMulti, healPower,RedRes,BlueRes,GreenRes,YellRes;
	//PurpRes,VoidRes, RunawayBonus, DiscountBonus, SummonPower!, DamageStat,  lvlreqMod!, critRes, regenBonus, chargeBonus
	//cooldownBonus, critAvoid, channelingBonus, PassiveHpRegen, PassiveMpRegen, DefenseStat, AttackDamage, DamageReduction

	public double[] bonusStats = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	public int[] elemPoints;
	public int[] buffedElemPoints = {0,0,0,0,0,0};
	
	public int Lvl;
	public int exp = 0;
	
	public int expDrop;
	public int scrDrop;
	public TreeMap<Item, Double> itemdrops;// = new TreeMap<>();
	
	public boolean targetable;
	public boolean visible = true;
	public boolean defaultLocation = true;
	public int flashDuration, damageTaken, colorDamage;
	public int x = 0;
	public int y = 0;
	
	//Index of BattleSprite and Dialogue Sprite to use.
	public int battleSprite;
	public int menuSprite;
	
	public ArrayList<Skills> skills;
	public TreeMap<Integer, Skills> levelSkills;// = new TreeMap<>();
	public ArrayList<status> statuses;
	public ArrayList<status> statusesChecked;
	
	public Item[] items = {null,null,null,null,null};
	public int itemSlots = 4;
	public Schmuck itemDummy;	
	public String name,plural,pronoun;
	public String bioS,bioL;

	public Schmuck(String name,String plural, String pronoun,int lvl, int spriteIndex, int mspriteIndex, int[] start,
			double[] growths,int[] elem, int exp, int script, Skills[] skills, int[] lvlReqs,Item[] items, 
			double[]dropRates, status[] intrinsics, String bioS, String bioL){	
		this.battleSprite = spriteIndex;
		this.menuSprite = mspriteIndex;
		this.name=name;
		this.plural = plural;
		this.pronoun = pronoun;
		this.skills = new ArrayList<Skills>();
		this.Lvl = lvl;
		this.startStats=start;
		this.statGrowths=growths;
		this.elemPoints = elem;
		this.expDrop = exp;
		this.scrDrop = script;
		this.itemDummy = new Schmuck();
		this.bioS = bioS;
		this.bioL = bioL;
		this.levelSkills = new TreeMap<>();
		for(int i = 0; i<skills.length;i++){
			this.levelSkills.put(lvlReqs[i], skills[i]);
		}
		for(int i = 0; i<skills.length;i++){
			if(lvlReqs[i] <= lvl){
				learnSkill(skills[i]);
			}
		}
		this.itemdrops = new TreeMap<>();
		for(int i = 0; i<items.length;i++){
			this.itemdrops.put(items[i], dropRates[i]);
		}
		this.statuses = new ArrayList<status>();
		this.statusesChecked = new ArrayList<status>();
		for(status intr : intrinsics){
			statuses.add(intr);
		}
		calcStats(lvl);
	}
	
	public Schmuck(){
		this.name = "Item Dummy";
		//for itemdummy
	}
		
	public void hpChange(int hp){
		tempStats[0]+=hp;
		if(tempStats[0]<0){
			tempStats[0]=0;
			statuses.add(new incapacitate(this,this));
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
			setCurrentBp(0);
		}
		if(getCurrentBp()>getMaxBp()){
			setCurrentBp(getMaxBp());
		}
		
	}
	
	public void expGain(int xp){
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
	
	public void equip(Item i, int slot, InventoryManager meep, Game game){
		if(this.getLvl() < i.lvlReq * (1 - this.getLvlReqMod()) * 0){ //remove 0 later when you aren't testing anymore
			StateManager.states.push(new NotificationState(game, meep.getGs(), meep.getGs().getStateManager(), "Your level is too low to use this!", 0));
		}
		else{
			if(meep.backpack.containsKey(i)){
				if(slot < itemSlots){
					i.onEquip(this, slot, meep, game);
				}
			}
		}
	}
	
	public void unEquip(int slot, InventoryManager meep, Game game){
		if(items[slot] != null){
			if(slot < itemSlots){
				items[slot].onUnEquip(this, slot, meep, game);
			}
		}
	}
	
	public int statusProcTime(int procTime, BattleState bs, Action a, Schmuck schmuck, int amount, int elem, boolean won, status st){
		int finalamount = amount;
		ArrayList<status> oldChecked = new ArrayList<status>();
		for(status s : this.statusesChecked){
			this.statuses.add(0,s);
			oldChecked.add(s);
		}
		this.statusesChecked.clear();
		while(!this.statuses.isEmpty()){
			status tempStatus = this.statuses.get(0);
			if(!bs.bp.stm.checkStatus(this, new incapacitate(this,this)) || tempStatus.runWhenDead() || bs.bp.stm.checkStatus(this, new Undead(this,10))){
				if(!bs.bp.stm.checkStatus(this, new Purified(this,0))){
					switch(procTime){
					//Case 0: Start of Fight Effects
					case 0:
						tempStatus.startoffightEffect(this, bs);
						break;
					//Case 1: End of Fight Effects 
					case 1:
						tempStatus.endoffightEffect(this, won, bs);
						break;
					//Case 2: Pre-Battle Phase Effects
					case 2:
						tempStatus.preBattlePhase(this, bs);
						break;
					//Case 3: User's Pre-Action Effects
					case 3:
						tempStatus.preActionUser(this,a, bs);
						break;
					//Case 4: Target's Pre-Action Effects
					case 4:
						tempStatus.preActionTarget(this,a, bs);
						break;
					//Case 5: User's Post-Action Effects
					case 5:
						tempStatus.onActionUser(bs, a);
						break;
					//Case 6: Target's Post-Action Effects
					case 6:
						tempStatus.onActionTarget(bs, a);
						break;
					//Case 7: After any Action Effects
					case 7:
						tempStatus.endofAnyAction(bs, a, schmuck);
						break;
					//Case 8: On Crit Effects
					case 8:
						tempStatus.onCrit(this, schmuck,a, bs);
						break;
					//Case 9: On Miss Effects
					case 9:
						tempStatus.onMiss(this, a, bs);
						break;
					//Case 10: On Wait Effects
					case 10:
						tempStatus.onDillyDally(this, bs);
						break;
					//Case 11: On Standard Attack
					case 11:
						tempStatus.attackModify(this, schmuck, bs, amount);
						break;
					//Case 12: End of Round Effects
					case 12:
						tempStatus.endofturnEffect(this, bs);
						break;
					//Case 13: Deal Damage Effects
					case 13:
						finalamount = tempStatus.dealdamageEffect(this, schmuck, bs, finalamount, elem);
						break;
					//Case 14: Take Damage Effects
					case 14:
						finalamount = tempStatus.takedamageEffect(schmuck, this, bs, finalamount, elem);
						break;
					//Case 15: Giving Heal Effects
					case 15:
						finalamount= tempStatus.onHealUserEffect(this, schmuck, bs, finalamount, elem);
						break;
					//Case 16: Receiving Heal Effects
					case 16:
						finalamount= tempStatus.onHealTargetEffect(schmuck, this, bs, finalamount, elem);
						break;
					//Case 17: On Meter-Loss
					case 17: 
						finalamount = tempStatus.spendMeterEffect(this, bs, finalamount);
						break;
					//Case 18: On Meter-Gain
					case 18:
						finalamount = tempStatus.gainMeterEffect(this, bs, finalamount);
						break;
					//Case 19: On Kill
					case 19:
						tempStatus.onKill(this, schmuck, bs);
						break;
					//Case 20: On Death
					case 20:
						tempStatus.onDeath(schmuck, this, bs);
						break;
					//Case 21: On Gaining New Status
					case 21: 
						tempStatus.onStatusInflict(this, st, bs);
						break;
					//Case 22: On Completing Channel
					case 22:
						tempStatus.doneChanneling(this, bs);
						break;
					//Case 23: On Looting Script
					case 23: 
						finalamount = tempStatus.onLootScript(this, bs, finalamount);
						break;
					}
				}
			}
			if(this.statuses.contains(tempStatus)){
				this.statuses.remove(tempStatus);
				this.statusesChecked.add(tempStatus);
			}
		}
		for(status s : this.statusesChecked){
			if(!oldChecked.contains(s)){
				this.statuses.add(s);
			}
		}
		this.statusesChecked.clear();
		for(status s : oldChecked){
			this.statusesChecked.add(s);
		}
		calcBuffs(bs);
		return finalamount;
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
		
		double origAlignment = this.getElemAlignment();
		for(int i=0; i<bonusStats.length; i++){
			bonusStats[i] = 0;
		}
		
		//Sorts statuses by priority
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
		
		//Applies statuses if Schmuck does not have the Purity status
		Boolean pure = false;
		for(status st : this.statuses){
			if(st.getName()!=null){			
				if(st.getName().equals("Purified")){					
					pure = true;
				}
			}
		}
		if(!pure){
			for(status s : this.statuses){
				if(s != null){
					s.statchanges(this);
					if(bs != null){
						s.statchanges(this,bs);
					}
				}
			}
		}
		
		//Set resistances according to buffed elemental points. Also sets alignment if any one color is large enough
		this.setRedRes((this.getRedPoints()+this.getBluePoints()+this.getYellowPoints()-this.getGreenPoints()-this.getPurplePoints()));
		this.setBlueRes((-this.getRedPoints()+this.getBluePoints()+this.getYellowPoints()+this.getGreenPoints()-this.getPurplePoints()));
		this.setGreenRes((this.getRedPoints()-this.getBluePoints()-this.getYellowPoints()+this.getGreenPoints()+this.getPurplePoints()));
		this.setYellowRes((-this.getRedPoints()-this.getBluePoints()+this.getYellowPoints()+this.getGreenPoints()+this.getPurplePoints()));
		this.setPurpleRes((this.getRedPoints()+this.getBluePoints()-this.getYellowPoints()-this.getGreenPoints()+this.getPurplePoints()));
		this.setVoidRes(this.getVoidPoints());
		this.setElemAlignment(origAlignment);

		for(int i = 0 ; i< this.getBuffedElemPoints().length; i++){
			if(this.buffedElemPoints[i] > this.getPrismaticPoints()/2){
				if(this.getElemAlignment() != i+1){
					this.setElemAlignment(i+1);
					if(bs != null){
						bs.bp.bt.addScene(this.getName()+" is elementally aligned!");
					}
					i = this.getBuffedElemPoints().length;
				}
			}
		}
		if(this.getElemAlignment() != 0){
			if(this.getPrismaticPoints()/2 >= this.buffedElemPoints[(int)(this.getElemAlignment()-1)]){
				if(bs != null){
					bs.bp.bt.addScene(this.getName()+" lost "+this.getPronoun(1)+" elemental alignment!");
				}
				this.setElemAlignment(0);
			}
		}
		
		if(this.getCurrentHp()>this.getMaxHp()){
			this.setCurrentHp(this.getMaxHp());
		}
		if(this.getCurrentBp()>this.getMaxBp()){
			this.setCurrentBp(this.getMaxBp());
		}
		for(int stat = 2; stat<8; stat++){
			if(this.buffedStats[stat] == 0){
				this.buffedStats[stat] = 1;
			}
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
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public String getPlural() {
		return plural;
	}
	
//	0:pronoun	1:possessive	2:plural possessive
	public String getPronoun(int i) {
		switch(pronoun){
		case "it":
			switch(i){
			case 0:
				return "it";
			case 1:
				return "its";
			case 2:
				return "their";
			case 3:
				return "it";
			}
			break;
		case "he":
			switch(i){
			case 0:
				return "he";
			case 1:
				return "his";
			case 2:
				return "their";
			case 3:
				return "him";
			}
			break;
		case "she":
			switch(i){
			case 0:
				return "she";
			case 1:
				return "her";
			case 2:
				return "their";
			case 3:
				return "her";
			}
			break;
		}
		return "";
		
	}
	
	public String getBioShort() {
		return bioS;
	}

	public String getBioLong() {
		return bioL;
	}
	
	public BufferedImage getBattleSprite() {
		if(Assets.battleSprites != null && battleSprite < Assets.battleSprites.length && Assets.battleSprites[battleSprite] != null){
			return Assets.battleSprites[battleSprite];
		} else{
			return Assets.battleSprites[0];
		}
	}
	
	public BufferedImage getMenuSprite() {
		if(Assets.stickers != null && menuSprite < Assets.stickers.length && Assets.stickers[menuSprite] != null){	
			return Assets.stickers[menuSprite];
		} else{
			return Assets.stickers[0];
		}
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
	
	//0: None, 1: Red, 2: Blue, 3: Green, 4: Yellow, 5: Purple, 6: Void
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
	
	//0: Pow, 1: Def, 2: Spd, 3: Skl, 4: Int, 5: Luk
	public double getDamageStat() {
		return bonusStats[26];
	}

	public void setDamageStat(double stat) {
		bonusStats[26] = stat;
	}
	
	public double getLvlReqMod() {
		return bonusStats[27];
	}

	public void setLvlReqMod(double bonus) {
		bonusStats[27] = bonus;
	}
	
	public double getCritRes(){
		return bonusStats[28];
	}
	
	public void setCritRes(double bonus){
		bonusStats[28] = bonus;
	}
	
	public double getRegenBonus(){
		return bonusStats[29];
	}
	
	public void setRegenBonus(double bonus){
		bonusStats[29] = bonus;
	}
	
	public double getChargeBonus(){
		return bonusStats[30];
	}
	
	public void setChargeBonus(double bonus){
		bonusStats[30] = bonus;
	}
	
	public double getCooldownBonus(){
		return bonusStats[31];
	}
	
	public void setCooldownBonus(double bonus){
		bonusStats[31] = bonus;
	}
	
	public double getCritAvoid(){
		return bonusStats[32];
	}
	
	public void setCritAvoid(double bonus){
		bonusStats[32] = bonus;
	}
	
	public double getChannelBonus(){
		return bonusStats[33];
	}
	
	public void setChannelBonus(double bonus){
		bonusStats[33] = bonus;
	}
	
	public double getBonusHpRegen(){
		return bonusStats[34];
	}
	
	public void setBonusHpRegen(double bonus){
		bonusStats[34] = bonus;
	}
	
	public double getBonusMpRegen(){
		return bonusStats[35];
	}
	
	public void setBonusMpRegen(double bonus){
		bonusStats[35] = bonus;
	}
	
	public double getDefenseStat(){
		return bonusStats[36];
	}
	
	public void setDefenseStat(double bonus){
		bonusStats[36] = bonus;
	}
	
	public double getAttackDamage(){
		return bonusStats[37];
	}
	
	public void setAttackDamage(double bonus){
		bonusStats[37] = bonus;
	}
	
	public double getDamageReduction(){
		return bonusStats[38];
	}
	
	public void setDamageReduction(double bonus){
		bonusStats[38] = bonus;
	}
	
	public double getDiscountBonus(){
		return bonusStats[39];
	}
	
	public void setDiscountBonus(double bonus){
		bonusStats[39] = bonus;
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
	
	public boolean getDefaultLocation() {
		return defaultLocation;
	}
	
	public void setDefaultLocation(boolean defloc) {
		defaultLocation = defloc;
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

	public int getDamageTaken() {
		return damageTaken;
	}

	public void setDamageTaken(int damageTaken) {
		this.damageTaken = damageTaken;
	}

	public int getColorDamage() {
		return colorDamage;
	}

	public void setColorDamage(int colorDamage) {
		this.colorDamage = colorDamage;
	}
		
	
}
