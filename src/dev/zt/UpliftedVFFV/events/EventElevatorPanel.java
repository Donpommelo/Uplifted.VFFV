package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class EventElevatorPanel extends Event {

	public boolean selfswitch1=false;
	public String[] Choices={"1","2","3","4","5","6","7","8","9","11","12","Violence"};
	public EventElevatorPanel(float x, float y, int idnum) {
		super(Assets.ElevatorPanel,idnum,x, y);
	
	}
	

	
	public void run(){	
		super.Dialog(24, 24);
		super.loot(new MedPak(),3);
		super.loot(new CaffeinePatch(),3);
		super.loot(new AngryBeef(),99);
		super.loot(new BeefBoyle(),3);
		super.loot(new BeefUnwell(),5);
		super.loot(new BossMug(),1);
		super.loot(new CarrotJuice(),6);
		super.loot(new CoffeeBean(),1);
		super.loot(new CoffeedIce(),13);
		super.loot(new DeploreApp(),1);
		super.loot(new EightBall(),1);
		super.loot(new EnvenomEarth(),1);
		super.loot(new FadedSash(),1);
		super.loot(new FennelDonut(),1);
		super.loot(new Fishbones(),1);
		super.loot(new Lachiplatre(),999);
		super.loot(new LemonyFresh(),10);
		super.loot(new LetterOpener(),1);
		super.loot(new MeltedIcecream(),3);
		super.loot(new MentalLeakage(),1);
		super.loot(new MidgeBlood(),5);
		super.loot(new MidgeProboscis(),1);
		super.loot(new NewtonCradle(),1);
		super.loot(new Paperweight(),1);
		super.loot(new SeeingEye(),1);
		super.loot(new SleepingPills(),8);
		super.loot(new SummonSauce(),1);
		super.loot(new Unbeef(),1);
		super.loot(new ZDrug(),12);
		super.loot(new PostageStamp(),12);
		super.loot(new BucketBattery(),1);
		super.loot(new SmellingSalt(),1);
		super.loot(new SimmerResent(),1);
		super.loot(new SummonConch(),1);
		super.loot(new SummonTwofish(),1);
		super.loot(new SummonLotus(),1);
		super.ChoiceBranch(this.getId(), Choices);
		
		

			
			
	}
	
	public void ChoiceMade(int i){
		switch(i){
		case 0:
			super.Dialog(26,27);
			break;
		case 1:
			super.Dialog(28,29);
			break;
		case 2:
			super.Dialog(30,31);
			break;
		case 3:
			super.Dialog(32,33);
			break;
		case 4:
			super.Dialog(34,35);
			break;
		case 5:
			super.Dialog(36,37);
			break;
		case 6:
			super.Dialog(38,39);
			break;
		case 7:
			super.Dialog(40,43);
			break;
		case 8:
			super.Dialog(44,45);
			break;
		case 9:
			super.Dialog(46,49);
			break;
		case 10:
			super.Dialog(50,53);
			break;
		case 11:
			super.Dialog(54,56);
			break;

		}
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
