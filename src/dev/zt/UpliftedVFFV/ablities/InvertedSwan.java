package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.InvertedSwanEffect;
import dev.zt.UpliftedVFFV.statusEffects.PennyBlueStatus;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class InvertedSwan extends Skills {

	public String name = "Inverted Swan";
	public String descr = "User infuses a target\nthe grace of an upside-\nswan, granting a double\n-attack.";
	public String descrShort = "Gives a Double-Attack.\nThe second hit is Blue\naligned.";
	public int cost = 14;
	public InvertedSwan(int index) {
		super(index);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Inverted Swan!");
		bs.bp.stm.addStatus(vic, new InvertedSwanEffect(1));
	}

	
	public String getName(){
		return name;
	}
	
	public String getDescr(){
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}
	
	public boolean startTarget(){
		return true;
	}

}
