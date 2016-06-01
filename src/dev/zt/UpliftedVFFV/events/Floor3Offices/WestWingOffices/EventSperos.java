package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.ManilaFolder;



public class EventSperos extends Event {

	public static int stagenum = 0;
	public static BufferedImage img = Assets.Speros1;
	public EventSperos(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(super.getQuest(5) < 5){
			Dialog[] d = new Dialog[3];
			d[0] = new Dialog("Speros","/CharacterBusts/3rdWestOffices-5.png",1,". . .");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Excuse me sir, could you point us towards Suite 521?");
			d[2] = new Dialog("Speros","/CharacterBusts/3rdWestOffices-5.png",1,". . .");
			super.Dialog(d, 2, this.getId(), true);
		}
		else if(super.getQuest(5) == 5){
			Dialog[] d = new Dialog[10];
			d[0] = new Dialog("Speros","/CharacterBusts/3rdWestOffices-5.png",1,". . .");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Erm… Good afternoon, sir.");
			d[2] = new Dialog("Speros","/CharacterBusts/3rdWestOffices-5.png",1,". . .");
			d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"We are here to deliver a package. It’s from Carloc.");
			d[4] = new Dialog("Speros","/CharacterBusts/3rdWestOffices-5.png",1,". . .");
			d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Uh . . . I’m just gonna leave it here . . .");
			d[6] = new Dialog("Speros","/CharacterBusts/3rdWestOffices-5.png",1,"Carloc. Carloc you say?");
			d[7] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Uh . . . Yes.");
			d[8] = new Dialog("Speros","/CharacterBusts/3rdWestOffices-5.png",1,"She knows she can just fax me these, right?");
			d[9] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I think I’m going to head back now.");
			super.setQuest(5, 6);
			super.Dialog(d, 9, this.getId(), true);
			super.loot(new ManilaFolder(), -1);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Speros","/CharacterBusts/3rdWestOffices-5.png",1,". . .You should get back to work./");
			super.Dialog(d, 0, this.getId(), true);
		}
	}
	
	public void tick(){
		this.setFrames(this.getFrames()+1);
		if(this.getFrames()>=150){
			this.setTex(Assets.Speros1);
		}
		else if(this.getFrames()>=100){
			this.setTex(Assets.Speros1);
		}
		else if(this.getFrames()>=50){
			this.setTex(Assets.Speros1);
		}
		else {
			this.setTex(Assets.Speros1);
		}
		if(this.getFrames() >= 200){
			this.setFrames(0);
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
