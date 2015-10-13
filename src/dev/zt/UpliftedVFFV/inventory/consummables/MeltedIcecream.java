package dev.zt.UpliftedVFFV.inventory.consummables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MeltedIcecream extends Item{

	static int id = 2;
	static String name = "Melted Ice Cream";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 18;
	static int slot = 0;
	static int lvlReq = 2;
	static String descr="A bottle of lukewarm cream soda.";
	static String descrShort="Restore Hp.";
	public MeltedIcecream() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" drinks the Melted Icecream.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Melted Icecream.");
		}
		bs.bp.em.hpChange((int)(.5*(vic.getMaxHp()-vic.getCurrentHp())),perp,vic,6);
	}
	
	public void use(Schmuck s){
		s.hpChange((int)(.5*(s.getMaxHp()-s.getCurrentHp())));
	}
}
