package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.PenPal;
import dev.zt.UpliftedVFFV.dialog.Dialog;


public class EventElevatorPanel extends Event {

	public String[] Choices={"1: Reception","2: Bathhouse","3: Offices","4: Aquarium","5: Management","6: Food Services","7: Infirmary","8: Orchestral Cathedral","9: Little America","11: Justice Park","12: Gallery of Lights"};
	public static int stagenum=1;
	public EventElevatorPanel(float x, float y, int idnum) {
		super(Assets.ElevatorPanel,idnum,x, y, stagenum);
	}
	
	public void run(){	
		reset();
		Choices[super.getVar(1)] = Choices[super.getVar(1)]+" (current)";
		if(!super.getGamestate().getEvents()[52].isSelfswitch1() && super.getGamestate().getEvents()[54].isSelfswitch1()){		//if EmployeeIntro has already left + Pen
																						//Pal has not been talked to, nothing happens
		}
		else{
			switch(this.getstage()){										//if Pen Pal had been recruited, panel cannot be used until
			case 0: 														//tutorial is over + Jorge beaten
				if(this.isSelfswitch2() && !super.getSwitch(3)){
					if(super.getSwitch(2)){
						Dialog[] d = new Dialog[1];
						d[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Before we explore the rest of the building, there is something I/want to show you first. Can we go to your room?/");
						super.Dialog(d, 0, this.getId(), true);
					}
					else{
						Dialog[] d = new Dialog[1];
						d[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Lets explore this floor first. We can check the other floors later./");
						super.Dialog(d, 0, this.getId(), true);
					}	
				}
				else{														//otherwise choices are present.
					int floor = super.getVar(1)+1;
					Dialog[] d = new Dialog[1];
					d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"To which Floor? (Current Floor: "+floor+")/");
					super.Dialog(d, 0, this.getId(), false);
					super.ElevatorChoiceBranch(this.getId(), Choices, 200);
				}
				break;
			case 1:
				if(this.isSelfswitch2() && !super.getSwitch(3)){										//if Pen Pal has been recruited, its event is erased
					super.getGamestate().getEvents()[52].setDrawn(false);
					super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 6, 7,"");
				}
				this.setstage(0);
				break;
			}
		}			
	}
	
	public void ChoiceMade(int i){
		if(super.getSwitch(3)){										
			if(super.getVar(1)!= i)
			{
				super.setVar(1,i);
				super.screenShake(50);
			}
		
		}
		
		else if(!super.getGamestate().getEvents()[52].isSelfswitch1()){
			if(!super.getGamestate().getEvents()[54].isSelfswitch1()){
				if(i == 5){
					super.screenShake(50);
					super.setVar(1,5);
					super.getGamestate().getEvents()[54].run();	
					this.setSelfswitch1(true);
				}
				else{
					Dialog[] d = new Dialog[1];
					d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I don't think that's the floor that was asked for./That coworker asked to go to the 6th Floor./");
					super.Dialog(d, 0, this.getId(), true);
				}
			}
		}
		else{
			if(super.getGamestate().getEvents()[52].isSelfswitch1()){
				switch(i){
				case 0:
					Dialog[] d1 = new Dialog[1];
					d1[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Reception? I'm pretty sure there isn't anything on that floor./");
					super.Dialog(d1, 0, this.getId(), true);
					break;
				case 1:
					Dialog[] d2 = new Dialog[1];
					d2[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"The Bathhouse? Do I look like I need watering that badly?/");
					super.Dialog(d2, 0, this.getId(), true);
					break;
				case 2:
					super.screenShake(50);
					super.setVar(1,2);
					Dialog[] d3 = new Dialog[10];
					d3[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Alright, Here's your floor!/");
					d3[1] =  new Dialog("Operator","/CharacterBusts/Player-1.png",0, "Wait! How are these letters responding to everything I say?/Can you hear me?/");
					d3[2] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Now Operator, We mustn't squander time. Every second wasted on silly/questions is one less for preventing unspeakable calamity./");
					d3[3] =  new Dialog("Operator","/CharacterBusts/Player-1.png",0, "Well, I don't think I can follow you. I'm supposed to stay here and do my job./");
					d3[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Your job is to help people get to where they need, No?/Well, I need to get to Suite 521, so its your job to get me there./");
					d3[5] =  new Dialog("Operator","/CharacterBusts/Player-1.png",0, "Well I suppose . . ./");
					d3[6] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"And besides, as you may have noticed, I have no legs./");
					d3[7] =  new Dialog("Operator","/CharacterBusts/Player-1.png",0, ". . ./");
					d3[8] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Don't worry. I trust that this whole affair will be either very short or very fulfilling!/");
					d3[9] =  new Dialog("meep","/CharacterBusts/Arturo.png",1, "Your Pen Pal joined your party!/Your party can be checked from the menu by pressing 'Z'!");
					super.Dialog(d3, 9, this.getId(), true);
					super.recruit(new PenPal(1));
					this.setSelfswitch2(true);
					break;
				case 3:
					Dialog[] d4 = new Dialog[1];
					d4[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"The Aquarium? Ugh./I don't want to think about water right now./");
					super.Dialog(d4, 0, this.getId(), true);
					break;
				case 4:
					Dialog[] d5 = new Dialog[1];
					d5[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"The Suites? I'm afraid only authorized employees are allowed there./You aren't authorized, right?/");
					super.Dialog(d5, 0, this.getId(), true);
					break;
				case 5:
					Dialog[] d6 = new Dialog[1];
					d6[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"The Food Servery? We can grab a bite to eat once this whole affair is over./");
					super.Dialog(d6, 0, this.getId(), true);
					break;
				case 6:
					Dialog[] d7 = new Dialog[1];
					d7[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"The Infirmary? Hopefully that will not be necessary. But perhaps later./");
					super.Dialog(d7, 0, this.getId(), true);
					break;
				case 7:
					Dialog[] d8 = new Dialog[1];
					d8[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"The Cathedral? Something tells me Suite 521 will not there./");
					super.Dialog(d8, 0, this.getId(), true);
					break;
				case 8:
					Dialog[] d9 = new Dialog[1];
					d9[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"I . . .don't know what this floor is for./And I'm not feeling curious./");
					super.Dialog(d9, 0, this.getId(), true);
					break;
				case 9:
					Dialog[] d11 = new Dialog[1];
					d11[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Justice Park? Lets not go there./Yet./");
					super.Dialog(d11, 0, this.getId(), true);
					break;
				case 10:
					Dialog[] d12 = new Dialog[1];
					d12[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"The Gallery of Lights? Sounds nice, but we really should be going to the 3rd Floor now./");
					super.Dialog(d12, 0, this.getId(), true);
					break;
				case 11:
					
					break;

				}
			}
			
		}
		
	}

	public boolean isSolid(int i){
		return true;
	}
	
	
	public void reset(){
		Choices[0] = "1: Reception";
		Choices[1] = "2: Bathhouse";
		Choices[2] = "3: Offices";
		Choices[3] = "4: Aquarium";
		Choices[4] = "5: Management";
		Choices[5] = "6: Food Services";
		Choices[6] = "7: Infirmary";
		Choices[7] = "8: Orchestral Cathedral";
		Choices[8] = "9: Little America";
		Choices[9] = "11: Justice Park";
		Choices[10] = "12: Gallery of Lights";
		if(super.getQuest(5) > 6){
			Choices[11] = "B1: Company Town";
			Choices[12] = "B2: Boiler Room";
		}
	}
}
