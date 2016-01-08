package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FennelDonut extends Item{

	static int id = 2;
	static String name = "Fennel Off-Gazpacho Donut";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 5;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="Mick always had the worst taste in donuts.";
	static String descrShort="Restore Hp.";
	public FennelDonut() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.addScene(vic.getName()+" eats the nasty, nasty donut.");
		}
		else{
			bs.bp.bt.addScene(perp.getName()+" gives "+vic.getName()+" the nasty, nasty donut.");
		}
		bs.bp.em.hpChange((int)(45*(1+perp.getItemPow())),perp,vic,6);
	}
	
	public void use(Schmuck s){
		s.hpChange((int)(45*(1+s.getItemPow())));
	}
}
