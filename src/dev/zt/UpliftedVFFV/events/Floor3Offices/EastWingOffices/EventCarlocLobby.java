package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventCarlocLobby extends Event {

	public static int stagenum = 0;
	public static BufferedImage img = Assets.Carloc1;
	public EventCarlocLobby(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[13];
			d[0] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Hmm? Are you lost? Are you looking for someone?");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0," Mam, could you tell us where we can find Suite 521?");
			d[2] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Suite . . . 5 . . . 2 . . . ?");
			d[3] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,". . .");
			d[4] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Y'know what? I think I have a . . . better plan./You are on a . . . quest, right?");
			d[5] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Yes, yes you certainly seem like the questing type to me./Could I ask a small favor from you?");
			d[6] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"You seem like a reliable sort of fellow./The kind of employee who would never let his coworkers down.");
			d[7] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"I would like you to run along that hallway to the North and find The Informant. He looks exactly like yourself except with a different uniform.");
			d[8] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Think of it as a sidequest!");
			d[9] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Once you locate the Informant, ask him for a Manila Folder and bring it back to me.");
			d[10] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1," There! That's simple enough, isn't it?");
			d[11] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"If you still care about . . . whatever it was you first asked me about, well this quest will no doubt contribute greatly to your progress. I assure you.");
			d[12] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"That is how sidequests work, isn't it?/Yes, of course it is.");
			this.setSelfswitch1(true);
			super.Dialog(d, 12, this.getId(), true);
			super.setQuest(5, 1);
			super.setQuest(1, 5);
		}
		else{
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Don't you have a quest you should be doing?/Remember, you're looking for the Informant.");
			d[1] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Feel free to ask for directions from any of my employees./They are very helpful.");
			super.Dialog(d, 1, this.getId(), true);
		}
			
			
	}
	
	public void tick(){
		this.setFrames(this.getFrames()+1);
		if(this.getFrames()>=150){
			this.setTex(Assets.Carloc1);
		}
		else if(this.getFrames()>=100){
			this.setTex(Assets.Carloc1);
		}
		else if(this.getFrames()>=50){
			this.setTex(Assets.Carloc1);
		}
		else {
			this.setTex(Assets.Carloc1);
		}
		if(this.getFrames() >= 200){
			this.setFrames(0);
		}
		
	}
	
	public boolean loaded(){
		if(super.getQuest(5) == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
