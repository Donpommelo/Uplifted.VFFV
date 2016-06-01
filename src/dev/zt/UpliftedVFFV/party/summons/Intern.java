package dev.zt.UpliftedVFFV.party.summons;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.ablities.ChemicalStimulation;
import dev.zt.UpliftedVFFV.ablities.Ennervate;
import dev.zt.UpliftedVFFV.ablities.HeresHow;
import dev.zt.UpliftedVFFV.ablities.MentalCollapse;
import dev.zt.UpliftedVFFV.ablities.Oversight;
import dev.zt.UpliftedVFFV.ablities.Reorganize;
import dev.zt.UpliftedVFFV.ablities.Skills;


public class Intern extends Schmuck{
	
//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=100,startBp=69,startPow=45, startDef=52, startSpd=43, startSkl=42, startInt=53, startLuk=38;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=30.1, bpGrowth=19.7, powGrowth=5.2, defGrowth=3.3, spdGrowth=3.7, sklGrowth=3.1, intGrowth=3.1, lukGrowth=2.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	
	public final static int expDrop = 2000;
	public final static int scrDrop = 0;
	
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 20, baseVoid = 3;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};
	
	public final static String name = "Intern";
	public final static String plural = "Interns";
	public final static String pronoun = "he";
	
	public final static int sprite = 0;
	public final static int menusprite = 1;
	
	public final static Skills[] levelSkills = {new Ennervate(0),new ChemicalStimulation(0), new MentalCollapse(0),new Reorganize(0), new Oversight(0), new HeresHow(0)};
	public final static int[] levelReqs = {0,0,1,5,8,13};
	
	public final static Item[] itemDrops = {};
	public final static double[] dropRates = {};
	public final static status[] intrinsicStatuses = {};

	public final static String bioShort = "TEMP";
	public final static String bioLong = "";
	
	public Intern(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs,itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
}
