package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.HealBlock;

public class FiskSalt extends Item{
	
	static int id = 95;
	static String name = "Salt Fisk";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A fish-shaped chunk of sea-salt with a smaller fish-shaped hole. Apparently, an actual fish used to fill that hole until time and bacteria thouroughly at it away.";
	static String descrShort="Prevents target from healing.";
	public FiskSalt() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new HealBlock(3, perp, vic, 50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" eats a Salt Fisk!";
		}
		else{
			return perp.getName()+" throws a Salt Fisk at "+vic.getName();
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
