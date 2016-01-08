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
	static String descr="You aren¡¦t sure what this is exactly, but you¡¦re confident it isn¡¦t beef.";
	static String descrShort="Removes beef-related\nafflictions.";
	public Unbeef() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.addScene(vic.getName()+" eats the Unbeef, and looks suitable unbeefy!");
		}
		else{
			bs.bp.bt.addScene(perp.getName()+" gives "+vic.getName()+" the Unbeef.");
		}
		bs.bp.stm.removeStatus(vic, new BeefedUp(1, perp, 30) );
	}

}
