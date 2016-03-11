package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;

public class Antivenom extends Item{

	static int id = 2;
	static String name = "Antivenom";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 8;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A bottle of medicine designed to flush your body of poison.";
	static String descrShort="Cures Poison.";
	public Antivenom() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.removeStatus(vic, new Poisoned(1, perp, 50) );
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" consumes an Antivenom!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" an Antivenom!";
		}
	}
}
