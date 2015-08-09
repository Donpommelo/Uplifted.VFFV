package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class CarrotJuice extends Item{
	
	static String descr="A can of fizzy, orange liquid. It can serve as a nutritious substitute to\nsoda, if you didn¡¦t really want to drink a soda to begin with.";
	static String descrShort="Buff Acc and restore Mp.";
	public CarrotJuice() {
		super(2, "Carbonated Carrot Juice", false, true, true, true, descr, descrShort, 20, 0);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" drinks the Carbonated Carrot Juice.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Carbonated Carrot Juice.");
		}
		bs.bp.em.bpChange((int)(15*(1+perp.getItemPow())),vic);
		bs.bp.bt.textList.add(vic.getName()+"'s vision improved.");
		bs.bp.stm.addStatus(vic, new BonusStatBuff(5,0,.25, perp,75));
	}

}
