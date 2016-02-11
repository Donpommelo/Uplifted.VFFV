package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthHallLongtoBathroomWomens extends Event {


	public WarpSouthHallLongtoBathroomWomens(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);	
	}
	
	public void run(){
		//super.transport("/Worlds/Floor3Offices/SouthWingOffices/RestroomWomens.txt", 4, 9,"");
		Dialog[] d = new Dialog[5];
		d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . ./");
		d[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,". . . ?/");
		d[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Oh, that's the women's bathroom. I can't go in there./");
		d[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,". . .That's not what I was confused about./I was wondering why you were planning to go in there at all./I'm certain that Suite 521 is not a bathroom./");
		d[4] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . ./");
		super.Dialog(d, 4, this.getId(), true);
	}
	
	public boolean isSolid(int direction){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
	
}
