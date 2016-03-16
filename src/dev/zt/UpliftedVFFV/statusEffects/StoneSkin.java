package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class StoneSkin extends status{
	
	public static String name = "Stone Skin";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public double percent;
	public StoneSkin(int i, double percent, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.percent = percent;
	}
	
	public StoneSkin(double percent, int pr){
		super(name, pr);
		this.percent = percent;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(damage*percent/5 <= -1){
			bs.bp.stm.addStatus(vic, new BonusStatBuff(5,34,-damage*percent/5,vic,vic,50));
		}
		return damage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+"'s skin is stony!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s skin is no longer stonyy.";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
