package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CopyItem;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class HnHFake extends Item{

	static int id = 2;
	static String name = "Half-n-Half's Fake";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 3700;
	static int slot = 1;
	static int lvlReq = 42;
	static String descr="Whatever this is trying to be, it isn’t doing a very good job.";
	static String descrShort="-25% Max Hp\nReplicates item in Slot 1 at start of fights.";
	public status[] enchantment = new status[2];
	public HnHFake() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CopyItem(0);
		enchantment[1] = new StatBuffMult(0,.75,80);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
