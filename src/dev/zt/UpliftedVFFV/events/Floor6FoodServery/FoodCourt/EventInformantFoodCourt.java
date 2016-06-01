package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.OldUmbrella;
import dev.zt.UpliftedVFFV.inventory.keyitems.PressureBox;
import dev.zt.UpliftedVFFV.inventory.keyitems.ShrinkingRay;

public class EventInformantFoodCourt extends Event {

	public boolean fightwon=false;
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.Informant);
	public EventInformantFoodCourt(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.Informant));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.Informant));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.Informant));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.Informant));
		}
		if(!this.isSelfswitch1()){
			switch(super.getQuest(3)){
			case 2:
				super.setQuest(3, 3);
				Dialog[] d = new Dialog[16];
				d[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Ah, it is good to see you again, Operator.");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Oh, hello.");
				d[2] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"So, I've been curious./What exactly were you doing prior to your meeting with Carloc and myself?");
				d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"We were looking for Suite 521.");
				d[4] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Oh?/And how has that endeavor progressed since?");
				d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Well, we were trying to find a Lachiplatre.");
				d[6] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"A Lachiplatre? Whatever for?");
				d[7] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"To sneak into the delivery room./We thought we could find it somewhere there.");
				d[8] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Yes, yes. A good plan indeed!/And where do you plan to acquire a Lachiplatre?");
				d[9] = new Dialog("Operator","/CharacterBusts/Player-1.png",1,"I’m not really sure. Maybe Lachiplatre-Land? Or is that too obvious?");
				d[10] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Hmm. It wouldn’t hurt to check it out. But Lachiplatre-Land isn’t a restaurant. I don’t even think food and drink is allowed inside.");
				d[11] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Lachiplatre-Land was a play-place daycare for employees to drop off their kids. Only kids are allowed into the actual play area.");
				d[12] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"If you want to check it out, you should take this.");
				d[12] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained the Shrinking Ray!");
				d[13] = new Dialog("Operator","/CharacterBusts/Player-1.png",1,"Thank you, sir!");
				d[14] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"And while you’re there, there’s something else I’d like you to check out for me...");
				d[15] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"There is an old Greeter Machine somewhere in there./I’d like you to check it out and report back to me what it says.");
				super.loot(new ShrinkingRay(), 1);
				super.Dialog(d, 15, this.getId(), true);
				break;
			case 3:
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Any luck searching Lachiplatre-Land?/There should be a Greeter Machine inside that I want you to investigate.");
				super.Dialog(d1, 0, this.getId(), true);
				break;
			case 4:
				Dialog[] d2 = new Dialog[13];
				d2[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"You're back so soon. Did you find the machine?");
				d2[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Yeah, we did. But it was in disuse. Lack of maintenance I suppose.");
				d2[2] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"So... I take it there was no response.");
				d2[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"It gave me this umbrella. I suppose someone left it there a long time ago.");
				d2[4] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"May I see it?");	
				d2[5] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Hmm. Looks like an ordinary umbrella to me. Is that...all?");
				d2[6] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Sorry. The machine wasn't working at all.");
				d2[7] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Don’t be sorry. It isn’t your fault./Hey, I might even keep this. In case it rains later.");
				d2[8] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"...");
				d2[9] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"I appreciate the effort nonetheless, I really do. You should have this as a token of thanks. I’ve been hanging onto in for a while now, but I haven’t been able to open it.");
				d2[10] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained the Pressure-Lock Box!");
				d2[11] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"I think there’s some sort of pressure-lock that will only open at certain elevation above sea-level.");
				d2[12] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"You know a thing or two about elevation, right?/Maybe you’ll have better luck opening it than me.");

				super.loot(new OldUmbrella(), -1);
				super.loot(new PressureBox(), 1);
				super.Dialog(d2, 12, this.getId(), true);
				super.setQuest(3, 5);
				this.setSelfswitch1(true);
				break;
			}
		}
		else{
			if(!this.isSelfswitch2()){
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"<EXTRA TEXT>");
				this.setSelfswitch2(true);
				super.Dialog(d, 3, this.getId(), true);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"<OK YOU CAN GO NOW>");
				super.Dialog(d, 0, this.getId(), true);
			}
			
		}
			
	}
	
	
	public boolean loaded(){
		boolean drawn = false;
		if(super.getQuest(3) >= 2 && super.getQuest(10) == 4){
			drawn = true;
		}
		return drawn;
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
