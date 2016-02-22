package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;



import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Untouchable;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class RingofGygesStatus extends status{
	
	public int uses;	
	public RingofGygesStatus(int pr){
		super("Defensive Invisibility", pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		uses = (int)(1 + s.getChargeBonus());
	}
			
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(uses > 0 ){
			if(vic.getCurrentHp() + damage <= .1*vic.getMaxHp()){
				bs.bp.bt.addScene(vic.getName()+"'s Ring of Gyges grants Invisibility!");
				bs.bp.stm.addStatus(vic, new Untouchable(2, vic, 50));
				uses--;
			}
		}		
		return damage;
	}
}
