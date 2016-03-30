package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;

public class Disease extends Item{
	
	static int id = 21;
	static String name = "Disease";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 3;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A handful of some ambiguous illness.";
	static String descrShort="Poisons target.";
	public Disease() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new Poisoned((int)(3*(1+perp.getItemPow())), perp, vic, 40));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" eats a Disease. For some reason.";
		}
		else{
			return perp.getName()+" transmits a Disease to "+vic.getName();
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
