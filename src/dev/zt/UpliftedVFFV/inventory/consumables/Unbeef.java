package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BeefedUp;

public class Unbeef extends Item{

	static int id = 2;
	static String name = "Unbeef";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 30;
	static int slot = 0;
	static int lvlReq = 12;
	static String descr="You aren't sure what this is exactly, but you¡¦re confident it\nisn't beef.";
	static String descrShort="Removes beef-related afflictions.";
	public Unbeef() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.removeStatus(vic, new BeefedUp(1, perp, 30) );
	}

	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" eats an Unbeef, and looks suitable unbeefy!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" an Unbeef.";
		}
	}
	
}
