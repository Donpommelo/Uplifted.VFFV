package dev.zt.UpliftedVFFV.statusEffects;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class CatoNeedStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public CatoNeedStatus(int i, Schmuck perp){
		super(i, "Needs Met", false, false, true, perp);
	}
	
	public CatoNeedStatus(Schmuck perp, int pr){
		super("Needs Met", false, false, perp,pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int overkill = vic.getCurrentHp() + damage;
		if(overkill <= 0){
			if(vic.getCurrentBp() >= -(overkill*2+5)){
				bs.bp.bt.textList.add(vic.getName()+"'s Catalogue of Need restores vital processes!");
				bs.bp.em.bpChange((overkill*2-5), vic);
				return -vic.getCurrentHp()+1;
			}
			else{
				return damage;
			}
		}
		else{
			return damage;
		}
	}
	
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks needy!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" looks normal again.";
	}
	
	public int getDuration(){
		return duration;
	}

}
