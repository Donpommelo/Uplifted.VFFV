package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class ItemNothing extends Skills {
	
	//Used if selecting use item with an empty inventory.
	//Differs from "Flavor Nothing" in that it is target.
	
	public GameState gs;
	public static String name = "Nothing";
	public static String descr = "User throw nothing at a target.";
	public static String descrShort = "Does nothing.";
	public static int cost = 0;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public ItemNothing(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, 0, 0, false, false);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(vic.getName()+" doesn't seem impressed.");
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return 	perp.getName()+" throws nothing at "+vic.getName()+"!";
	}
		
	
}
