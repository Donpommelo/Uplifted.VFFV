package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class ItemNothing extends Skills {
	
	public Item thing;
	public GameState gs;
	public static String name = "Nothing";
	public static String descr = "User throw nothing at a target.";
	public static String descrShort = "Does nothing.";
	public static int cost = 0;
	public ItemNothing(int index) {
		super(index, 0, 6, name, descr, descrShort, cost, 0, 0, false, false);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" throws nothing at "+vic.getName()+".");
		bs.bp.bt.textList.add(vic.getName()+" doesn't seem impressed.");
	}
}
