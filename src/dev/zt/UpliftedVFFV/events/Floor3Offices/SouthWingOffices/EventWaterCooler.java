package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventWaterCooler extends Event {

	public static int stagenum = 0;
	public EventWaterCooler(float x, float y, int idnum) {
		super(Assets.WaterCooler,idnum,x, y, stagenum);
	}
	
	public void run(){
		Dialog[] d = new Dialog[5];
		d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hey. . . uh. . . do you need any watering?");
		d[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Watering? What do you mean?");
		d[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Well, there's a water cooler right here. Are you thirsty at all?");
		d[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Oh, that. Goodness, no. Water is the last thing I need right now. I don't even want to look at it.");
		d[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"But, that's very considerate of you to ask./You are very responsible. I knew you were the right person for this task.");
		super.Dialog(d, 4, this.getId(), true);
	}

	public boolean isSolid(int i){
		return true;
	}
}
