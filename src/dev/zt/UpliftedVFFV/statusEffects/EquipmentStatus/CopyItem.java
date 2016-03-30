package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import java.util.ArrayList;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

// Limited-use Equipment statuses (Ring of Gyges)

public class CopyItem extends status{
	
	public ArrayList<status> copiedStatuses = new ArrayList<status>();
	public CopyItem(Schmuck v,int pr){
		super("Imitation Item", v,pr);
	}
	
		public void startoffightEffect(Schmuck s, BattleState bs){//
			if(s.items[0] != null){
				bs.bp.bt.addScene(s.getName()+"'s Blatant Fake copies "+s.getPronoun(1) +" "+ s.items[0].getName()+"!");
				for(status st : s.items[0].getEnchantment(s)){
					if(st.getName() != "Imitation Item" && st != null)
					{
						s.statuses.add(st);
						copiedStatuses.add(st);
					}
				}
				s.calcBuffs(bs);
			}
		}
		
		public void endoffightEffect(Schmuck s, Boolean won, BattleState bs){
			bs.bp.bt.addScene(s.getName()+"'s Blatant Fake reverts back to its original form.");
			for(status st : copiedStatuses){
				s.statuses.remove(st);
				s.statusesChecked.remove(st);
			}
			copiedStatuses.clear();			
		}
		
		public Boolean runWhenDead(){
			return true;
		}
}
