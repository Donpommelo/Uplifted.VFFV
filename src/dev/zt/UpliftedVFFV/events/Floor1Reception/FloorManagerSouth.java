package dev.zt.UpliftedVFFV.events.Floor1Reception;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.FalseFace;
import dev.zt.UpliftedVFFV.inventory.keyitems.MonsterCoffee;

public class FloorManagerSouth extends Event {

	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public FloorManagerSouth(float x, float y, int idnum) {
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
			if(super.itemNumCheck(new MonsterCoffee()) == 1){
				if(!this.isSelfswitch1()){
					Dialog[] d = new Dialog[9];
					d[0] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Hey, Operator, You weren't planning on leaving, were you?/I don't believe your shift is over yet./");
					d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",1,"N . . . no sir. I was just . . ./");
					d[2] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Never mind that. You should get back to work.//. . ./");
					d[3] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Say, now that you're down here, why don't you make yourself useful./Could you be so kind as to fetch me my coffee?/It is in a room to the West of here./");
					d[4] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Thanks in advanced./");
					d[5] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Wait, you already have it?/Huh . . ./");
					d[6] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Thanks, I guess . . ./");
					d[7] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Ahh. That's much better./You probably weren't expecting a reward, but here is one anyways./");
					d[8] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained the False Face!/");
					super.Dialog(d, 8, this.getId(), true);
					this.setSelfswitch1(true);
				}
				else{
					Dialog[] d = new Dialog[3];
					d[0] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Thank you for the coffee, Operator./");
					d[1] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Ahh . . . This must be what it feels like to give orders./I could get used to this./Anyways, you should have this. As a token of thanks./");
					d[2] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained the False Face!/");
					super.Dialog(d, 2, this.getId(), true);

				}
				super.loot(new MonsterCoffee(), -1);
				super.loot(new FalseFace(),1);
				super.setVar(19, super.getVar(19)+1);
				super.setQuest(7, 3);
			}
			else{
				if(super.getQuest(7) == 3){
					Dialog[] d = new Dialog[1];
					d[0] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Ahh. That hits the spot./");
					super.Dialog(d, 0, this.getId(), true);
				}
				else{
					if(!this.isSelfswitch1()){
						Dialog[] d = new Dialog[5];
						d[0] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Hey, Operator, You weren't planning on leaving, were you?/I don't believe your shift is over yet./");
						d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",1,"N . . . no sir. I was just . . ./");
						d[2] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Never mind that. You should get back to work.//. . ./");
						d[3] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Say, now that you're down here, why don't you make yourself useful./Could you be so kind as to fetch me my coffee?/It is in a room to the West of here./");
						d[4] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Thanks in advance./");
						super.Dialog(d, 4, this.getId(), true);
						super.setQuest(7, 1);
						this.setSelfswitch1(true);
					}
					else{
						Dialog[] d = new Dialog[1];
						d[0] = new Dialog("Floor Manager","/CharacterBusts/3rdEastOffices-1.png",1,"Fetch me my coffee yet?/I'd get it myself, but I'm not supposed to leave./");
						super.Dialog(d, 0, this.getId(), true);
					}
				}
			}
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}
	
	
	public boolean isSolid(int i){
		return true;
	}
		
}
