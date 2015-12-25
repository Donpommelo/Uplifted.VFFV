package dev.zt.UpliftedVFFV.party.enemy;


import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.ForeseeIll;
import dev.zt.UpliftedVFFV.ablities.IntrusiveThought;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Augur extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=50,startBp=30,startPow=10, startDef=10, startSpd=11, startSkl=1, startLuk=12, startInt=17;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=2.2, bpGrowth=1.7, powGrowth=1.3, defGrowth=1.4, spdGrowth=1, sklGrowth=1.5, intGrowth=1.9, lukGrowth=3.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=8;
	public final static int scrDrop=3;
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 30, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};
	
	public static String name = "Augur";
	public static String plural = "Augurs";
	public static String pronoun = "it";
	
	public static int sprite = 3;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {new IntrusiveThought(0), new ForeseeIll(0)};
	public static int[] levelReqs = {0,0};
	
	public final static Item[] itemDrops = {};
	public final static double[] dropRates = {};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "Spectral bringer of bad news. Infects foes with insidious negativity.";
	public final static String bioLong = "";
	
	public Augur(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs, itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	public Action getAction(BattleState bs){
//		return new Action(this,bs.bp.allies.get((int)(Math.random()*bs.bp.allies.size())),new StandardAttack(0),bs);
		Schmuck target = null;
		if(!bs.bs.alliesTargets.isEmpty()){
			target = bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size()));
		}
		else{
			return new Action(this,this,new PassTurn(0),bs);
		}
		int mostStacks = 0;
		for(Schmuck s : bs.bp.allies){
			for(status st : s.statuses){
				if(st.getName().equals("Intrusive Thoughts")){
					if(st.stack>mostStacks){
						target = s;
					}
				}					
			}
		}
		int stacked = -1;
		for(status s : target.statuses){
			if(s.getName().equals("Intrusive Thoughts")){
				stacked = target.statuses.indexOf(s);
			}					
		}
		if(stacked != -1){
			if(target.statuses.get(stacked).stack*15>=Math.random()*100){
				return new Action(this,target,new ForeseeIll(0),bs);
			}
			else{
				return new Action(this,target,new IntrusiveThought(0),bs);
			}
		}
		else{
			
			return new Action(this,target,new IntrusiveThought(0),bs);
		}

	}
}
