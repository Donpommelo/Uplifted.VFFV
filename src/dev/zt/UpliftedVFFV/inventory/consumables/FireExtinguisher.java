package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Combustibility;

public class FireExtinguisher extends Item{

	static int id = 2;
	static String name = "Fire Extinguisher";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A tank of flame-retardant chemicals.";
	static String descrShort="Cures Combustability.";
	public FireExtinguisher() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.removeStatus(vic, new Combustibility(1, perp, 50) );
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" sprays "+vic.getPronoun(3)+"self with a Fire Extinguisher!";
		}
		else{
			return perp.getName()+" sprays "+vic.getName()+" with a Fire Extinguisher!";
		}
	}
}
