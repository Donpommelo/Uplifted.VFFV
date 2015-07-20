package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Intimidated extends status{
	
	public int duration;
	public double percent;
	public Boolean perm = false;
	public Boolean visible = true;
	public Intimidated(int i, double percent, Schmuck perp, int pr){
		super(i, "Intimidated", false, false, true, perp, pr);
		this.percent = percent;
	}
	
	public Intimidated(double percent, Schmuck perp, int pr){
		super("Intimidated", false, false, perp, pr);
		this.percent = percent;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int temp = (int)(Math.random()*vic.getMaxHp());
		if(5*damage <= -temp){
			for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
				if(bs.bp.TurnOrderQueue.get(i)!=null){
					if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && !vic.equals(perp) && !bs.bp.TurnOrderQueue.get(0).user.equals(vic)){
						bs.bp.TurnOrderQueue.remove(i);
						bs.bp.bt.textList.add(vic.getName()+" was too intimidated to move!");
						i--;
					}
				}
				
			}
		}
		return damage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" was intimidated!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" doesn't look intimidated any more.";
	}
}
