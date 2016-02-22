package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class PrinterTonerCyan extends Item{

	static int id = 2;
	static String name = "Cyan Printer Toner";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Boosts Blue Points";
	public PrinterTonerCyan() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(5, 1, (int)(20 * (1 + perp.getItemPow())), perp,5));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" uses the Cyan Printer Toner on "+perp.getPronoun(3)+"self!";
		}
		else{
			return perp.getName()+" uses the Cyan Printer Toner on "+vic.getName()+"!";
		}
	}
}
