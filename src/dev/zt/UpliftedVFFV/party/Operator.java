package dev.zt.UpliftedVFFV.party;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.ablities.CentriDischarge;
import dev.zt.UpliftedVFFV.ablities.CounterWeight;
import dev.zt.UpliftedVFFV.ablities.CrushCables;
import dev.zt.UpliftedVFFV.ablities.DamnedDescent;
import dev.zt.UpliftedVFFV.ablities.DayattheFair;
import dev.zt.UpliftedVFFV.ablities.DoorsofClosure;
import dev.zt.UpliftedVFFV.ablities.FiremansSwitch;
import dev.zt.UpliftedVFFV.ablities.MotorGrinder;
import dev.zt.UpliftedVFFV.ablities.SafeRoom;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.Terraform;
import dev.zt.UpliftedVFFV.ablities.TowerofTerror;
import dev.zt.UpliftedVFFV.ablities.VariableVoltage;

public class Operator extends Schmuck{
	
//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=129,startBp=33,startPow=55, startDef=58, startSpd=45, startSkl=45, startInt=38, startLuk=35;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=33.5, bpGrowth=11.7, powGrowth=4.8, defGrowth=3.7, spdGrowth=3.7, sklGrowth=3.8, intGrowth=2.9, lukGrowth=1.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	
	public final static int expDrop = 2000;
	public final static int scrDrop = 0;
	
	public final static int baseRed = 25, baseBlue = 5, baseGreen = 5, baseYellow = 25, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};
	
	public final static String name = "Operator";
	public final static String plural = "Operators";
	public final static String pronoun = "he";
	
	public final static int sprite = 0;
	public final static int menusprite = 1;
	
	public final static Skills[] levelSkills = {new DoorsofClosure(0), new MotorGrinder(0), new CrushCables(0),
			new CentriDischarge(0), new SafeRoom(0), new FiremansSwitch(0), new VariableVoltage(0),
			new CounterWeight(0), new DamnedDescent(0), new TowerofTerror(0), new Terraform(0),new DayattheFair(0)};
	public final static int[] levelReqs = {0,0,2,3,5,7,12,15,18,21,25,30};
//	public final static int[] levelReqs = {0,0,0,0,0,0,0,0,0,0,0,0};
	
	public final static Item[] itemDrops = {};
	public final static double[] dropRates = {};
	public final static status[] intrinsicStatuses = {};

	public final static String bioShort = "The building's dependable and friendly elevator Operator.";
	public final static String bioLong = "";
	
	public Operator(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs,itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
}
