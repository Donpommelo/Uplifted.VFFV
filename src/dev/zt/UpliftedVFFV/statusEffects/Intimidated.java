package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Intimidated extends status{
	
	public double percent;
	public static String name = "Intimidated";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Intimidated(int i, double percent, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.percent = percent;
	}
	
	public Intimidated(double percent, int pr){
		super(name, pr);
		this.percent = percent;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int temp = (int)(Math.random()*vic.getMaxHp());
		if(3*damage <= -temp){
			for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
				if(bs.bp.TurnOrderQueue.get(i)!=null){
					if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && !vic.equals(perp) && !bs.bp.TurnOrderQueue.get(0).user.equals(vic)){
						bs.bp.TurnOrderQueue.remove(i);
						bs.bp.bt.addScene(vic.getName()+" was too intimidated to move!");
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
	
	public Boolean isBad(){
		return true;
	}
}
