package dev.zt.UpliftedVFFV.inventory.consummables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class CaffeinePatch extends Item{

	static int id = 2;
	static String name = "Caffeine Patch";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 11;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A small adhesive strip that administers your needed chemicals\ndirectly into the bloodstream.";
	static String descrShort="Restore Mp.";
	public CaffeinePatch() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

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