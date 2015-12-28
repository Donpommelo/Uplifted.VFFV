package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventBackroomDresser extends Event {

	public static int stagenum = 0;
	public EventBackroomDresser(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
		Dialog[] d = new Dialog[1];
		d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A dresser filled with identical red jackets./");
		super.Dialog(d, 0, this.getId(), true);
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
