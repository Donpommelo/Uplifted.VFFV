package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Ablaze;

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
	static String descrShort="Cures Ablaze.";
	public FireExtinguisher() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" sprays the Fire Extinguisher at "+vic.getName());
		bs.bp.stm.removeStatus(vic, new Ablaze(1, perp, 50) );
	}
}
