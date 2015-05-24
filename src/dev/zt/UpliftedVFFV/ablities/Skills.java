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
	public BufferedImage icon;
	public boolean startTeamTarget;
	public Skills(int index){
		name = "";
		descr = "";
		descrShort = "";
		cost = 0;
		icon =Assets.skill;
	}
	
	public Skills(int index, BufferedImage i){
		name = "";
		descr = "";
		descrShort = "";
		cost = 0;
		icon = i;
	}
	
	
	public void run(Schmuck user, Schmuck target, BattleState bs){

	}
	
	public String getName() {
		return "meep";
	}
	
	public String getDescr() {
		return "meep";
	}
	
	public String getDescrShort() {
		return "meep";
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return "";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "";
	}

	public int getCost() {

		return cost;
	}
	
	public boolean startTarget(){
		return false;
	}
	
	public BufferedImage getIcon(){
		return icon;
	}
	
	public void TOQChange(Action a, BattleState bs){
		
	}
	


}
