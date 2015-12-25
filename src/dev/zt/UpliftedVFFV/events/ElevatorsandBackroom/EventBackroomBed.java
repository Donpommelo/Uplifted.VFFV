package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.io.IOException;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.utils.Utils;

public class EventBackroomBed extends Event {

	private String[] choices = {"Sleep", "Save", "Nevermind"};			//list of choices used in the choicebranch
	private static int stagenum = 0;
	
	public EventBackroomBed(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
		super.ChoiceBranch(this.getId(), choices, 120);
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public void ChoiceMade(int choice){
		//Add one to choice to get stage (first stage is choice menu).
		switch(choice){
		case 0:
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A comfy Bed./But you don't feel like sleeping right now and probably couldn't if you tried./");
			super.Dialog(d, 0, this.getId(), true);
			break;
		case 1:
			try {
				Utils.saveState(1, gamestate, this.getId());
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.setstage(0);
			break;
		case 2:		
			this.setstage(0);		
			break;
		}
	}
}
