package dev.zt.UpliftedVFFV.inventory.consumables;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Combustibility;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Bettergent extends Item{

	static int id = 2;
	static String name = "Bettergent";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A bottle of better-than-average detergent.";
	static String descrShort="Cures most negative\nstatuses";
	public Bettergent() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		ArrayList<status> removed = new ArrayList<status>();
		for(status st : vic.statuses){
			if(!st.perm && st.isBad()){
				removed.add(st);
			}
		}
		for(status st : removed){
			bs.bp.stm.removeStatus(vic, st);
		}
	}
}
