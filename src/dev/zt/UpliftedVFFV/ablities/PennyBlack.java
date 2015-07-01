package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.PennyBlackStatus;

public class PennyBlack extends Skills {

	public String name = "Penny Black";
	public String descr = "User grants a target a\nBlack-aligned shield that\nsucks away the souls of\nenemies.";
	public String descrShort = "Grants Void-bonus damage.";
	public int cost = 28;
	public PennyBlack(int index) {
		super(index);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Penny Black!");
		bs.bp.stm.addStatus(vic, new PennyBlackStatus(3, perp));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Penny Black!");
		bs.bp.bt.textList.add("A Critical buff!");
		bs.bp.stm.addStatus(vic, new PennyBlackStatus((int)(3*perp.getCritMulti()), perp));	
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
