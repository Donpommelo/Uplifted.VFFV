package dev.zt.UpliftedVFFV.party.enemy;


import java.util.ArrayList;
import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.ForeseeIll;
import dev.zt.UpliftedVFFV.ablities.IntrusiveThought;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Augur extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=100,startBp=50,startPow=12, startDef=20, startSpd=16, startSkl=8, startLuk=10, startInt=5;
	public final static int[] startStats = {50,30,10,10,11,11,12,17};
	public final static double hpGrowth=1, bpGrowth=1, powGrowth=1, defGrowth=1, spdGrowth=1, sklGrowth=1, intGrowth=1, lukGrowth=1;
	public final static double[] statGrowths = {2.2 , 1.7 , 1.3 , 1.4 , 1 , 1.5 , 1.9 , 3.9};
	public final static int expDrop=8;
	public final static int scrDrop=3;
	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static int[] elemRes = {10,10,10,10,10,0};
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public static String name = "Augur";
	public static String plural = "Augurs";
	public static String pronoun = "it";
	public Augur(int lvl) {
//		super("Jorge",100,50, 12, 20, 17, 8, 10, 5,ImageLoader.loadImage("/CharacterBusts/3rdSouthOffices-5.png"));
		super(name, plural, pronoun, lvl, 3, startStats, statGrowths,elemRes, expDrop, scrDrop);
		calcStats(lvl);
		this.bio = "Spectral bringer of bad news. Infects foes with insidious negativity.";
		
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
