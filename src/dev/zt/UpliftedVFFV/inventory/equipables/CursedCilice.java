package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Masochist;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class CursedCilice extends Item{

	static int id = 2;
	static String name = "Cursed Cilice";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 15;
	static String descr="A band lined with thorns on the inside.";
	static String descrShort="Regains meter when taking damage.";
	public status[] enchantment = new status[2];
	public CursedCilice() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Masochist(.40*(1+s.getEquipPow()), 25);
		enchantment[1] = new AddStatBuff(1,(int)(15*(1+s.getEquipPow())), 20);
		return enchantment;
	}
}