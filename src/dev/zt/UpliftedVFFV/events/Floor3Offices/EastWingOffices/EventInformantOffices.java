package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.ManilaFolder;
import dev.zt.UpliftedVFFV.inventory.keyitems.SummonConch;
import dev.zt.UpliftedVFFV.inventory.misc.SummonSauce;



public class EventInformantOffices extends Event {

	public boolean fightwon=false;
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.Informant);
	public EventInformantOffices(float x, float y, int idnum) {
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
			switch(super.getQuest(5)){
			case 3:
				super.setQuest(5, 4);
				Dialog[] d = new Dialog[11];
				d[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Good morning, coworker. Do you need something?/");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Are you the Informant?/");
				d[2] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Yes. Did somebody send for me?/");
				d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Carloc told me to ask for something./I was hoping you’d know what she was referring to./");
				d[4] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Oh . . . /");
				d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Is something wrong?/");
				d[6] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"That’s just cruel. It really is. I expected better of her./");
				d[7] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . ./");
				d[8] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Here are the papers she is requesting. Complete whatever it is she demands./Just be quick about it. And try and find me afterwards so we can talk./There are some things you deserve to have explained to you./");
				d[9] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Let me open this up for you./Oh, and tell Carloc not to send me any more./");
				d[10] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained a Manila Folder!/Bring it back to Carloc in her office./");
				super.Dialog(d, 10, this.getId(), true);
				super.loot(new ManilaFolder(), 1);
				break;
			case 4:
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Well, you should be going now./You can get to Carloc's office through the bus ramp out there./");
				super.Dialog(d1, 0, this.getId(), true);
				break;
			case 5:
				Dialog[] d2 = new Dialog[11];
				d2[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Ah, excellent! I was hoping to see you! Tell me, what is it that Carloc asks of you now?/");
				d2[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"She told me to deliver the envelope to West Wing./");
				d2[2] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"West Wing?! No… no, that’s far too early. The level of the monsters and the productivity/there are far too high./Listen, I think you should take this./");
				d2[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You were given the Summoning Conch!//You can faintly hear the ocean!/");
				d2[4] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Seeing as you may be wandering into danger alone, thought this would be a fitting gift./Summoning objects, like this Conch, let you summon the memories of lost coworkers to aid/you in your quest./");
				d2[5] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"See that mark behind me? Those are Memory Holes./From each one, a different ally can be Summoned to join your party./");
				d2[6] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"The Conch serves as a conduit for the stray Memory, becoming more potent with use./Summons can only stray so far from their Memory Holes so try not to get too attached./");
				d2[7] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,". . ./");
				d2[8] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,". . . Anyways, take this./Without some sort of Summoning Sauce, Memories will be too hazy to be helpful./");
				d2[9] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained 3 Packets of Summoning Sauce!/");
				d2[10] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Take care. May you remain safe and informed./");
				super.Dialog(d2, 10, this.getId(), true);
				super.loot(new SummonConch(), 1);
				super.loot(new SummonSauce(), 3);
				super.setQuest(3, 2);
				super.setQuest(4, 4);
				super.setSwitch(10, true);
				this.setSelfswitch1(true);
				break;
			}
		}
		else{
			if(!this.isSelfswitch2()){
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Memory Holes were my area of study. Well, until recently that is./");
				d[1] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Quite an odd phenomenon./The holes manifest in locations where employees in the distant past underwent. . ./strange lapses in lucidity. A sort of fugue, if you will./");
				d[2] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"The Memories we summon may be the wandering consciousnesses of long-forgotten/coworkers briefly lost in time./");
				d[3] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"Sadly, this truth will have to wait./I have recently come across something that more urgently requires digging into . . ./");
				this.setSelfswitch2(true);
				super.Dialog(d, 3, this.getId(), true);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Informant","/CharacterBusts/Informant1small.png",1,"That is enough talk for now./We both have much still to learn./");
				super.Dialog(d, 0, this.getId(), true);
			}
			
		}
			
	}
	
	
	public boolean loaded(){
		boolean drawn = false;
		if(super.getQuest(5) >= 3 && !super.getSwitch(10)){
			drawn = true;
		}
		return drawn;
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
