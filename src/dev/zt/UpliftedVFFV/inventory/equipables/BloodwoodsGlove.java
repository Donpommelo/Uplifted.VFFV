package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.BloodwoodsGloveStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class BloodwoodsGlove extends Item{

	static int id = 2;
	static String name = "Bloodwood's Glove";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 555;
	static int slot = 1;
	static int lvlReq = 36;
	static String descr="Dr. Bloodwood didn¡¦t just hate getting his hands dirty.\nHe hated getting his gloves dirty too.";
	static String descrShort = "+13 Skl and Int.\nPainfully cures negative statuses.";
	public status[] enchantment = new status[3];
	public BloodwoodsGlove() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BloodwoodsGloveStatus(80);
		enchantment[1] = new AddStatBuff(5,(int)(13*(1+s.getEquipPow())), 25);
		enchantment[2] = new AddStatBuff(6,(int)(13*(1+s.getEquipPow())), 25);
		return enchantment;
	}

	public boolean isLegendary(){
		return true;
	}
}
