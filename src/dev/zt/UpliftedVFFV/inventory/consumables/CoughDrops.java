package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;

public class CoughDrops extends Item{

	static int id = 2;
	static String name = "Cough Drops";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="Voice-restoring herbal lozenges.";
	static String descrShort="Cures Silence.";
	public CoughDrops() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.removeStatus(vic, new Silenced(1, perp, 50) );
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" swallows a Cough Drop!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Cough Drop!";
		}
	}
}
