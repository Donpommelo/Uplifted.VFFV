package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class CarrotJuice extends Item{
	
	static int id = 2;
	static String name = "Carbonated Carrot Juice";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 7;
	static int slot = 0;
	static int lvlReq = 2;
	static String descr="A can of fizzy, orange liquid. It can serve as a nutritious\nsubstitute to soda, if you didn't really want to drink a soda to begin with.";
	static String descrShort="Buff Acc and restore Mp.";
	public CarrotJuice() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.bpChange((int)(25*(1+perp.getItemPow())*(1+vic.getRegenBonus())),vic);
		bs.bp.stm.addStatus(vic, new BonusStatBuff(5,0,.25, perp,75));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" drinks a Carbonated Carrot Juice.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Carbonated Carrot Juice.";
		}
	}
	
}
