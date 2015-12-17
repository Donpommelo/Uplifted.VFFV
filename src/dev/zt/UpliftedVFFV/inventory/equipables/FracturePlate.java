package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.FracturePlateStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class FracturePlate extends Item{

	static int id = 2;
	static String name = "Fracture Plate";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 600;
	static int slot = 1;
	static int lvlReq = 45;
	static String descr="A thick, bony plate, eternally mending its ever growing collection of cracks.";
	static String descrShort="Uses meter to reduce damage.";
	public status[] enchantment = new status[3];
	public FracturePlate() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new FracturePlateStatus(s.itemDummy, 75);
		enchantment[1] = new AddStatBuff(3, (int)(11*(1+s.getEquipPow())), s.itemDummy, 50);
		enchantment[2] = new AddStatBuff(0, (int)(55*(1+s.getEquipPow())), s.itemDummy, 50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
