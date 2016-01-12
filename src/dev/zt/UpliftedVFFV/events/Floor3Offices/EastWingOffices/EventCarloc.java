package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.ManilaFolder;



public class EventCarloc extends Event {

	public boolean fightwon=false;
	public static int stagenum = 0;
	public int frame;
	public static BufferedImage img = Assets.Carloc1;
	public EventCarloc(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		this.frame = 0;
	}
	
	public void run(){
			if(!this.isSelfswitch1()){
				Dialog[] d = new Dialog[8];
				d[0] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",0,"Hmm? Are you lost? Are you looking for someone?/");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",1," Mam, could you tell us where we can find Suite 521?/");
				d[2] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Suite . . . 5. . .2. . ./");
				d[3] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,". . ./");
				d[4] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Y'know what? I think I have a . . . better plan./You're on a quest, right? Yes, yes you seem like the questing type to me./Why don't you do a little favor for me. A sidequest, if you will./");
				d[5] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"I'd like you to run along that hallway to the North and find The Informant./He looks exactly like yourself except with a different uniform./");
				d[6] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"Once you locate him, ask him for a Manila Folder and bring it back to me./There! That's simple enough, isn't it?/");
				d[7] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",1,"If you still care about . . . whatever it was you first asked me about, well/this quest will no doubt contribute greatly to your progress./I assure you./");
				super.Dialog(d, 7, this.getId(), true);
				this.setSelfswitch1(true);
			}
			else{
				if(this.isSelfswitch2()){
//					if(Speros talked to yet){
					
//					}
//					else{
						Dialog[] d = new Dialog[1];
						d[0] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",0,"Remember, you are to deliver the Manila Folder to room 136 in the West Wing./Make sure you are prepared for the level of enemy and workload intensity./");
						super.Dialog(d, 0, this.getId(), true);
//					}
				}
				else{
					if(super.itemNumCheck(new ManilaFolder()) > 0 ){
						Dialog[] d = new Dialog[4];
						d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Mam, we・ve got the folder here, but the Informant wanted us to tell you . . ./");
						d[1] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",0,"Oh, never mind him, just give me the Folder./Ah yes, that・s the one! And at a record time too!/");
						d[2] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",0,"Now, for the next part of your little quest. I need you to deliver this package to my coworker in the West Wing Offices./You can be certain that this quest will be well worth your time. Are we understood?/");
						d[3] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",0,"Run along now, but bear in mind that the West Wing is both tougher and more/productive than the other wings./");
						super.Dialog(d, 3, this.getId(), true);
						super.loot(new ManilaFolder(), -1);
						this.setSelfswitch2(true);
					}
					else{
						Dialog[] d = new Dialog[2];
						d[0] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",0,"Don・t you have a quest you should be doing?/Remember, you・re looking for the Informant./");
						d[1] = new Dialog("Carloc","/CharacterBusts/3rdEastOffices-5.png",0,"Feel free to ask for directions from any of my employees./They are very helpful./");
						super.Dialog(d, 1, this.getId(), true);

					}
				}
			}
	}
	
	public void tick(){
		frame++;
		if(frame>=150){
			this.setTex(Assets.Carloc1);
		}
		else if(frame>=100){
			this.setTex(Assets.Carloc1);
		}
		else if(frame>=50){
			this.setTex(Assets.Carloc1);
		}
		else {
			this.setTex(Assets.Carloc1);
		}
		if(frame >= 200){
			frame = 0;
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
