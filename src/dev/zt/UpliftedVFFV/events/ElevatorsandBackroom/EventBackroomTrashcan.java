package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomTrashcan extends Event {

	public static int stagenum = 0;
	public EventBackroomTrashcan(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
		Dialog[] d = new Dialog[2];
		d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A wastebasket./");
		d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"It contains some crumpled sketches of various elevator parts./");
		super.Dialog(d, 1, this.getId(), true);
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
