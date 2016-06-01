package dev.zt.UpliftedVFFV.party.enemy;


import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Coalesce;
import dev.zt.UpliftedVFFV.ablities.Fixation;
import dev.zt.UpliftedVFFV.ablities.LockOn;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Reorganize;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.ablities.Transform;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.SeeingEye;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class FortressMindspace extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=201,startBp=50,startPow=23, startDef=80, startSpd=35, startSkl=36, startLuk=53, startInt=85;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=28.3, bpGrowth=16.7, powGrowth=3.5, defGrowth=4.9, spdGrowth=2.1, sklGrowth=1.4, intGrowth=4.1, lukGrowth=2.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=10;
	public final static int scrDrop=15;
	
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 25, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};
	
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();

	public static String name = "Fortress Mindspace";
	public static String plural = "Fortress Mindspaces";
	public static String pronoun = "it";
	
	public static int sprite = 30;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {};
	public static int[] levelReqs = {0};
	
	public final static Item[] itemDrops = {new SeeingEye(), new SeeingEye()};
	public final static double[] dropRates = {1.0, .5};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "TEMP";
	public final static String bioLong = "";
	
	public FortressMindspace(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs, itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	
	public Action getAction(BattleState bs){
		int random = (int)(Math.random()*2);
		Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
		if(bs.bs.alliesTargets.isEmpty()){
			return new Action(this,this,new PassTurn(0),bs);
		}
		else{
			if(bs.bp.roundNum == 3){
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Transform(0,new MindspaceOverseer(this.getLvl())),bs);
			}
			else{
				switch (random){
				case 0:
					act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Coalesce(0),bs);
					break;
				case 1:
					act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Reorganize(0),bs);
					break;
				}
			}
		}	
		return act;
	}
}
