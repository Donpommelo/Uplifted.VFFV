package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Cleave extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public double cleave;
	public Cleave(int i, double amount, Schmuck perp, int pr){
		super(i, "Cleave", false, true, true, perp, pr);
		this.cleave = amount;
	}
	
	public Cleave(double amount, Schmuck perp, int pr){
		super("Cleave", true, false, perp, pr);
		this.cleave = amount;
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		bs.bp.bt.textList.add(perp.getName()+"'s attack damages all foes!");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			if(!s.equals(vic)){
				bs.bp.em.hpChange((int)(damage * cleave), perp, s,6);
			}
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" gained a cleaving attack.";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s attacks no longer cleave.";
	}
}
