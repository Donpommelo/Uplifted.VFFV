package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;


import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.consumables.Lachiplatre;

public class EventLachiplatrePile extends Event {

	public boolean fightwon=false;
	public static int stagenum = 1;
	public EventLachiplatrePile(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
		switch(this.getstage()){
		case 0:
			if(super.getGamestate().getEvents()[764].isSelfswitch1()){
				Dialog[] d = new Dialog[2];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A pile of Lachiplatre./You pocket one of them.");
				d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained a Lachiplatre!");
				super.Dialog(d, 1, this.getId(), true);
				super.loot(new Lachiplatre(), 1);
			}
			else{
				Dialog[] d = new Dialog[3];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A pile of Lachiplatre.");
				d[1] = new Dialog("Worker","/CharacterBusts/Foreman1small.png",1,"Hey, you!/Don't touch that!");
				d[2] = new Dialog("Worker","/CharacterBusts/Foreman1small.png",1,"Sorry, buddy./Foreman says we aren't supposed to let anyone come into contact with the Lachiplatre.");
				super.Dialog(d, 2, this.getId(), true);
			}
			break;
		case 1:
			this.setstage(0);
			break;
		}
		
			
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
