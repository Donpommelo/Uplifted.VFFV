package dev.zt.UpliftedVFFV.inventory.keyitems;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class SandwichToothPick extends Item{

	static int id = 95;
	static String name = "Sandwich Toothpick";
	static boolean menu = true;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort = "TEMP";
	public SandwichToothPick() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		//Heal self + reset sandwich variables.
	}
	
	public String getDescrShort(GameState gs) {
		
		
		
		String produce = "";
		String protein = "";
		String dairy = "";
		String bread = "";
		String condiment = "";
		
		String description = "";
		
		
		ArrayList<String> contents = new ArrayList<String>();
		
		if(gs.getVar(31) != 0){
			contents.add(produce);
		}
		if(gs.getVar(32) != 0){
			contents.add(protein);
		}
		if(gs.getVar(33) != 0){
			contents.add(dairy);
		}
		description = "A ";
		
		for(String s : contents){
			description += (s+", ");
		}
		
		if(gs.getVar(34) != 0){
			description += "sandwich on "+bread;
		}
		else{
			description += "pile";
		}
		
		if(gs.getVar(35) != 0){
			description += " with "+condiment;
		}
		
		return description;
	}
}
