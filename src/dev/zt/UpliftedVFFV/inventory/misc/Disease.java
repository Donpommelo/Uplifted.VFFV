package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class Disease extends Item{
	
	static int id = 2;
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
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.addScene(perp.getName()+" eats the Disease. Why?");
		}
		else{
			bs.bp.bt.addScene(perp.getName()+" throws the Disease at "+vic.getName());
		}
		bs.bp.stm.addStatus(vic, new Poisoned((int)(3*(1+perp.getItemPow())), perp, 40));
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
