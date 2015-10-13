package dev.zt.UpliftedVFFV.inventory.consummables;

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
	static int value = 20;
	static int slot = 0;
	static int lvlReq = 2;
	static String descr="A can of fizzy, orange liquid. It can serve as a nutritious substitute to\nsoda, if you didn¡¦t really want to drink a soda to begin with.";
	static String descrShort="Buff Acc and restore Mp.";
	public CarrotJuice() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" drinks the Carbonated Carrot Juice.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Carbonated Carrot Juice.");
		}
		bs.bp.em.bpChange((int)(15*(1+perp.getItemPow())),vic);
		bs.bp.bt.textList.add(vic.getName()+"'s vision improved.");
		bs.bp.stm.addStatus(vic, new BonusStatBuff(5,0,.25, perp,75));
	}

}
