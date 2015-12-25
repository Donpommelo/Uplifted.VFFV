package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;



public class EventStory3 extends Event {

	public static int stagenum = 0;
	public BufferedImage[] scenes = new BufferedImage[2];
	public EventStory3(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
		scenes[0]=ImageLoader.loadImage("/Cutscenes/Intro1.png");
		scenes[1]=ImageLoader.loadImage("/Cutscenes/Intro2.png");
	}
		
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[13];
			d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Well, we're here. What was it you wanted to show me?/");
			d[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Ah yes. We'll get right to that. Do you have those stamps we found earlier?/");
			d[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Yes. What are they for?/");
			d[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Well, I can't help but notice that unused writing desk over there./You could use those stamps to send me letters./I am your Pen Pal after all./");
			d[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"If you ever want to ask me a question, just go to your Writing Desk and type/the word or phrase you'd like to know more about./");
			d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"But what is the purpose of that if we can just talk to each other like this?/");
			d[6] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,". . ./");
			d[7] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I don¡¦t mean to be intrusive, but what exactly are you?/");
			d[8] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"I'm your Pen Pal. Didn't I already explain that?/");
			d[9] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Are you also a tree?/");
			d[10] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Is that what this is? In any case, no./Although I have been adrift on one since my plane was shot down./");
			d[11] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . ./");
			d[12] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"You see, I survived a plane crash in open ocean and found this potted plant/in the flotsnam to cling onto. My first instinct, of course, was to send a message in a bottle for help./");
			d[13] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"But unfortunately, I didn't have any bottles. Frustrated, I stuck my letter/in the soil of the pot and accepted the inevitability of death./");
			d[14] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"The next day, I was shocked to find a crumpled envelope growing from the/plant like a budding flower! A response to my letter from the day before from an unknown saviour!/");
			d[15] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"I thought we hit it off quite well, so I was dismayed when the letters/suddenly ceased one day./");
			d[16] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Since then, I've been burying letters to anyone and everyone./You are the only one who has written back./");
			d[17] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . .and reaaching Suite 521 will . . . help you?/");
			d[18] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,". . ./");
			d[19] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"No./");
			d[20] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"But it needs to be done anyways./We have wasted enough time already. We must set out for Suite 521 immediately./");
			super.Dialog(d, 20, this.getId(), true);

			this.setSelfswitch1(true);
			Event.events[45].setSelfswitch2(false);
			super.setSwitch(3, true);
			super.transport("/Worlds/ElevatorsandBackroom/HomeSweetElevatorV2.txt", 10, 7,"");
		}
			
					
	}

		
	public boolean drawn(){
		return !this.isSelfswitch1() && Event.events[66].isSelfswitch1();
	}

}
