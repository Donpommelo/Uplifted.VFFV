package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;


import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventBackroomBed extends Event {

	private String[] choices = {"Sleep", "Save", "Nevermind"};			//list of choices used in the choicebranch
	private static int stagenum = 0;
	
	public EventBackroomBed(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
		Dialog[] d = new Dialog[1];
		d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A made bed./");
		super.Dialog(d, 0, this.getId(), true);
		super.ChoiceBranch(this.getId(), choices, 200);
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public void ChoiceMade(int choice){
		//Add one to choice to get stage (first stage is choice menu).
		switch(choice){
		case 0:
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Its a comfy bed. But you don't feel like sleeping right now and probably couldn't if you tried.");
			super.Dialog(d, 0, this.getId(), true);
			break;
		case 1:
			super.Save(this.getId());

			this.setstage(0);
			break;
		case 2:		
			this.setstage(0);		
			break;
		}
	}
}
