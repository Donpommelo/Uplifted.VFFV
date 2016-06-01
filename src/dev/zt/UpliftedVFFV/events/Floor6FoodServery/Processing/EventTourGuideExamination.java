package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.SandwichToothPick;

public class EventTourGuideExamination extends Event {

	public String[] Choices1={"Got it right here!","Give me more time."};			//list of choices used in the choicebranch
	public String[] Choices2={"Uh. Ok?","Why would I do that?"};			//list of choices used in the choicebranch
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EventTourGuideExamination(float x, float y, int idnum) {
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
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1
					));
		}
		
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[11];
			d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Congratulations!/You have passed the first portion of your Processing Training Program!");
			d[1] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"The next stage of your examination consists of a simple examination to comprehensively test your abilities!");
			d[2] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"I hope you've properly prepared yourself!/For the examination, we will require that you...");
			d[3] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Make me a sandwich.");
			d[4] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,".../?");
			d[5] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Well, better get busy./You can find ingredients in the Food Pyramid.");
			d[6] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"The Food Pyramid is in the Resynthesizing Room. You probably passed it on the way in.");
			d[7] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"I'll tell the boys to unlock it for you./You better hurry. I'm famished.");
			d[8] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Oh, and take this./");
			d[9] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained Sandwich Toothpick!/");
			d[10] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Don't get sandwich bits everywhere./That probably violates some kind of safety regulation or whatever.");
			super.Dialog(d, 10, this.getId(), true);
			super.setQuest(13, 3);
			super.loot(new SandwichToothPick(), 1);
			this.setSelfswitch1(true);
		}
		else{
			if(super.getQuest(13) < 4){
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Well, pal./How's my sandwich coming along.");
				super.Dialog(d, 0, this.getId(), true);
				super.ChoiceBranch(this.getId(), Choices1, 300);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Oh./It's you again./Did you want to make me another sandwich or something?");
				super.Dialog(d, 0, this.getId(), true);
				super.ChoiceBranch(this.getId(), Choices2, 300);
			}
			
		}
			
		
	}
	
	
	public void ChoiceMade(int i){
		if(i == 0){
			int score = calculateSandwich();
			
			
			if(score > 100){
				
				if(score > 150){
					//Pass quest + bonus item
				}
				else{
					Dialog[] d = new Dialog[7];
					d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Hmm. Mmm. Nmm.");
					d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The worker takes a bite of the sandwich and chews pensively.");
					d[2] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Its...");
					d[3] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Alright, I guess./Nothing to write home about, but acceptable./Like, if you're hungry or whatever.");
					d[4] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Good enough./You pass./Barely.");
					d[5] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"I'll let you into the Distribution now.");
					d[6] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The worker throws the remainder of the sandwich into a bottomless pit.");
					super.Dialog(d, 6, this.getId(), true);
				}
				super.setQuest(13, 4);
			}
			else{
				if(score == 0){
					Dialog[] d = new Dialog[4];
					d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Eh?/This is just a plain Sandwich Toothpick.");
					d[1] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Is this some kinda invisible sandwich or something.");
					d[2] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The worker places the Sandwich Toothpick in his mouth.");
					d[3] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Hmm./I guess not.");
					super.Dialog(d, 3, this.getId(), true);
	
				}
				else if(score <60){
					Dialog[] d = new Dialog[6];
					d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Hmm. Mmm. Nmm.");
					d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The worker takes a bite of the sandwich and chews pensively.");
					d[2] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Hey!/This isn't a sandwich!");
					d[3] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"This is just a couple of ingredients haphazardly thrown together!");
					d[4] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"C'mon, you're employed!/You can do better than this!");
					d[5] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The worker throws the remainder of the sandwich into a bottomless pit.");
					super.Dialog(d, 5, this.getId(), true);
				}
				else{
					Dialog[] d = new Dialog[6];
					d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Hmm. Mmm. Nmm.");
					d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The worker takes a bite of the sandwich and chews pensively.");
					d[2] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Its...");
					d[3] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Eh./I can tell you tried, but it just isn't good enough.");
					d[4] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"I cannot allow an employee of this level of food prepatory skills in the Distribution Room. Sorry.");
					d[5] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The worker throws the remainder of the sandwich into a bottomless pit.");
					super.Dialog(d, 5, this.getId(), true);

				}
			}
			
			super.setVar(31, 0);
			super.setVar(32, 0);
			super.setVar(33, 0);
			super.setVar(34, 0);
			super.setVar(35, 0);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/ServeryMYellowsmall.png",1,"Well, hurry along then./");
			super.Dialog(d, 0, this.getId(), true);
		}
	}
	
	public int calculateSandwich(){
		int total = 0;

		if(super.getVar(31) != 0){
			total+=20;
		}if(super.getVar(32) != 0){
			total+=20;
		}if(super.getVar(33) != 0){
			total+=20;
		}if(super.getVar(34) != 0){
			total+=20;
		}if(super.getVar(35) != 0){
			total+=20;
		}
		
		
		return total;
	}
	
	public boolean drawn(){
		if(super.getQuest(13) < 2){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
