package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;



import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Untouchable;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class RingofGygesStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int damage = 0;
	public Boolean used;	
	public RingofGygesStatus(Schmuck perp, int pr){
		super("Defensive Invisibility", false, false, perp,pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		used = false;
	}
			
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(!used){
			if(vic.getCurrentHp()-damage <= .1*vic.getMaxHp()){
				bs.bp.bt.textList.add(vic.getName()+"'s Ring of Gyges grants Invisibility!");
				bs.bp.stm.addStatus(vic, new Untouchable(2, vic.getItemDummy(), 50));
			}
			used = true;
		}		
		return damage;
	}
}
