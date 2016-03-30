package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventPettingZooKeeper extends Event {

	public String[] Choices={"Never Mind","..."};			//list of choices used in the choicebranch
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EventPettingZooKeeper(float x, float y, int idnum) {
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
				Dialog[] d = new Dialog[2];
				d[0] = new Dialog("Petting Zookeeper","/CharacterBusts/3rdSouthOffices-1.png",1,"");
				d[1] = new Dialog("Petting Zookeeper","/CharacterBusts/3rdSouthOffices-1.png",1,"");
				super.Dialog(d, 1, this.getId(), true);

				this.setSelfswitch1(true);
			}
			else{
				if(super.getVar(24) == 0){
					
				}
				else{
					Dialog[] d = new Dialog[2];
					d[0] = new Dialog("Petting Zookeeper","/CharacterBusts/3rdSouthOffices-1.png",1,"Well, I think that ought to be enough play for now. You should get back to work.");
					d[1] = new Dialog("Petting Zookeeper","/CharacterBusts/3rdSouthOffices-1.png",1,"");
					super.Dialog(d, 1, this.getId(), true);
					this.setstage(1);
				}
			}
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}
	
	public void ChoiceMade(int i){
		super.setVar(24, i);
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
