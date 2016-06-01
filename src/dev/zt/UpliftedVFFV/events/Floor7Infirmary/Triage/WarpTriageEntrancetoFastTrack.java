package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Triage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpTriageEntrancetoFastTrack extends Event {
	
	public static int stagenum = 0;
	public WarpTriageEntrancetoFastTrack(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		if(!Event.events[559].isSelfswitch1()){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"This door is locked./");
			super.Dialog(d, 0, this.getId(), true);
		}
		else{
			super.transport("/Worlds/Floor7Infirmary/Triage/FastTrack.txt", 5, 13,"");
		}
	}
	
	public boolean isDoor(){
		return true;
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
}
