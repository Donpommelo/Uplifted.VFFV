package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.MetalRations;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FireMagnum extends Skills {

	public static String name = "Fire Magnum";
	public static String descr = "Remember that gun you had?\nWell, you can shoot someone with it.\nC'mon, go ahead! Try it!\nYou'll need bullets though.";
	public static String descrShort = "Shoot someone\nUses up Metal Rations.";
	public static int cost = 0;
	public FireMagnum(int index) {
		super(index,0,6, name, descr, descrShort, cost);
		
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		if(bs.gs.inventorymanager.backpack.containsKey(new MetalRations())){
			bs.bp.bt.textList.add(perp.getName()+" fired a Magnum at "+vic.getName()+"!");
			int hitChance = (int)(Math.random()*100);
			if(hitChance<bs.bp.em.getAcc(perp, vic)){
				bs.bp.em.hpChange((int)(-45*(1+perp.getEquipPow())),perp,vic);
			}
			else{
				bs.bp.bt.textList.add(perp.getName()+" missed!");
			}
			bs.gs.inventorymanager.use(new MetalRations());
			bs.bp.bt.textList.add(bs.gs.inventorymanager.backpack.get(new MetalRations())+" Metal Rations left!");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" is out of ammunition!");
		}		
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		if(bs.gs.inventorymanager.backpack.containsKey(new MetalRations())){
			bs.bp.bt.textList.add(perp.getName()+" fired a Magnum at "+vic.getName()+"!");
			bs.bp.em.hpChange((int)(-45*(1+perp.getEquipPow())*(1+perp.getCritMulti())*(1+perp.getCritMulti())),perp,vic);
			bs.gs.inventorymanager.use(new MetalRations());
			bs.bp.bt.textList.add(bs.gs.inventorymanager.backpack.get(new MetalRations())+" Metal Rations left!");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" is out of ammunition!");
		}	
	}	

}
