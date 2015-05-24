package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class MidgeBlood extends Item{

	static String descr="Blood from a midge could really be anybody¡¦s.";
	static String descrShort="Regenerate Hp over time.";
	public MidgeBlood() {
		super(2, "Midge Blood",true, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" drinks the Midge Blood.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Midge Blood.");
		}
		bs.bp.stm.addStatus(vic, new Regendegen(3,true,6));

	}
	
	public void use(Schmuck s){
		s.hpChange(18);
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
