package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class CelestialAnnointment extends Item{

	static int id = 2;
	static String name = "Celestial Anointment";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 500;
	static int slot = 1;
	static int lvlReq = 5;
	static String descr="TEMP";
	static String descrShort="+25% Int\n+50 Yellow Points\nCannot be unequipped";
	public status[] enchantment = new status[2];
	public CelestialAnnointment() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatBuffMult(6,1.25*(1+s.getEquipPow()), 30);
		enchantment[1] = new ElemPointsBuff(3, 50, 50);
		return enchantment;
	}
		
	public void unEnchantment(Schmuck s, int slot, InventoryManager meep, Game game) {
		StateManager.states.push(new NotificationState(game, meep.getGs(), meep.getGs().getStateManager(), "The Celestial Annointment is never washing off.", 0));
		s.equip(this, slot, meep, game);
	}
	
	public boolean isLegendary(){
		return true;
	}
}
