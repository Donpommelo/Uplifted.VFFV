package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BeefedUp;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class Unbeef extends Item{

	static String descr="You aren��t sure what this is exactly, but you��re confident it isn��t beef.";
	public Unbeef() {
		super(2, "Unbeef",false, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" eats the Unbeef, and looks suitable unbeefy!");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Unbeef.");
		}
		bs.bp.stm.removeStatus(vic, new BeefedUp(1,bs) );
	}

}
