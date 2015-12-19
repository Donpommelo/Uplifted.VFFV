package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FalseFace extends Item{

	static int id = 2;
	static String name = "False Face";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 500;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="";
	static String descrShort="Reduces Level Requirements by 60%";
	public status[] enchantment = new status[1];
	public FalseFace() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(27,.30*(1+s.getEquipPow()), 0);
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s, InventoryManager meep) {
		for(int i = 0; i< s.items.length; i++){
			if(s.items[i] != null){
				if(s.items[i].getLvlReq() > s.getLvl()){
					s.items[i].unEnchantment(s, meep);
					meep.loot(s.items[i],1);
					s.items[i] = null;
					for(int j=0; j < s.statuses.size(); j++){
						if(s.statuses.get(j) != null){
							if(s.statuses.get(j).perp.equals(s.itemDummy)){
								s.statuses.remove(j);
								j--;
							}
						}					
					}
					s.calcBuffs(null);
				}
			}
			
		}
	}
	
	public boolean isLegendary(){
		return true;
	}
}
