package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import java.io.IOException;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.utils.Utils;



public class EventBackroomBed1 extends Event {

	public boolean selfswitch1=false;
	
	private String[] choices = {"Sleep", "Save", "Nevermind"};			//list of choices used in the choicebranch
	private static int stage = 0;						//stage is the variable that determines which stage the event is in
//	private static int finalstage = 3;
	
	public EventBackroomBed1(float x, float y, int idnum) {
		super(Assets.Bed1,idnum,x, y);
	}
	
	public void run(){
		switch(stage){
			case 0:
				//Select options.
				super.ChoiceBranch(this.getId(), choices);
				break;
			case 1:
				//"Sleep" option.
				super.Dialog(163, 163, this.getId());
				stage = 0;
				break;
			case 2:
				//"Save" option.
				try {
					Utils.saveState(1, gamestate);
				} catch (IOException e) {
					e.printStackTrace();
				}
				stage = 0;
				break;
			case 3:
				//"Nevermind".
				stage = 0;
				break;
		}
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public void ChoiceMade(int choice){
		//Add one to choice to get stage (first stage is choice menu).
		stage = choice + 1;
		this.run();
	}
}
