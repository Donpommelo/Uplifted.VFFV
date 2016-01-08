package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class CoffeedIce extends Item{

	static int id = 2;
	static String name = "Coffee'd Ice";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 22;
	static int slot = 0;
	static int lvlReq = 2;
	static String descr="A thermos of shaved ice with some faint coffee flavoring.";
	static String descrShort="Restore Hp and Mp.";
	public CoffeedIce() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.addScene(vic.getName()+" drinks the Coffee'd Ice.");
		}
		else{
			bs.bp.bt.addScene(perp.getName()+" gives "+vic.getName()+" Coffee'd Ice.");
		}
//		bs.bp.stm.removeStatus(vic, );
		bs.bp.em.hpChange((int)(15*(1+perp.getItemPow())),perp, vic,6);
		bs.bp.em.bpChange((int)(25*(1+perp.getItemPow())),vic);
	}
	
	public void use(Schmuck s){
		s.hpChange((int)(25*(1+s.getItemPow())));
		s.bpChange((int)(35*(1+s.getItemPow())));
	}

}
