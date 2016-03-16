package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Combustibility;
import dev.zt.UpliftedVFFV.statusEffects.Asleep;
import dev.zt.UpliftedVFFV.statusEffects.Frozen;
import dev.zt.UpliftedVFFV.statusEffects.Paralysis;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DeathCapStatus extends status{
	
	public DeathCapStatus(int pr){
		super("Elementally Reactive Spores", pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(-damage > vic.getMaxHp()/5){
			switch(elem){
			case 0:
				bs.bp.bt.addScene(vic.getName()+"'s Death Cap releases Red Spores!");
				for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
					if(Math.random() < .6*vic.getBuffedLuk()/s.getBuffedLuk()){
						bs.bp.stm.addStatus(s, new Combustibility((int)(3*(1+vic.getEquipPow())), vic, s,50));
					}
				}
				break;
			case 1:
				bs.bp.bt.addScene(vic.getName()+"'s Death Cap releases Blue Spores!");
				for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
					if(Math.random() < .6*vic.getBuffedLuk()/s.getBuffedLuk()){
						bs.bp.stm.addStatus(s, new Frozen((int)(3*(1+vic.getEquipPow())), vic,s, 50));
					}
				}
				break;
			case 2:
				bs.bp.bt.addScene(vic.getName()+"'s Death Cap releases Green Spores!");
				for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
					if(Math.random() < .6*vic.getBuffedLuk()/s.getBuffedLuk()){
						bs.bp.stm.addStatus(s, new Poisoned((int)(4*(1+vic.getEquipPow())), vic,s, 50));
					}
				}
				break;
			case 3:
				bs.bp.bt.addScene(vic.getName()+"'s Death Cap releases Yellow Spores!");
				for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
					if(Math.random() < .6*vic.getBuffedLuk()/s.getBuffedLuk()){
						bs.bp.stm.addStatus(s, new Paralysis((int)(4*(1+vic.getEquipPow())), vic,s, 50));
					}
				}
				break;
			case 4:
				bs.bp.bt.addScene(vic.getName()+"'s Death Cap releases Purple Spores!");
				for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
					if(Math.random() < .6*vic.getBuffedLuk()/s.getBuffedLuk()){
						bs.bp.stm.addStatus(s, new Asleep((int)(4*(1+vic.getEquipPow())), vic,s, 50));
					}
				}
				break;
			}
		}
		return damage;
	}	
}
