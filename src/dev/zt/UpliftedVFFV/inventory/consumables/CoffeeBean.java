package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class CoffeeBean extends Item{

	static int id = 2;
	static String name = "Roasted Coffee Bean";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 6;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A fragrant, roasted coffee bean.";
	static String descrShort="Restore Mp.\nCaution: Hot!";
	public CoffeeBean() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene("The Coffee Bean scalds "+vic.getName()+"'s tongue!");
		bs.bp.em.hpChange((int)(-10*(1+perp.getItemPow())),perp,vic,6);
		bs.bp.em.bpChange((int)(30*(1+perp.getItemPow())),vic);

	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" pops the Coffee bean into "+vic.getPronoun(3)+" mouth.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" the Coffee Bean.";
		}
	}
	
	public void use(Schmuck s){
		s.hpChange((int)(-10*(1+s.getItemPow())));
		s.bpChange((int)(30*(1+s.getItemPow())));
	}
}
