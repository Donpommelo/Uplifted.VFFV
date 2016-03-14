package dev.zt.UpliftedVFFV.ablities;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.DefaultAnim;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Skills implements Serializable{
	
	private static final long serialVersionUID = -3907480109509424751L;
	
	public String name;								//Name of a skill
	public String descr;							//Description of a skill visible in the menu
	public String descrShort;						//Abridged description visible in battle
	private int id;									//Skill id. Not used right now
	public int cost;								//Mp cost required to cast a skill
	public int baseAcc,baseCrit;					//The base percentage of a skill to hit/crit
	public boolean canMiss,canCrit;					//Whether a skill is capable of missing/critting
	
	//0: All targets
	//1: No target: automatically performs action
	//2: All targetable allies (used in reviving)
	public int targetType = 0;						//After selecting a skill, how to select targets (if any)
	
	//0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:No Alignment
	public int element = 6;							//Element alignment of a skill
	
	public boolean startTeamTarget;					//Whether the skill starts off targeting user's team
													
	private int iconIndex;							//The index of the miniicon of the skill in the Battle Menu
	
	public BattleAnimation ba;						//Animation played upon casting skill
	
	
	//Constructor for skills with no icon yet (most skills)
	public Skills(int index, int t, int elem, String name, String descr, String descrShort, int cost,int acc, int crit,
			boolean canMiss, boolean canCrit){
		this.name = name;
		this.descr = descr;
		this.descrShort = descrShort;
		this.cost = cost;
		targetType = t;
		iconIndex = 1;
		element = elem;
		this.baseAcc = acc;
		this.baseCrit = crit;
		this.canMiss = canMiss;
		this.canCrit = canCrit;
		this.ba = new DefaultAnim();
	}
	
	//Constructor for skills with icon but no animation yet
	public Skills(int index, int t, int elem, String name, String descr, String descrShort, int cost, int icon, int acc, int crit,
			boolean canMiss, boolean canCrit){
		this.name = name;
		this.descr = descr;
		this.descrShort = descrShort;
		this.cost = cost;
		targetType = t;
		iconIndex = icon;
		element = elem;
		this.baseAcc = acc;
		this.baseCrit = crit;
		this.canMiss = canMiss;
		this.canCrit = canCrit;
		this.ba = new DefaultAnim();
	}
	
	//Constructor for skill with icon and animation.
	//Move everything to here eventually
	public Skills(int index, int t, int elem, String name, String descr, String descrShort, int cost, int icon, int acc, int crit,
			boolean canMiss, boolean canCrit, BattleAnimation ba){
		this.name = name;
		this.descr = descr;
		this.descrShort = descrShort;
		this.cost = cost;
		targetType = t;
		iconIndex = icon;
		element = elem;
		this.baseAcc = acc;
		this.baseCrit = crit;
		this.canMiss = canMiss;
		this.canCrit = canCrit;
		this.ba = ba;
	}
	
	//This method is run whenever a skill is used.
	//Individual skills always override this.
	public void run(Schmuck user, Schmuck target, BattleState bs){

	}
	
	//This method is run whenever a critical skill is used.
	//If a skill can crit, it should override this.
	public void runCrit(Schmuck user, Schmuck target, BattleState bs){
		run(user,target,bs);
	}
	
	//Returns whether a skill is blocked by the Silence status.
	//Most skills are.
	//notable omissions: Attacking, Waiting, using an Item, Running.
	public boolean silenceBlocked(){
		return true;
	}
	
	//The text displayed when a skill is used.
	//Played right before the skill is actually casted in the Battle Processor.
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return "";
	}
	
	//If this skill starts of targeting your own team, this function returns true.
	public boolean startTarget(){
		return false;
	}
	
	//This is run after moves are selected, but before they are executed.
	//This includes any skills that modify the Turn Order Queue such as taking initiative
	//I guess you could put other stuff here too as well if you feel like it.
	public void TOQChange(Action a, BattleState bs){
		
	}
	
	//Not used right now.
	//I plan to use later for enemy AI stuff. Until then, ignore.
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		return 0;

	}
	
	//Getters and Setters for skill variables.
	
	public String getName() {
		return name;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getID(){
		return id;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getBaseAcc(){
		return baseAcc;
	}
	
	public int getBaseCrit(){
		return baseCrit;
	}
	
	public boolean canMiss(){
		return canMiss;
	}
	
	public boolean canCrit(){
		return canCrit;
	}
	
	public int getTargetType(){
		return targetType;
	}
	
	public int getElement(Schmuck s){
		return element;
	}
	
	public BufferedImage getIcon(){
		return Assets.skillIcons[iconIndex];
	}

	public BattleAnimation getBa() {
		return ba;
	}
	
}
