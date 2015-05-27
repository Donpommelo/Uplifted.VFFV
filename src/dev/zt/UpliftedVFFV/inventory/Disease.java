package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;

public class Disease extends Item{
	
	static String descr="A handful of some ambiguous illness.";
	static String descrShort="Poisons target.";
	public Disease() {
		super(2, "Disease",false, true, true, true, false,descr);

	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return perp.getName()+" throws the Disease at "+vic.getName();
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return vic.getName()+" contracts an illness.";
	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(perp.getName()+" eats the Disease at "+vic.getName());
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" throws the Disease at "+vic.getName());
		}
		bs.bp.stm.addStatus(vic, new Regendegen(4,true,-6));
	}
	
	public boolean startTeamTarget(){
		return false;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
}