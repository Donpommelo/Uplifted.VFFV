package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BeefedUp;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;

public class BeefUnwell extends Item{

	static int id = 2;
	static String name = "Beef Unwellington";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 35;
	static int slot = 0;
	static int lvlReq = 12;
	static String descr="A meaty, beef sandwich. There aren��t any obvious defects with\nit, but it makes you feel nauseated nonetheless.";
	static String descrShort="Buff Pow and Poison.";
	public BeefUnwell() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new BeefedUp(5, perp,30));
		bs.bp.stm.addStatus(vic, new Poisoned(5, perp,30));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" reluctantly eats the Beef Unwellington.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" the Beef Unwellington.";
		}
	}
}
