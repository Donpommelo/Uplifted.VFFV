package dev.zt.UpliftedVFFV.inventory.consummables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Lachiplatre extends Item{

	static int id = 2;
	static String name = "Lachiplatre";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 0;
	static int slot = 0;
	static int lvlReq = -1;
	static String descr="A stale, bun-like object stuffed with dry paste. You assume it is edible.";
	static String descrShort="Eat it. I guess.";
	public Lachiplatre() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" eats the Lachiplatre.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Lachiplatre.");
		}
		bs.bp.em.hpChange(2, perp, vic,6);
		bs.bp.em.bpChange(2,vic);
	}
	
	public void use(Schmuck s){
		s.hpChange(2);
		s.bpChange(2);
	}
}