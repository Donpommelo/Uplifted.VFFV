package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class MeltedIcecream extends Item{

	static String descr="A bottle of lukewarm cream soda.";
	public MeltedIcecream() {
		super(2, "Melted Ice Cream",true, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" drinks the Melted Icecream.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Melted Icecream.");
		}
		bs.bp.em.hpChange((int)(.5*(vic.getMaxHp()-vic.getCurrentHp())),vic);
	}
	
	public void use(Schmuck s){
		s.hpChange((int)(.5*(s.getMaxHp()-s.getCurrentHp())));
	}

}
