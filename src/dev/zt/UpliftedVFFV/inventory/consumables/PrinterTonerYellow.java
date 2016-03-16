package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class PrinterTonerYellow extends Item{

	static int id = 2;
	static String name = "Yellow Printer Toner";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A cartridge of yellow powder used by laser printers. Yellow, apparently being the only element good enough to be a primary color by itself.";
	static String descrShort="Boosts Yellow Points";
	public PrinterTonerYellow() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(5, 3, (int)(20 * (1 + perp.getItemPow())), perp,vic,5));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" uses a Yellow Printer Toner on "+perp.getPronoun(3)+"self!";
		}
		else{
			return perp.getName()+" uses a Yellow Printer Toner on "+vic.getName()+"!";
		}
	}
}
