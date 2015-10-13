package dev.zt.UpliftedVFFV.inventory.consummables;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MedPak extends Item{

	static int id = 2;
	static String name = "Med-Pak";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 10;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A container of useful medicines. The Infirmary distributes these to\nother floors to avoid having to actually see any of your faces.";
	static String descrShort="Restore Hp.";
	public MedPak() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

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
