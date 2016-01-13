package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpWeAllKnowOne extends Event {
	
	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EmpWeAllKnowOne(float x, float y, int idnum) {
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
				Dialog[] d = new Dialog[5];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I always feel exhausted, yet I never feel like I've actually done anything./");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I feel like my life is devoid of options, yet I'm filled with uncertainty about the future./");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I wish I had people in my life that cared about me, yet I'm terrified of having more/friends to dissapoint and expectations to fall short of./");
				d[3] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I just feel like. . ./");
				d[4] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,". . .uh. . .sorry, I'll stop./");
				super.Dialog(d, 4, this.getId(), true);
				this.setSelfswitch1(true);
			}
			else{
				Dialog[] d = new Dialog[5];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,". . ./");
				super.Dialog(d, 0, this.getId(), true);
			}
			
			break;
		case 1:
			super.getGamestate().getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
