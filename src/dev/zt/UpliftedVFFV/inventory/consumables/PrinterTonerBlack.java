package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class PrinterTonerBlack extends Item{

	static int id = 37;
	static String name = "Black Printer Toner";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A cartridge of black powder used by laser printers. Can make any surface remarkably absorbent of light.";
	static String descrShort="Boosts ??? Points.";
	public PrinterTonerBlack() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(5, 5, (int)(20 * (1 + perp.getItemPow())), perp,vic,5));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" uses a Black Printer Toner on "+perp.getPronoun(3)+"self!";
		}
		else{
			return perp.getName()+" uses a Black Printer Toner on "+vic.getName()+"!";
		}
	}
}
