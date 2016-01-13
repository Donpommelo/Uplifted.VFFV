package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.Game;

public class EventSelfSwitchManager {

	public Game game;
	public int[] events = new int[1200];

	
	public EventSelfSwitchManager(Game g){
		this.game = g;
		for(int i = 0; i < events.length; i++){
			events[i] = 0;
		}
	}

	public void resetSelfSwitches(Event e){
		e.setSelfswitch1(false);
		e.setSelfswitch2(false);
		e.setSelfswitch3(false);
		e.setSelfswitch4(false);
	}
	
	public void setSelfSwitches(Event e){
		int binswitch = events[e.getId()];
		if(binswitch>=8){
			binswitch-=8;
			e.selfswitch4=true;
		}
		if(binswitch>=4){
			binswitch-=4;
			e.selfswitch3=true;
		}
		if(binswitch>=2){
			binswitch-=2;
			e.selfswitch2=true;
		}
		if(binswitch>=1){
			binswitch-=1;
			e.selfswitch1=true;
		}
	}
	
	public int getVar(int i){
		return events[i];
	}
	
	public void setVar(int i, int set){
		events[i] = set;
	}
}
