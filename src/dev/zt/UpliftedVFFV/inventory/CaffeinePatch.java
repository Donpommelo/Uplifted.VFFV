package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class CaffeinePatch extends Item{

	static String descr="A small adhesive strip that administers your needed chemicals\ndirectly into the bloodstream.";
	public CaffeinePatch() {
		super(2, "Caffeine Patch", true, true, true, true, false, descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" uses a Caffeine Patch");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" uses a Caffeine Patch on "+vic.getName());
		}
		bs.bp.bt.textList.add(vic.getName()+" looks 15 Bp more motivated.");
		bs.bp.em.bpChange(15,vic);

	}
	
	public void use(Schmuck s){
		s.bpChange(20);
	}
}
