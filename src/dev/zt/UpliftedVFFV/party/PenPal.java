package dev.zt.UpliftedVFFV.party;


import dev.zt.UpliftedVFFV.ablities.ArcherRoulette;
import dev.zt.UpliftedVFFV.ablities.BoxCutter;
import dev.zt.UpliftedVFFV.ablities.DoubleGeneva;
import dev.zt.UpliftedVFFV.ablities.DullRose;
import dev.zt.UpliftedVFFV.ablities.FerrerBlock;
import dev.zt.UpliftedVFFV.ablities.HeresHow;
import dev.zt.UpliftedVFFV.ablities.InvertedSwan;
import dev.zt.UpliftedVFFV.ablities.PennyBlack;
import dev.zt.UpliftedVFFV.ablities.Query;
import dev.zt.UpliftedVFFV.ablities.SindhDak;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.TreskillingYellow;
import dev.zt.UpliftedVFFV.ablities.TyrianPlum;
import dev.zt.UpliftedVFFV.ablities.PennyBlue;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PenPal extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=53,startBp=28,startPow=15, startDef=17, startSpd=12, startSkl=22, startLuk=25, startInt=16;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=2.5, bpGrowth=2.9, powGrowth=1.4, defGrowth=1.3, spdGrowth=2, sklGrowth=2.1, intGrowth=2.6, lukGrowth=1.3;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop = 2000;
	public final static int scrDrop = 0;
	public final static int baseRed = 5, baseBlue = 25, baseGreen = 25, baseYellow = 5, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};

	public static String name = "Pen Pal";
	public static String plural = "Pen Pal";
	public static String pronoun = "it";
	
	public static int sprite = 1;
	public static int menusprite = 2;
	
	public static Skills[] levelSkills = {new BoxCutter(0), new Query(0), new PennyBlue(0),	new HeresHow(0),
			new TreskillingYellow(0),new TyrianPlum(0), new FerrerBlock(0), new ArcherRoulette(0), new InvertedSwan(0),
			new DullRose(0), new DoubleGeneva(0), new SindhDak(0),new PennyBlack(0)};
	public static int[] levelReqs = {0,0,1,3,9,15,19,23,29,32,36,40,45};
//	public static int[] levelReqs = {0,0,0,0,0,0,0,0,0,0};

	public final static Item[] itemDrops = {};
	public final static double[] dropRates = {};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "Your very own foreign correspondence. Looks leafy.";
	public final static String bioLong = "";


	public PenPal(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths, baseElem, expDrop, scrDrop, levelSkills,
				levelReqs,itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);

	}
}
