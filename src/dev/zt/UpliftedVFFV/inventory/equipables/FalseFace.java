package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FalseFace extends Item{

	static int id = 83;
	static String name = "False Face";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 500;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="Lets you wear the face of someone who knew what he was doing.";
	static String descrShort="Reduces Level Requirements by 60%";
	public status[] enchantment = new status[1];
	public FalseFace() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(27,.30*(1+s.getEquipPow()), s,0);
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s, int slot, InventoryManager meep, Game game) {
		for(int i = 0; i< s.items.length; i++){
			if(s.items[i] != null){
				if(s.items[i].getLvlReq() > s.getLvl()){
					s.items[i].onUnEquip(s, slot, meep, game);
				}
			}
		}
	}
	
	public boolean isLegendary(){
		return true;
	}
}
