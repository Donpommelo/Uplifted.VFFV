package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventJorge extends Event {

	public boolean fightwon=false;
	public static int stagenum = 4;
	public int frame;
	public static BufferedImage img = Assets.Jorge1;
	public EventJorge(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		this.frame = 0;
	}
	
	public void run(){
			switch(this.getstage()){
			case 0: 
				if(!isSelfswitch1()){
					Dialog[] d = new Dialog[5];
					d[0] = new Dialog("Jorge","/CharacterBusts/3rdSouthOffices-5.png",0,"Gah! Who is that? Can you not see that I am very busy?/");
					d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Good afternoon, sir! We were hoping you could point us towards Suite 521./Do you know where it is?/");
					d[2] = new Dialog("Jorge","/CharacterBusts/3rdSouthOffices-5.png",0,"Harghmph. You came to waste my time with that? Who do you think you are?/Of course I know where it is. Suite Five-hundred and twenty Whatever, I know all about/it. Hehehe. But I don・t feel like telling you./");
					d[3] = new Dialog("Jorge","/CharacterBusts/3rdSouthOffices-5.png",0,"Yeah, If you lack the manners to not bother me and the common sense to find/the damn room yourself, why should I help you?/");
					d[4] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"That seems. . .  unprofessional. . ./ ");
					super.Dialog(d, 4, this.getId(), true);
				}
				else{
					Dialog[] d2 = new Dialog[1];
					d2[0] = new Dialog("Jorge","/CharacterBusts/3rdSouthOffices-5.png",0,"Grrr. Why haven't the guards gotten here yet?/");
					super.Dialog(d2, 0, this.getId(), true);
					this.setstage(3);
				}
				break;
			case 1:
				Dialog[] d = new Dialog[3];
				d[0] = new Dialog("Jorge","/CharacterBusts/3rdSouthOffices-5.png",0,"What・s that!? Why you, you・ve got some nerve! Seeing as you clearly missed the/Office Assembly on Conduct and Courtesy, it is my duty as South Wing Manager/to teach you myself./");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Woah! Please, sir, calm down. We can talk about . . ./");
				d[2] = new Dialog("Jorge","/CharacterBusts/3rdSouthOffices-5.png",0,"C・mere! Don・t make me chase you!/");
				super.Dialog(d, 2, this.getId(), true);

				game.getAudiomanager().playMusic(4, true);
				break;
			case 2:
				super.fite(15,this.getId(), false, false);
				break;
			case 3:
				if(fightwon){
					setSelfswitch1(true);
					super.setSwitch(2,true);
					game.getAudiomanager().playMusic(2, true);
				}
				Dialog[] d2 = new Dialog[1];
				d2[0] = new Dialog("Jorge","/CharacterBusts/3rdSouthOffices-5.png",0,"Arrggh. . .  I'm calling security!/");
				super.Dialog(d2, 0, this.getId(), true);

				break;
			case 4:
				this.setstage(0);
				break;
			}			
	}
	
	public void tick(){
		frame++;
		if(frame>=150){
			this.setTex(Assets.Jorge4);
		}
		else if(frame>=100){
			this.setTex(Assets.Jorge3);
		}
		else if(frame>=50){
			this.setTex(Assets.Jorge2);
		}
		else {
			this.setTex(Assets.Jorge1);
		}
		if(frame >= 200){
			frame = 0;
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
	public boolean isFightwon() {
		return fightwon;
	}

	public void setFightwon(boolean fightwon) {
		this.fightwon = fightwon;
	}

}
