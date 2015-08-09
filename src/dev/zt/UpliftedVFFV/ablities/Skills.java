package dev.zt.UpliftedVFFV.ablities;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Skills implements Serializable{
	
	private static final long serialVersionUID = -3907480109509424751L;
	
	public String name;
	public String descr;
	public String descrShort;
	private int id;
	public int cost;
	public int baseAcc,baseCrit;
	public boolean canMiss,canCrit;
	
	//0: All targets
	//1: No target: automatically performs action
	//2: All targetable allies (used in reviving)
	public int targetType = 0;
	
	//0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:No Alignment
	public int element = 6;
	
	public boolean startTeamTarget;
	
	private int iconIndex;
	
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
	}
	
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
	}
	
	
	public void run(Schmuck user, Schmuck target, BattleState bs){

	}
		
	public void runCrit(Schmuck user, Schmuck target, BattleState bs){
		run(user,target,bs);
	}
	
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
	
	public int getElement(){
		return element;
	}
	
	public boolean startTarget(){
		return false;
	}
	
	public BufferedImage getIcon(){
		return Assets.skillIcons[iconIndex];
	}
	
	public void TOQChange(Action a, BattleState bs){
		
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		return 0;//-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3];
	}
	


}
