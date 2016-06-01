package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Frozen;

public class ColdMedicine extends Item{

	static int id = 57;
	static String name = "Cold Medicine";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 8;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A bottle of medicine for the purpose of curing all manner of cold-related ailments including"
			+ " being encased in blocks of cold ice.";
	static String descrShort="Cures Freeze.";
	public ColdMedicine() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.removeStatus(vic, new Frozen(1, perp, vic,50) );
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" consumes Cold Medicine!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" Cold Medicine!";
		}
	}
}
