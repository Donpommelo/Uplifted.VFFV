package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class SmellingSalt extends Item{

	static int id = 2;
	static String name = "Smellingsalt";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 35;
	static int slot = 0;
	static int lvlReq = 5;
	static String descr="A package of chemicals used in reviving overworked or\ndead coworkers.";
	static String descrShort="Revives target.";
	public SmellingSalt() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" administers the Smellingsalt to "+vic.getName());
		bs.bp.stm.removeStatus(vic, new incapacitate(vic) );
		bs.bs.targetUpdate();
		bs.bp.em.hpChange(5, perp, vic,6);
	}
	
	public void use(Schmuck s){
		s.hpChange(5);
		for(int i=0; i<s.statuses.size(); i++){
			if(s.statuses.get(i).getName()!=null){
				if(s.statuses.get(i).getName().equals("incapacitated")){
					s.statuses.remove(i);
					i--;
				}
			}
		}
		
	}
	
	public int getTargetType(){
		return 2;
	}

}
