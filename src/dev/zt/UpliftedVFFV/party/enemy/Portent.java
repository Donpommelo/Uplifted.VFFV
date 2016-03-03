package dev.zt.UpliftedVFFV.party.enemy;


import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.ForeseeIll;
import dev.zt.UpliftedVFFV.ablities.IntrusiveThought;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.SpreadingDoubt;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.misc.GlimpseattheEnd;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.IntrusiveThoughtEffect;

public class Portent extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=80,startBp=100,startPow=35, startDef=45, startSpd=32, startSkl=49, startLuk=28, startInt=78;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=38.2, bpGrowth=34.7, powGrowth=4.3, defGrowth=3.4, spdGrowth=8.6, sklGrowth=4.5, intGrowth=10.9, lukGrowth=6.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=3;
	public final static int scrDrop=3;
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 30, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};
	
	public static String name = "Portent";
	public static String plural = "Portents";
	public static String pronoun = "it";
	
	public static int sprite = 11;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {new IntrusiveThought(0), new ForeseeIll(0)};
	public static int[] levelReqs = {0,0};
	
	public final static Item[] itemDrops = {new GlimpseattheEnd(), new GlimpseattheEnd(), new GlimpseattheEnd()};
	public final static double[] dropRates = {1, .75, .5};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "TEMP";
	public final static String bioLong = "";
	
	public Portent(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs, itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	public Action getAction(BattleState bs){
		Schmuck target = null;
		if(!bs.bs.alliesTargets.isEmpty()){
			target = bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size()));
		}
		else{
			return new Action(this,this,new PassTurn(0),bs);
		}
		int mostStacks = 0;
		for(Schmuck s : bs.bp.allies){
			if(bs.bp.stm.findStatus(s, new IntrusiveThoughtEffect(this,0)).getExtraVar1() > mostStacks){
				target = s;
				mostStacks = bs.bp.stm.findStatus(s, new IntrusiveThoughtEffect(this,0)).getExtraVar1();
			}
		}

		if(mostStacks*10>=Math.random()*100){
			return new Action(this,target,new ForeseeIll(0),bs);
		}
		else{
			return new Action(this,target,new SpreadingDoubt(0),bs);
		}

	}
}
