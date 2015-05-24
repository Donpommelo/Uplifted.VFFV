package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Lachiplatre extends Item{

	static String descr="A stale, bun-like object stuffed with dry paste. You assume it is edible.";
	static String descrShort="Eat it. I guess.";
	public Lachiplatre() {
		super(0, "Lachiplatre",true, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" eats the Lachiplatre.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Lachiplatre.");
		}
		bs.bp.em.hpChange(2,vic);
		bs.bp.em.bpChange(2,vic);
	}
	
	public void use(Schmuck s){
		s.hpChange(2);
		s.bpChange(2);
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
