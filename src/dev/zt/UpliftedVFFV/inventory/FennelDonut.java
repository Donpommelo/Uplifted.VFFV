package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FennelDonut extends Item{

	static String descr="Mick always had the worst taste in donuts.";
	static String descrShort="Restore Hp.";
	public FennelDonut() {
		super(2, "Fennel Off-Gazpacho Donut", true,true,true, true, false,descr, descrShort);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" eats the donut.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the nasty, nasty donut.");
		}
		bs.bp.em.hpChange((int)(20*(1+perp.getItemPow())),perp,vic);
	}
	
	public void use(Schmuck s){
		s.hpChange((int)(30*(1+s.getItemPow())));
	}
}
