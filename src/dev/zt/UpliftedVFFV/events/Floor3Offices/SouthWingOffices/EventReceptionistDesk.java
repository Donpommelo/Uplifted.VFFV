package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventReceptionistDesk extends Event {

	public static int stagenum = 0;
	public EventReceptionistDesk(float x, float y, int idnum) {
		super(Assets.Table8,idnum,x, y, 0);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[5];
			d[0] = new Dialog("Receptionist","/CharacterBusts/3rdSouthOffices-3.png",1,"Welcome to the South Wing Offices. What can I help you with?/");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hello. Could you help me find Suite 521?/");
			d[2] = new Dialog("Receptionist","/CharacterBusts/3rdSouthOffices-3.png",1,"Gee, that's awfully specific. I normally just help with more general stuff like/Where am I?/");
			d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Oh. Thanks anyways./");
			d[4] = new Dialog("Receptionist","/CharacterBusts/3rdSouthOffices-3.png",1,"No problem. You should go see George in the mailroom if you still remember your/question. I know I don't./");
			super.Dialog(d, 4, this.getId(), true);
			this.setSelfswitch1(true);
			super.setQuest(1, 2);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Receptionist","/CharacterBusts/3rdSouthOffices-3.png",1,"Welcome to the South Wing Offices.//Wait, did I already say that to you?/");
			super.Dialog(d, 0, this.getId(), true);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
