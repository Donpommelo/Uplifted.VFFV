package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.inventory.consumables.Antiinflammatory;
import dev.zt.UpliftedVFFV.inventory.consumables.Antivenom;
import dev.zt.UpliftedVFFV.inventory.consumables.ColdMedicine;
import dev.zt.UpliftedVFFV.inventory.consumables.CoughDrops;
import dev.zt.UpliftedVFFV.inventory.consumables.MuscleRelaxant;
import dev.zt.UpliftedVFFV.inventory.consumables.Stimulant;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DailyDoseStatus extends status{
	
	public DailyDoseStatus(Schmuck v,int pr){
		super("Prescribed", v,pr);
	}
	
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(st.getName() == "Sleep" && bs.gs.inventorymanager.backpack.containsKey(new Stimulant())){
			bs.bp.bt.addScene(s.getName()+"'s Daily Dose automatically uses Stimulant!");
			bs.bp.stm.removeStatus(s, st);
			bs.gs.inventorymanager.use(new Stimulant());
		}
		if(st.getName() == "Combustibility" && bs.gs.inventorymanager.backpack.containsKey(new Antiinflammatory())){
			bs.bp.bt.addScene(s.getName()+"'s Daily Dose automatically uses Anti-Inflammatory!");
			bs.bp.stm.removeStatus(s, st);
			bs.gs.inventorymanager.use(new Antiinflammatory());
		}
		if(st.getName() == "Freeze" && bs.gs.inventorymanager.backpack.containsKey(new ColdMedicine())){
			bs.bp.bt.addScene(s.getName()+"'s Daily Dose automatically uses Cold Medicine!");
			bs.bp.stm.removeStatus(s, st);
			bs.gs.inventorymanager.use(new ColdMedicine());
		}
		if(st.getName() == "Poison" && bs.gs.inventorymanager.backpack.containsKey(new Antivenom())){
			bs.bp.bt.addScene(s.getName()+"'s Daily Dose automatically uses Antivenom!");
			bs.bp.stm.removeStatus(s, st);
			bs.gs.inventorymanager.use(new Antivenom());
		}
		if(st.getName() == "Paralysis" && bs.gs.inventorymanager.backpack.containsKey(new MuscleRelaxant())){
			bs.bp.bt.addScene(s.getName()+"'s Daily Dose automatically uses Muscle Relaxant!");
			bs.bp.stm.removeStatus(s, st);
			bs.gs.inventorymanager.use(new MuscleRelaxant());
		}
		
		if(st.getName() == "Silence" && bs.gs.inventorymanager.backpack.containsKey(new CoughDrops())){
			bs.bp.bt.addScene(s.getName()+"'s Daily Dose automatically uses Cough Drops!");
			bs.bp.stm.removeStatus(s, st);
			bs.gs.inventorymanager.use(new CoughDrops());
		}
	}
}
