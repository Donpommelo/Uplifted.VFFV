package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BeefedUp;

public class AngryBeef extends Item{

	static String descr="A hunk of angry, angry beef.";
	static String descrShort="Enrage and buff Pow.";
	public AngryBeef() {
		super(2, "Angry Beef", false, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" angrily chews on the Angry Beef!");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Angry Beef.");
		}
		bs.bp.stm.addStatus(vic, new BeefedUp(5, perp));
	}
	
	public String getDescrShort() {
		return descrShort;
	}
		

}
