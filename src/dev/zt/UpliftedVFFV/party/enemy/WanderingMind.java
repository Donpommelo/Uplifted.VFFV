package dev.zt.UpliftedVFFV.party.enemy;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Coalesce;
import dev.zt.UpliftedVFFV.ablities.MentalCollapse;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.ablities.ThinkDirty;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.MentalLeakage;
import dev.zt.UpliftedVFFV.inventory.consumables.ThoughtFluid;
import dev.zt.UpliftedVFFV.inventory.equipables.GeniusMalignus;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class WanderingMind extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=98,startBp=67,startPow=29, startDef=58, startSpd=35, startSkl=39, startLuk=17, startInt=61;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=41.6, bpGrowth=44.7, powGrowth=3.7, defGrowth=4.7, spdGrowth=2.8, sklGrowth=1.9, intGrowth=3.1, lukGrowth=1.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=2;
	public final static int scrDrop=4;
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 20, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};

	public static String name = "Wandering Mind";
	public static String plural = "Wandering Minds";
	public static String pronoun = "it";
	
	public static int sprite = 14;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {};
	public static int[] levelReqs = {};
	
	public final static Item[] itemDrops = {new MentalLeakage(), new ThoughtFluid(), new GeniusMalignus()};
	public final static double[] dropRates = {.75, .50, 1};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "Malicious disembodied nervous system.";
	public final static String bioLong = "";
	
	public WanderingMind(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths, baseElem, expDrop, scrDrop, levelSkills,
				levelReqs,itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	public Action getAction(BattleState bs){
		if(bs.bp.getSelectableAllies(this).size() == 1 && (bs.bp.roundNum+4)%5 == 0){
			return new Action(this,this,new ThinkDirty(0),bs);
		}
		else{
			int random = (int)(Math.random()*1);
			Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
			if(bs.bs.alliesTargets.isEmpty()){
				return new Action(this,this,new PassTurn(0),bs);
			}
			else{
				switch (random){
				case 0:
					act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new MentalCollapse(0),bs);
					break;
				}
			}	
			return act;
		}
	}
}
