package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class SummononDeath extends status{
	
	public static String name = "Hosting";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	
	public Schmuck[] summons;
	
	public SummononDeath(int i, Schmuck perp, Schmuck vic, Schmuck[] summons, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.summons = summons;
	}
	
	public SummononDeath(Schmuck v,Schmuck[] summons,int pr){
		super(name, v,pr);
		this.summons = summons;
	}

	public void onDeath(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(vic.getName()+" summons enemies!");
		for(Schmuck s : summons){
			if(bs.bp.allies.contains(vic)){
				bs.bp.allies.add(s);
			}
			else{
				bs.bp.enemy.add(s);
			}
		}
	}
	
}
