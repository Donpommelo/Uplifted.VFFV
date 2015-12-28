package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpLin extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeF);
	public EmpLin(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
		}
		
		switch(this.getstage()){
		case 0: 
			if(this.isSelfswitch2()){
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"I think that's more than enough chatter for the quarter. We both have work/that we must refocus our attentions towards./");
				super.Dialog(d, 0, this.getId(), true);	
			}
			else if(!this.isSelfswitch1()){
				Dialog[] d = new Dialog[3];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"Greetings fellow coworker. Please tell me you are here for the meeting./");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I don't believe so. What is the meeting about?/");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"It's top secret. If you don't already know, I can't tell you./");
				super.Dialog(d, 2, this.getId(), true);
				this.setSelfswitch1(true);
			}
			else{
				Dialog[] d = new Dialog[13];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,". . ./");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"Well, alright. Seeing as we can't start until the South Office representatives show up,/I may as well tell you. I would be idle otherwise and idleness is intolerable./");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"We were discussing plans to revive one of the company's Lost Departments./The Department of Violence specifically./");
				d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Violence Department? Why does this company have a Violence Department?/");
				d[4] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"The Violence Department was founded by the late Figmous Werbeunroy with the/intention of creating a safer, more peaceful working environment for us employees./");
				d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Peaceful?/");
				d[6] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"Figmous believed that violence was an integral part of human nature./To attempt to eradicate violence would be to make the company and its employees/less human./");
				d[7] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"He planned to sequester all the violence in the building into one place./This way, The rest of the building is made more peaceful./");
				d[8] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"The Department of Violence is one of the Four Lost Departments; ancient/administrations that have long since been lost to the mists of time./ ");
				d[9] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"And the other three?/");
				d[10] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"Well, nobody knows for sure, But I think they were the Departments of/Passivity, Apathy and Suffering./");
				d[11] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Those sound terrible! What were our Founders thinking?/");
				d[12] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"Hmm. It makes sense if you think about it. We couldn't have a department of Happiness/because Happiness is a nice thing that the whole company should experience,/not just one department./");
				d[12] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"Management only isolates things into their own department if the rest of the/building wants nothing to do with them./");
				super.Dialog(d, 12, this.getId(), true);
				this.setSelfswitch2(true);
			}
			break;
		case 1:
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
			this.setstage(0);
			break;
			
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
