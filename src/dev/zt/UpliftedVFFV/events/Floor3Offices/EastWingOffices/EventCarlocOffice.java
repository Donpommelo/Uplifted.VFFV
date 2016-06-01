package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.BasementKeyCard;
import dev.zt.UpliftedVFFV.inventory.keyitems.ManilaFolder;



public class EventCarlocOffice extends Event {

	public static int stagenum = 0;
	public static BufferedImage img = Assets.Carloc1;
	public EventCarlocOffice(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
			if(this.isSelfswitch1()){
					if(super.getQuest(5) == 6){
						super.setQuest(5, 7);
						Dialog[] d = new Dialog[6];
						d[0] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"You’ve finished already!/What a challenging yet satisfying quest!/You should feel very accomplished!");
						d[1] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,". . . Is something wrong?/You seem on edge.");
						d[2] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"You've just completed a very grand quest!/Set your mind at ease. I'm not going to pounce on you or anything.");
						d[3] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Anyways, now for your final reward!/I present to you the Basement Key!/With this card, you can access the Company Town on floor B1!");
						d[4] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Let me unlock the elevator in my room so you can head down there immediately.");
						d[5] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Why don’t you go shop and socialize with your coworkers like a well-adjusted employee?");
						super.loot(new BasementKeyCard(), 1);
						super.Dialog(d, 5, this.getId(), true);
					}
					else if(super.getQuest(5) == 7){
						Dialog[] d = new Dialog[1];
						d[0] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"It’s good to see that you aren’t getting into any trouble!");
						super.Dialog(d, 0, this.getId(), true);
					}
					else{
					Dialog[] d = new Dialog[1];
					d[0] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Remember, you are to deliver the Manila Folder to room 136 in the West Wing. Make sure you are prepared for the level of enemy and workload intensity.");
					super.Dialog(d, 0, this.getId(), true);
					}
			}
			else{
				if(super.itemNumCheck(new ManilaFolder()) > 0 ){
					Dialog[] d = new Dialog[6];
					d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Mam, we've got the folder here, and the Informant wanted us to tell you . . .");
					d[1] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Oh, never mind him, just give me the Folder./Ah yes, that's the one! And at a record time too!");
					d[2] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Now, for the next part of your little quest. I need you to deliver this package to my coworker, Speros.");
					d[3] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"He lives in . . . er . . . /He works in the West Wing Offices.");
					d[4] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Now, you can be certain that this quest will be well worth your time. Are we understood?");
					d[5] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Run along now, but bear in mind that the West Wing is both tougher and more productive than the other wings.");
					super.Dialog(d, 5, this.getId(), true);
					super.setQuest(5, 5);
					super.setQuest(3, 1);
					this.setSelfswitch1(true);
				}
				else{
					Dialog[] d = new Dialog[2];
					d[0] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Don't you have a quest you should be doing?/Remember, you're looking for the Informant.");
					d[1] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Feel free to ask for directions from any of my employees./They are very helpful.");
					super.Dialog(d, 1, this.getId(), true);

				}
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
	
	public boolean isSolid(int i){
		return true;
	}
		
}
