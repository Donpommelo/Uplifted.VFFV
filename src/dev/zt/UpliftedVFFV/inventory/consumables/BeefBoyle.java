package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BeefedUp;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;

public class BeefBoyle extends Item{
	
	
	static int id = 2;
	static String name = "Beef Boyleston";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static String descr="A thick, stew filled with beef as well as several ingredients that are less likely to be beef.";
	static String descrShort="Inflict Silence on user.\nBuffs user's Pow.";
	static int value = 25;
	static int slot = 0;
	static int lvlReq = 12;
	
	public BeefBoyle() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(perp, new BeefedUp(5, perp, 30));
		bs.bp.stm.addStatus(perp, new Silenced(5, perp, 30));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
			return perp.getName()+" chokes down a Beef Boyleston!";

	}
	
	public int getTargetType(){
		return 1;
	}
	
}
