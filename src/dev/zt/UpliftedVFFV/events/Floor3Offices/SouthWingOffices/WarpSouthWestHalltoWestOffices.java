package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpSouthWestHalltoWestOffices extends Event {


	public WarpSouthWestHalltoWestOffices(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
	
	public void run(){
		if(!Event.events[287].isSelfswitch1()){
			Dialog[] d = new Dialog[4];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"This door is locked from the other side.");
			d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"There is a note attached to the door.");
			d[2] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"'Due to repeated infractions negatively affecting officeplace productivity, South Wing Employees are prohibited from entering West Offices until further notice.'");
			d[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Sincerely, Speros.");
			super.Dialog(d, 3, this.getId(), true);
		}
		else{
			super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleFinal.txt",20,48,"West Offices");
		}
	}


	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
}
