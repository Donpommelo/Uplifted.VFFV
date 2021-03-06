package dev.zt.UpliftedVFFV.party.enemy;


import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.BlindingLight;
import dev.zt.UpliftedVFFV.ablities.CreateCopy;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.PrinterTonerBlack;
import dev.zt.UpliftedVFFV.inventory.consumables.PrinterTonerCyan;
import dev.zt.UpliftedVFFV.inventory.consumables.PrinterTonerMagenta;
import dev.zt.UpliftedVFFV.inventory.consumables.PrinterTonerYellow;
import dev.zt.UpliftedVFFV.inventory.equipables.CannonElectrostatic;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CopyCat extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=60,startBp=40,startPow=50, startDef=47, startSpd=29, startSkl=34, startLuk=70, startInt=53;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=40.3, bpGrowth=21.7, powGrowth=3.7, defGrowth=3.9, spdGrowth=3.4, sklGrowth=2.5, intGrowth=3.1, lukGrowth=8.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=15;
	public final static int scrDrop=25;
	
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};
	
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();

	public static String name = "Copy-Cat";
	public static String plural = "Copy-Cats";
	public static String pronoun = "it";
	
	public static int sprite = 18;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {};
	public static int[] levelReqs = {};
	
	public final static Item[] itemDrops = {new PrinterTonerCyan(), new PrinterTonerMagenta(),new PrinterTonerYellow(),
			new PrinterTonerBlack(), new CannonElectrostatic()};
	public final static double[] dropRates = {.6, .6, .6, .1, .1};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "TEMP";
	public final static String bioLong = "";
	
	public CopyCat(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs, itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	
	public Action getAction(BattleState bs){
		int random = (int)(Math.random()*5);
		Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
		if(bs.bs.alliesTargets.isEmpty()){
			return new Action(this,this,new PassTurn(0),bs);
		}
		else{
			switch (random){
			case 0:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new BlindingLight(0),bs);
				break;
			case 2:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new CreateCopy(0),bs);
				break;
			case 3:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new CreateCopy(0),bs);
				break;
			case 4:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new CreateCopy(0),bs);
				break;
			}
		}	
		return act;
	}
}
