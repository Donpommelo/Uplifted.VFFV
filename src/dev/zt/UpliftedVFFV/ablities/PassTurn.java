package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PassTurn extends Skills {
	
public Item thing;


	public static String name = "Pass Turn";
	public static String descr = "User contemplates life.";
	public static String descrShort = "Skips turn.";
	public static int cost = 0;
	public PassTurn(int index) {
		super(index, 0, 6, name, descr, descrShort, cost, Assets.nothing);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" does absolutely nothing.");
	}
	
}
