package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.HiveRhythmBuffStatus;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.HiveRhythmItemAStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class HiveRhythmA extends Item{

	static int id = 42;
	static String name = "Hive Rhythm: A";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 666;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="An enthusiastic and inflaming note, echoing endlessly in the head if its wielder.";
	static String descrShort = "+10 Red Points\nMakes you one with the Hive";
	public status[] enchantment = new status[3];
	public HiveRhythmA() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new ElemPointsBuff(0,10,s, 55);
		enchantment[1] = new HiveRhythmBuffStatus(s,50);
		enchantment[2] = new HiveRhythmItemAStatus(s,50, enchantment[1]);
		return enchantment;
	}
	
	public void onEquip(Schmuck s, int slot, InventoryManager meep, Game game) {
		int aff = 0;
		for(status st :s.statuses){
			if(st.getName()!=null){			
				if(st.getName().equals("One with the Hive")){					
					aff++;
				}
			}
		}
		if(aff > 0){
			StateManager.states.push(new NotificationState(game, meep.getGs(), meep.getGs().getStateManager(), "You cannot focus on two Hive Rhythms at once.", 0));
		}
		else{
			super.onEquip(s, slot, meep, game);
		}
	}
}
