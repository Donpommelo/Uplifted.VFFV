package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.inventory.equipables.EnvenomEarth;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Envenomed extends status{
	
	public double percent;
	public EnvenomEarth e;
	public Envenomed(double percent, EnvenomEarth e, int pr){
		super("Envenomed", pr);
		this.percent = percent;
		this.e = e;
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+" was poisoned by Envenomed Earth!");
		bs.bp.stm.addStatus(s, new Poisoned(4, s.itemDummy, 50));
	}
	
	public void endoffightEffect(Schmuck s, BattleState bs){
		if(e.getPoints() <201){
			e.setPoints(e.getPoints()+1);
			s.calcBuffs(bs);
		}
	}
	
	public void statchanges(Schmuck s){
		s.bonusStats[19]+=(int)(e.getPoints()/10)*(1+s.getEquipPow());
		s.bonusStats[20]+=(int)(e.getPoints()/10)*(1+s.getEquipPow());
		s.bonusStats[21]+=(int)(e.getPoints()/10)*(1+s.getEquipPow());
		s.bonusStats[22]+=(int)(e.getPoints()/10)*(1+s.getEquipPow());
		s.bonusStats[23]+=(int)(e.getPoints()/10)*(1+s.getEquipPow());

	}
}
