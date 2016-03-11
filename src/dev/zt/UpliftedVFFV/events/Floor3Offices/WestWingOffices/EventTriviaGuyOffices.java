package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EventTriviaGuyOffices extends Event {
	
	public String[] Choices={"A: Balustrade","B: Apron","C: Escutcheon Tube","D: Guide Rails","E: Buffer"};			//list of choices used in the choicebranch
	public static int stagenum = 1;			
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EventTriviaGuyOffices(float x, float y, int idnum) {
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
		
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				Dialog[] d1 = new Dialog[4];
				d1[0] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"Well, well, well, what do we have here?/Ah, yes! A new contestant!/");
				d1[1] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"Welcome, contestant, to <>Trivia, the game where every-day employees/demonstrate mastery over their varied fields of study by answering devilishly difficult Trivia Questions!/");
				d1[2] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"Being the Operator of this company, expect to have your elevator-related knowledge tested!/Answer the following question correctly and receive a fabulous prize!/Answer incorrectly, and bring great embarrassment to yourself and your coworkers!/");
				d1[3] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"Ready? No cheating!/");
				super.Dialog(d1, 3, this.getId(), true);
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"That's all I've got now, but be on the lookout!/You never know when the need for knowledge will strike!/");
				super.Dialog(d1, 0, this.getId(), true);

			}
			break;
		case 1:
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"Sometimes elevator doors can malfunction, opening before reaching the desired stop./Which component of the elevator is responsible for protecting passengers in such an accident?/");
			super.Dialog(d1, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices, 100);
			this.setSelfswitch1(true);
			this.setstage(0);
			break;
			
		}
	}
	
	public void ChoiceMade(int i){
		if(i == 1){
			Dialog[] d1 = new Dialog[5];
			d1[0] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,". . ./");
			d1[1] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"CORRECT! WE HAVE A WINNER! CONGRATULATIONS ARE IN ORDER!/");
			d1[2] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"The Car Apron, also known as the Toe Guard serves as an extra line of defense against the dangers/of an open elevator shaft! You can never be too careful, really when it comes to the lives of fellow coworkers!/");
			d1[3] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"Such knowledge! I expected no less from our building's one and only elevator operator!/Oh, and as for your reward . . .");
			d1[4] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You Obtained the Trivia Trinket!");
			super.Dialog(d1, 4, this.getId(), true);
			//Get Reward Item
		}
		else{
			Dialog[] d1 = new Dialog[3];
			d1[0] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,". . ./");
			d1[1] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"I'm sorry. That is incorrect./");
			d1[2] = new Dialog("Trivia Guy","/CharacterBusts/TriviaGuysmall.png",1,"How unfortunate./Better luck next time, I'm afraid.");
			super.Dialog(d1, 2, this.getId(), true);
		}
	}

	public boolean isSolid(int i){
		return true;
	}
	
}
