package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Combustibility;

public class Antiinflammatory extends Item{

	static int id = 2;
	static String name = "Anti-Inflammatory";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 8;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A bottle of medicine for the purpose of lowering inflammation.";
	static String descrShort="Cures Combustibility.";
	public Antiinflammatory() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.removeStatus(vic, new Combustibility(1, perp, vic,50) );
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" consumes an Anti-Inflammatory!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" an Anti-Inflammatory!";
		}
	}
}
