package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class CaffeinePatch extends Item{

	static String descr="A small adhesive strip that administers your needed chemicals\ndirectly into the bloodstream.";
	static String descrShort="Restore Mp.";
	public CaffeinePatch() {
		super(2, "Caffeine Patch", true, true, true, true,descr, descrShort, 11, 0);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" uses a Caffeine Patch");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" uses a Caffeine Patch on "+vic.getName());
		}
		bs.bp.bt.textList.add(vic.getName()+" looks 15 Bp more motivated.");
		bs.bp.em.bpChange(20,vic);

	}
	
	public void use(Schmuck s){
		s.bpChange(25);
	}
}
