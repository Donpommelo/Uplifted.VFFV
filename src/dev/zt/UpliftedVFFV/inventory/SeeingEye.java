package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TrueSight;

public class SeeingEye extends Item{

	static String descr="Disembodied eyes have a way of always seeming terrified.";
	static String descrShort="Buffs Acc.";
	public SeeingEye() {
		super(2, "Seeing Eye", false,true, true, true,descr, descrShort,25,0);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" swallows the Seeing Eye!");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Seeing Eye.");
		}
		bs.bp.stm.addStatus(vic, new TrueSight(3, perp, 70));
	}

}
