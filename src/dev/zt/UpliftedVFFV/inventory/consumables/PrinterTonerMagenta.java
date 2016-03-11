package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class PrinterTonerMagenta extends Item{

	static int id = 2;
	static String name = "Magenta Printer Toner";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A cartridge of magenta powder used by laser printers. Magenta being a sub-element combination of Red and Purple, like the dizzying blaze of human ambition.";
	static String descrShort="Boosts Red and Purple Points";
	public PrinterTonerMagenta() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(5, 0, (int)(20 * (1 + perp.getItemPow())), perp,5));
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(5, 4, (int)(20 * (1 + perp.getItemPow())), perp,5));

	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" uses a Red Printer Toner on "+perp.getPronoun(3)+"self!";
		}
		else{
			return perp.getName()+" uses a Red Printer Toner on "+vic.getName()+"!";
		}
	}
}
