package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MedPak extends Item{

	static String descr="A container of useful medicines. The Infirmary distributes these to\nother floors to avoid having to actually see any of your faces.";
	static String descrShort="Restore Hp.";
	public MedPak() {
		super(1, "Med-Pak",true, true, true, true,descr, descrShort, 10,0);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" uses the Med-Pak.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" uses the Med-Pak on "+vic.getName());
		}
		bs.bp.em.hpChange((int)(20*(1+perp.getItemPow())),perp, vic,6);
	}
	
	public void use(Schmuck s){
		s.hpChange((int)(20*(1+s.getItemPow())));
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}

}
