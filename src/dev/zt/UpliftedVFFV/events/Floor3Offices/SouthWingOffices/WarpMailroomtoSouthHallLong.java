package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpMailroomtoSouthHallLong extends Event {


	public WarpMailroomtoSouthHallLong(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthOfficeHallway.txt", 29, 11,"South Offices");
		if(!this.isSelfswitch1() && super.getSwitch(2)){
			this.setSelfswitch1(true);
			Dialog[] d = new Dialog[5];
			d[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Well that was minimally helpful.");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"So, where should I take you now?");
			d[2] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"I think we should visit the remainder of this floor. The other wings will probably be more helpful than this.");
			d[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"But this building is pretty big./If you know a better place to look, we can start there instead.");
			d[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"But before we do any of that, why don't we head back to your room? I have some interesting things to show you.");
			super.Dialog(d, 4, this.getId(), true);
		}
		
	}
	
}
