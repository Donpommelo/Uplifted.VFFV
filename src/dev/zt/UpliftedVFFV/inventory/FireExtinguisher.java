package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Ablaze;

public class FireExtinguisher extends Item{

	static String descr="A tank of flame-retardant chemicals.";
	static String descrShort="Cures Ablaze.";
	public FireExtinguisher() {
		super(2, "Fire Extinguisher",false, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" sprays the Fire Extinguisher at "+vic.getName());
		bs.bp.stm.removeStatus(vic, new Ablaze(1, perp) );
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	
	

}
