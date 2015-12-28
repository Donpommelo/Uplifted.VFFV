package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpVitor extends Event {

	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM2);
	public static int stagenum = 0;
	public EmpVitor(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);	
	}
	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM2));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM2));
		}
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[7];
			d[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Oh. It is Operator. Hello Operator./");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Good morning! What floor for you?/");
			d[2] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,". . ./");
			d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . .Oh, Sorry! I just. . .got so used to. . . /");
			d[4] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Operator, I think, stay in elevator all day, not so good for you. Ya?/");
			d[5] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Is good to see you getting fresh air. There is more to life than Elevators. Ya?/Like, there's also Offices and stuff./And I think we got nice Aquarium on one these floors too./");
			d[6] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Anyways, was nice speaking to you again./If you ever need life advice or something, you can come to me, ok?/");
			super.Dialog(d, 6, this.getId(), true);
			this.setSelfswitch1(true);
		}
		else{
			switch((int)(Math.random()*13)){
			case 0:
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey remember, if you ever don't know where you need to go next, just skip it./Go somewhere you don't need to first./");
				super.Dialog(d1, 0, this.getId(), true);
				break;
			case 1:
				Dialog[] d2 = new Dialog[1];
				d2[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey remember, if you ever lost, fear not. That just means you discover new area./Very exciting, ya?/");
				super.Dialog(d2, 0, this.getId(), true);
				break;
			case 2:
				Dialog[] d3 = new Dialog[1];
				d3[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey, if you ever have trouble make progress, don't worry./If you wait very long time, you will suffer most irreversible progress eventually./");
				super.Dialog(d3, 0, this.getId(), true);
				break;
			case 3:
				Dialog[] d4 = new Dialog[1];
				d4[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey, if you ever feel lonely, just remember you are important part of this workplace./Your coworkers will always value you no matter what./");
				super.Dialog(d4, 0, this.getId(), true);		
				break;
			case 4:
				Dialog[] d5 = new Dialog[1];
				d5[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey, whenever you feel very sad, just remember that it was an accident I swear, ok?/And besides, they were terminally ill anyways./");
				super.Dialog(d5, 0, this.getId(), true);	
				break;
			case 5:
				Dialog[] d6 = new Dialog[1];
				d6[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey, if you ever have conflict with coworker, just remember that everyone make/mistakes. Ya, we are only human after all. Most of us anyways./");
				super.Dialog(d6, 0, this.getId(), true);
				break;
			case 6:
				Dialog[] d7 = new Dialog[1];
				d7[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey remember, if you ever feel like nothing makes sense, just stop making sense too./Gotta go with the flow, ya?/");
				super.Dialog(d7, 0, this.getId(), true);
				break;
			case 7:
				Dialog[] d8 = new Dialog[1];
				d8[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey, whenever you afraid of something, just remember that it's probably just as/scared of you.I mean, unless your fear is spending rest of your life empty and alone./I was more thinking, y'know, spiders or something./");
				super.Dialog(d8, 0, this.getId(), true);
				break;
			case 8:
				Dialog[] d9 = new Dialog[1];
				d9[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey remember, if you are afraid of failure, just pretend you aren't trying, ya?/That way, only you will know the depth of your own insecurities./");
				super.Dialog(d9, 0, this.getId(), true);
				break;
			case 9:
				Dialog[] d10 = new Dialog[1];
				d10[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey remember, if you ever need help, just scream at top of lungs./That way, your coworkers will agree that you need help too./");
				super.Dialog(d10, 0, this.getId(), true);
				break;
			case 10:
				Dialog[] d11 = new Dialog[1];
				d11[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey, if you ever feel uncertain, just remember that certainty is just as bad./Maybe even worse, I dunno./");
				super.Dialog(d11, 0, this.getId(), true);
				break;
			case 11:
				Dialog[] d12 = new Dialog[1];
				d12[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey, if you ever struggle to deal with pressures of life, don't worry./The pressures of death will seem very easy in comparison./");
				super.Dialog(d12, 0, this.getId(), true);
				break;
			case 12:
				Dialog[] d13 = new Dialog[1];
				d13[0] = new Dialog("Employee","/CharacterBusts/Vitor1small.png",1,"Hey, if you ever feel tired, remember to take ten-minute break every/hour to stretch and look at nature or something./");
				super.Dialog(d13, 0, this.getId(), true);
				break;				
			}
		}
	}

	public boolean isSolid(int i){
		return true;
	}
}
