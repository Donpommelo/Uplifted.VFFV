package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BaselineStats;

public class StatScrubber extends Item{

	static int id = 2;
	static String name = "Stat Scrubber";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 25;
	static int slot = 0;
	static int lvlReq = 12;
	static String descr="Basalt exfoliating device for removing\ndead skin and stat debuffs.";
	static String descrShort="Temporarily set primary stats\nto base values.";
	public StatScrubber() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(perp, new BaselineStats(3, perp, 0));
	}
	
	public int getTargetType(){
		return 1;
	}
}
