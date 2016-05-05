package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class BelugaBubblegum extends Item{

	static int id = 93;
	static String name = "Beluga Bubblegum";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 55;
	static int slot = 0;
	static int lvlReq = 12;
	static String descr="A packet of Beluga brand Bubblegum.\nContains no actual beluga.";
	static String descrShort="Restores Mp to user.\nReduces Underwater Penalty";
	public BelugaBubblegum() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.bpChange((int)(16*(1+perp.getItemPow())*(1+vic.getRegenBonus())),vic);
		bs.bp.stm.addStatus(vic, new BonusStatBuff(5, 5, (int)(.50 * (1 + perp.getItemPow())), perp,vic,5));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" chews some Beluga Bubblegum!";
	}
	
	public int getTargetType(){
		return 1;
	}
}
