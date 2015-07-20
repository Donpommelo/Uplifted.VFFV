package dev.zt.UpliftedVFFV.ablities;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Skills {
	
	public String name;
	public String descr;
	public String descrShort;
	public int cost;
	
	//0: All targets
	//1: No target: automatically performs action
	//2: All targetable allies (used in reviving)
	public int targetType = 0;
	
	//0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:No Alignment
	public int element = 6;
	
	public BufferedImage icon;
	public boolean startTeamTarget;
	
	public Skills(int index, int t, int elem, String name, String descr, String descrShort, int cost){
		this.name = name;
		this.descr = descr;
		this.descrShort = descrShort;
		this.cost = cost;
		targetType = t;
		icon =Assets.skill;
		element = elem;
	}
	
	public Skills(int index, int t, int elem, String name, String descr, String descrShort, int cost, BufferedImage i){
		this.name = name;
		this.descr = descr;
		this.descrShort = descrShort;
		this.cost = cost;
		targetType = t;
		icon =i;
		element = elem;
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
	
	public int getCost() {

		return cost;
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
		return icon;
	}
	
	public void TOQChange(Action a, BattleState bs){
		
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		return 0;//-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3];
	}
	


}
