package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import java.awt.image.BufferedImage;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.CaffeinePatch;
import dev.zt.UpliftedVFFV.inventory.DeploreApp;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.LemonyFresh;
import dev.zt.UpliftedVFFV.inventory.MedPak;
import dev.zt.UpliftedVFFV.inventory.SleepingPills;
import dev.zt.UpliftedVFFV.inventory.SmellingSalt;
import dev.zt.UpliftedVFFV.inventory.SummonSauce;



public class EventJanitor1 extends Event {

	public boolean selfswitch1=false;
	public String[] Choices={"Save","Shop","Never Mind"};
	public static int stage=0;						
	public static int finalstage=2;	
	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/Janitor1small.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public EventJanitor1(float x, float y, int idnum) {
		super(Assets.EmployeeM2,idnum,x, y);
		selection.put(new MedPak(), 1);
		selection.put(new CaffeinePatch(),2);
		selection.put(new SmellingSalt(), 5);
		selection.put(new LemonyFresh(), 5);
		selection.put(new SummonSauce(), 5);
		selection.put(new SleepingPills(), 6);
		selection.put(new DeploreApp(), 960);
	}
	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM2));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM2));
		}
//		super.shop(this.getId(),selection,shopKeeper);
//		if(selfswitch1==false){
			switch(stage){
			case 0: 
				if(!selfswitch1){
					super.Dialog(169, 175,this.getId());
					selfswitch1 = true;
				}
				else{
					super.Dialog(178, 178,this.getId());
				}
				break;
			case 1:
				super.Dialog(176, 176,this.getId());
				super.ChoiceBranch(this.getId(), Choices);
	//			stage=0;
				break;
			case 2:
				stage = 0;
				break;
			}
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public int getfinalstage() {
		return finalstage;
	}

	public int getstage() {
		return stage;
	}

	public void setstage(int stage) {
		EventJanitor1.stage = stage;
	}

	public void ChoiceMade(int i){
		switch(i){
		case 0:
			stage = 2;
			break;
		case 1:
			super.shop(this.getId(),selection,shopKeeper);
			stage = 2;
			break;
		case 2:
			super.Dialog(177, 177,this.getId());
			stage = 2;
			break;
		}
	}
}
