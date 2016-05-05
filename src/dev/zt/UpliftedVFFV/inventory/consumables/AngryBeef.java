package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BeefedUp;
import dev.zt.UpliftedVFFV.statusEffects.Berzerk;

public class AngryBeef extends Item{

	static int id = 42;
	static String name = "Angry Beef";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 25;
	static int slot = 0;
	static int lvlReq = 12;
	static String descr="A hunk of angry, angry beef.";
	static String descrShort="Inflict Berserk on user.\nBuffs user's Pow.";
	public AngryBeef() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(perp, new BeefedUp(5, perp, perp, 30));
		bs.bp.stm.addStatus(perp, new Berzerk(5, perp, perp, 30));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" angrily chews on an Angry Beef!";
	}
	
	public int getTargetType(){
		return 1;
	}
}
