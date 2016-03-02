package dev.zt.UpliftedVFFV.party.enemy;


import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.BlightBite;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Pounce;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.equipables.RatTail;
import dev.zt.UpliftedVFFV.inventory.misc.Disease;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class IllRat extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=61,startBp=21,startPow=40, startDef=45, startSpd=75, startSkl=50, startLuk=21, startInt=28;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=38, bpGrowth=22.7, powGrowth=3.2, defGrowth=2.3, spdGrowth=4.7, sklGrowth=2.5, intGrowth=2.9, lukGrowth=1.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=4;
	public final static int scrDrop=5;
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};

	public static String name = "Ill Rat";
	public static String plural = "Ill Rats";
	public static String pronoun = "it";
	
	public static int sprite = 5;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {new Pounce(0), new BlightBite(0)};
	public static int[] levelReqs = {0,0};
	
	public final static Item[] itemDrops = {new Disease(), new RatTail()};
	public final static double[] dropRates = {.8, .4};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "Filthy bringer of plague. Thrive due to lack of natural predators.";
	public final static String bioLong = "";
	
	public IllRat(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs, itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);	
	}
	
	public Action getAction(BattleState bs){
		int random = (int)(Math.random()*3);
		Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
		if(bs.bs.alliesTargets.isEmpty()){
			return new Action(this,this,new PassTurn(0),bs);
		}
		else{
			switch (random){
			case 0:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Pounce(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
				break;
			case 2:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new BlightBite(0),bs);
				break;
			}
		}
		
		return act;
	}
}
