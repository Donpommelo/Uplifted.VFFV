package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BeefedUp;

public class BeefUnwell extends Item{

	static String descr="A meaty, beef sandwich. There aren¡¦t any obvious defects with\nit, but it makes you feel nauseated nonetheless.";
	static String descrShort="Buff Pow and Poison.";
	public BeefUnwell() {
		super(2, "Beef Unwellington", false, true, true, true, false,descr);

	}
	
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" reluctantly eats the Beef Unwellington.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Beef Unwellington.");
		}
		bs.bp.stm.addStatus(vic, new BeefedUp(5));
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
