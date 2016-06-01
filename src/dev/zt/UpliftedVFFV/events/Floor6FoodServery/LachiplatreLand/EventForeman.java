package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.consumables.Lachiplatre;
import dev.zt.UpliftedVFFV.inventory.keyitems.LachiplatreKey;

public class EventForeman extends Event {

	public boolean fightwon=false;
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EventForeman(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM1));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1));
		}
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[14];
			d[0] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Alright, men!/Make sure you get to those piles to the left!");
			d[1] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"I don’t want a single shipment leaving this place until we’ve checked every last one!");
			d[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Excuse me sir . . . What is this place?");
			d[3] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"We’re in the Lachiplatre Fields, pal./This is where we receive shipments from the outside of Lachiplatre . . .");
			d[4] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Hey, wait! How did you...How did you get here? You...You don’t work here, right?");
			d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"We were looking for a Lachiplatre./Could we perhaps borrow one from here?");
			d[6] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Er...No!/No!");
			d[7] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Could you imagine the panic if word got out?/Absolutely not. It would be criminally irresponsible of me!");
			d[8] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Word of what?");
			d[9] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Erm./Uh. Nothing! Nothing at all.");
			d[10] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"As a matter of fact, on second thought, you can have one!");
			d[11] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Yeah, go ahead and take one!/Just don’t ask me anymore questions. I need to get back to work.");
			d[12] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained the Lachiplatre!/");
			d[13] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Feel free to grab any more if you need.");
			this.setSelfswitch1(true);
			super.Dialog(d, 13, this.getId(), true);
			super.loot(new Lachiplatre(), 1);
		}
		else{
			switch(super.getQuest(12)){
			case 0:
				Dialog[] d = new Dialog[17];
				d[0] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Oh! Its you!/You’re the one who took a Lachiplatre from here earlier, aren’t you?");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Yes.");
				d[2] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"And you’re still ok?/Are you feeling fine?");
				d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"What do you mean?");
				d[4] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Oh, I was just worried. I gave you one that tested negative, but the tests aren’t always reliable.");
				d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Tested negative? Negative for what?/Why are Lachiplatres out of stock in the Food Court? What is going on back here?");
				d[6] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Woah,woah. One question at a time, please. I’m only trying to help.");
				d[7] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Is there something wrong with the Lachiplatre back here? Are they expired?");
				d[8] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"No no no no. That’s not it./I don’t even know if they can spoil. Its just that...well...");
				d[9] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"They're poisoned.");
				d[10] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Poisoned?!");
				d[11] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Well, tainted in some way or the other. But not all of them.");
				d[12] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Me and my men need to find the extent of the damage before the Lachiplatre are ready for consumption.");
				d[13] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Say, you look like the effectual type!/Why don’t you take one of these scanners and help me search?");
				d[14] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"We are actually quite busy./We were looking for a way to Suite 521.");
				d[15] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Hey, I gave you a Lachiplatre, remember? So you guys owe me one.");
				d[16] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Hey, I’ll even throw in some gift cards./Just use the scanner on Lachiplatre and yell out if the machine starts actin’ weird.");
				super.Dialog(d, 16, this.getId(), true);
				super.setQuest(12,1);
				break;
			case 1:
				Dialog[] d1 = new Dialog[2];
				d1[0] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Found the Tainted Lachiplatre yet?/");
				d1[1] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"No?/Well you should get back to work. This is a very important job.");
				super.Dialog(d1, 1, this.getId(), true);

				break;
			case 2:
				Dialog[] d2 = new Dialog[4];
				d2[0] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Oh? You've got it!/That must be it!");
				d2[1] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Yes, no doubt about it./That's the Tainted Lachiplatre we've been searching for.");
				d2[2] = new Dialog("Foreman","/CharacterBusts/Foreman1small.png",1,"Well, I certainly hope it wasn't too much trouble./Here, take this as a token of my gratitude!");
				d2[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained the Lachiplatre Key!");
				super.Dialog(d2, 3, this.getId(), true);
				super.loot(new LachiplatreKey(), 1);
				break;
			}
		}
			
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
