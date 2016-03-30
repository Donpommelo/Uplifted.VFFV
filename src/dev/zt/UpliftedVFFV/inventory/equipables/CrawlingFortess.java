package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CrawlingFortressStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class CrawlingFortess extends Item{

	static int id = 2;
	static String name = "Crawling Fortess";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 27;
	static String descr="A hulking metal suit complete with several fixtures where cannons can be mounted. More closely resembles a fort for the dimunitive than a suit.";
	static String descrShort="User is Silenced\nUser is Disarmed\n-50% Pow\nYour 'Cannons' do not Cooldown.";
	public status[] enchantment = new status[2];
	public CrawlingFortess() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CrawlingFortressStatus(s,20);
		enchantment[1] = new StatBuffMult(2, .5, s,20);

		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
