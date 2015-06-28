package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MedPak extends Item{

	static String descr="A container of useful medicines. The Infirmary distributes these to\nother floors to avoid having to actually see any of your faces.";
	static String descrShort="Restore Hp.";
	public MedPak() {
		super(1, "Med-Pak",true, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" uses the Med-Pak.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" uses the Med-Pak on "+vic.getName());
		}
		bs.bp.em.hpChange(20,perp, vic);
	}
	
	public void use(Schmuck s){
		s.hpChange(20);
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
