package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.FracturePlateStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class FracturePlate extends Item{

	static int id = 42;
	static String name = "Fracture Plate";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 600;
	static int slot = 1;
	static int lvlReq = 45;
	static String descr="A thick, bony plate, eternally mending its ever growing collection of cracks.";
	static String descrShort="+55 Hp.\n+11 Def\nBlocks the first instance of damage in a fight.";
	public status[] enchantment = new status[3];
	public FracturePlate() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new FracturePlateStatus(s,75);
		enchantment[1] = new StatBuffAdd(3, 11,s, 55);
		enchantment[2] = new StatBuffAdd(0, 55,s, 55);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
