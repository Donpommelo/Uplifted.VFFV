package dev.zt.UpliftedVFFV.party.enemy;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Censor;
import dev.zt.UpliftedVFFV.ablities.Enrage;
import dev.zt.UpliftedVFFV.ablities.Entropy;
import dev.zt.UpliftedVFFV.ablities.FoulFortunes;
import dev.zt.UpliftedVFFV.ablities.Hypochondria;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Plague;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.equipables.CurseCoat;
import dev.zt.UpliftedVFFV.inventory.equipables.VoodooPin;
import dev.zt.UpliftedVFFV.inventory.misc.BagofCurses;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Shirley extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	public final static int startHp=44,startBp=65,startPow=35, startDef=51, startSpd=16, startSkl=59, startLuk=20, startInt=66;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=29.4, bpGrowth=44.7, powGrowth= 1.7, defGrowth= 3.8, spdGrowth=4.9, sklGrowth=1.8, intGrowth=6.7, lukGrowth=2.5;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=3;
	public final static int scrDrop=1;
	
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 20, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};

	public static String name = "Shirley";
	public static String plural = "Shirlies";
	public static String pronoun = "her";
	
	public static int sprite = 13;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {};
	public static int[] levelReqs = {};
	
	public final static Item[] itemDrops = {new BagofCurses(), new CurseCoat(), new VoodooPin()};
	public final static double[] dropRates = {.5, .15 , .05};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "TEMP";
	public final static String bioLong = "";
	
	public Shirley(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths, baseElem, expDrop, scrDrop, levelSkills,
				levelReqs,itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	public Action getAction(BattleState bs){
		int random = (int)(Math.random()*6);
		Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
		if(bs.bs.alliesTargets.isEmpty()){
			return new Action(this,this,new PassTurn(0),bs);
		}
		else{
			switch (random){
			case 0:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Entropy(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Enrage(0),bs);
				break;
			case 2:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new FoulFortunes(0),bs);
				break;
			case 3:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Censor(0),bs);
				break;
			case 4:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Plague(0),bs);
				break;
			case 5:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Hypochondria(0),bs);
				break;
			}
		}	
		return act;	
	}
}
