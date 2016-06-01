package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class DogginDaveHotDog extends Item{

	static int id = 95;
	static String name = "Doggin' Dave's Hot Dog";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 55;
	static int slot = 0;
	static int lvlReq = 12;
	static String descr="Like most hot-dogs, Doggin' Dave's signature dish is composed of a mysterious meat mixture that appeals to the incurious customer. Popular amongst the employee body due to their proclivity for asking no questions.";
	static String descrShort="Restores Hp and Mp to user.\nGives 3 random buffs.";
	public DogginDaveHotDog() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.bpChange((int)(40*(1+perp.getItemPow())*(1+vic.getRegenBonus())),vic);
		bs.bp.em.hpChange((int)(60*(1+perp.getItemPow())*(1+vic.getRegenBonus())),perp,vic,6);
		Schmuck s = perp;
		for(int i = 0; i < 3; i++){
			int rand = (int)(Math.random()*34);
			switch(rand){
			case 0:
				bs.bp.stm.addStatus(s, new StatBuffMult(20,0,1.1,s,s,50));
				break;
			case 1:
				bs.bp.stm.addStatus(s, new StatBuffMult(20,1,1.1,s,s,50));
				break;
			case 2:
				bs.bp.stm.addStatus(s, new StatBuffMult(20,2,1.1,s,s,50));
				break;
			case 3:
				bs.bp.stm.addStatus(s, new StatBuffMult(20,3,1.1,s,s,50));
				break;
			case 4:
				bs.bp.stm.addStatus(s, new StatBuffMult(20,4,1.1,s,s,50));
				break;
			case 5:
				bs.bp.stm.addStatus(s, new StatBuffMult(20,5,1.1,s,s,50));
				break;
			case 6:
				bs.bp.stm.addStatus(s, new StatBuffMult(20,6,1.1,s,s,50));
				break;
			case 7:
				bs.bp.stm.addStatus(s, new StatBuffMult(20,7,1.1,s,s,50));
				break;
			case 8:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,0,0.1,s,s,50));
				break;
			case 9:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,1,0.1,s,s,50));
				break;
			case 10:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,2,0.1,s,s,50));
				break;
			case 11:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,3,0.1,s,s,50));
				break;
			case 12:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,4,0.1,s,s,50));
				break;
			case 13:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,9,0.1,s,s,50));
				break;
			case 14:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,10,0.1,s,s,50));
				break;
			case 15:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,11,0.1,s,s,50));
				break;
			case 16:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,13,0.1,s,s,50));
				break;
			case 17:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,14,0.1,s,s,50));
				break;
			case 18:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,15,0.1,s,s,50));
				break;
			case 19:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,16,0.1,s,s,50));
				break;
			case 20:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,17,0.1,s,s,50));
				break;
			case 21:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,18,0.1,s,s,50));
				break;
			case 22:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,19,0.1,s,s,50));
				break;
			case 23:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,20,0.1,s,s,50));
				break;
			case 24:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,21,0.1,s,s,50));
				break;
			case 25:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,22,0.1,s,s,50));
				break;
			case 26:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,23,0.1,s,s,50));
				break;
			case 27:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,24,0.1,s,s,50));
				break;
			case 28:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,25,0.1,s,s,50));
				break;
			case 29:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,28,0.1,s,s,50));
				break;
			case 30:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,29,0.1,s,s,50));
				break;
			case 31:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,32,0.1,s,s,50));
				break;
			case 32:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,34,5,s,s,50));
				break;
			case 33:
				bs.bp.stm.addStatus(s, new BonusStatBuff(20,35,5,s,s,50));
				break;
			}
		}
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" eats a Doggin' Dave Hot Dog!";
	}
	
	public int getTargetType(){
		return 1;
	}
}
