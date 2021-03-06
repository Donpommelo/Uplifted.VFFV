package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.MponCrit;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.ExplosiveCrit;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class HolyWaterSprinkler extends Item{

	static int id = 42;
	static String name = "Holy Water Sprinkler";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 150;
	static int slot = 1;
	static int lvlReq = 34;
	static String descr="A flail used by ancient holy warriors to maintain peresonal hygeine admist the field of war.";
	static String descrShort="+11% Crit Chance\n+5 Blue Points\nRestore Mp on Crits.";
	public status[] enchantment = new status[3];
	public HolyWaterSprinkler() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new MponCrit(.25,s, 50);
		enchantment[1] = new ElemPointsBuff(1,5, s,55);
		enchantment[2] = new BonusStatBuff(16,.12, s,55);
		return enchantment;
	}
}
