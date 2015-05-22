package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;


public class Event1 extends Event {


	public boolean selfswitch1=false;	
	public Event1(float x, float y, int idnum) {
		super(Assets.Black,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/SouthElevator.txt", 3, 6,"South Elevator");
		if(!selfswitch1){
			super.Dialog(0,8,this.getId());
			selfswitch1= true;
		}
		
	}

	public static void main(String[] args) {
		if(game==null){System.out.print("meep");}
	}

}
