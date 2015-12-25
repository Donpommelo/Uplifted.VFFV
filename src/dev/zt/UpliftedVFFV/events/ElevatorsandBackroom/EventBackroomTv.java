package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomTv extends Event {

	public static int stagenum = 0;
	public EventBackroomTv(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
		Dialog[] d = new Dialog[2];
		d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A Television Set./There isn't anything interesting on right now./");
		d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Maybe if you had some VCRs or something like that./");
		super.Dialog(d, 1, this.getId(), true);
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
