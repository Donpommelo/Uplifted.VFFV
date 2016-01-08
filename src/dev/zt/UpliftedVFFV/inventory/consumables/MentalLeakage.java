package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MentalLeakage extends Item{

	static int id = 2;
	static String name = "Mental Leakage";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A handful of loose thoughts. You doubt it contains anything\nuseful.";
	static String descrShort="Restore Mp.";
	public MentalLeakage() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.addScene(vic.getName()+" consumes the Mental Leakage.");
		}
		else{
			bs.bp.bt.addScene(perp.getName()+" uses the Mental Leakage on "+vic.getName());
		}
		bs.bp.em.bpChange((int)(25*(1+perp.getItemPow())),vic);
		if(Math.random()<.1){
			//get some terrible side effect.
		}
	}
	
	public void use(Schmuck s){
		s.bpChange((int)(30*(1+s.getItemPow())));
	}
}
