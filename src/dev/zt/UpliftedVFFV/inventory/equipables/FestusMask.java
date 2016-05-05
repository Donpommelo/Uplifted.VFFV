package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.MaskofFestusStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class FestusMask extends Item{

	static int id = 42;
	static String name = "Mask of Sympathy";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 1200;
	static int slot = 1;
	static int lvlReq = 37;
	static String descr="Let your coworkers know your intentions to mourn on their behalf.";
	static String descrShort="+11 Skl and Spd\nStandard Attacks sometimes inflict Silence\nUser is Silenced.";
	public status[] enchantment = new status[3];
	public FestusMask() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatBuffAdd(5,(int)(11*(1+s.getEquipPow())),s,15);
		enchantment[1] = new StatBuffAdd(4,(int)(11*(1+s.getEquipPow())),s,15);
		enchantment[2] = new MaskofFestusStatus(s,0);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
