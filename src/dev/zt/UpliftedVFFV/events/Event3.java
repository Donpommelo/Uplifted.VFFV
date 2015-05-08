package dev.zt.UpliftedVFFV.events;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.AngryBeef;
import dev.zt.UpliftedVFFV.inventory.BeefBoyle;
import dev.zt.UpliftedVFFV.inventory.BeefUnwell;
import dev.zt.UpliftedVFFV.inventory.BossMug;
import dev.zt.UpliftedVFFV.inventory.BucketBattery;
import dev.zt.UpliftedVFFV.inventory.CaffeinePatch;
import dev.zt.UpliftedVFFV.inventory.CarrotJuice;
import dev.zt.UpliftedVFFV.inventory.CoffeeBean;
import dev.zt.UpliftedVFFV.inventory.CoffeedIce;
import dev.zt.UpliftedVFFV.inventory.DeploreApp;
import dev.zt.UpliftedVFFV.inventory.EightBall;
import dev.zt.UpliftedVFFV.inventory.EnvenomEarth;
import dev.zt.UpliftedVFFV.inventory.FadedSash;
import dev.zt.UpliftedVFFV.inventory.FennelDonut;
import dev.zt.UpliftedVFFV.inventory.Fishbones;
import dev.zt.UpliftedVFFV.inventory.Lachiplatre;
import dev.zt.UpliftedVFFV.inventory.LemonyFresh;
import dev.zt.UpliftedVFFV.inventory.LetterOpener;
import dev.zt.UpliftedVFFV.inventory.MedPak;
import dev.zt.UpliftedVFFV.inventory.MeltedIcecream;
import dev.zt.UpliftedVFFV.inventory.MentalLeakage;
import dev.zt.UpliftedVFFV.inventory.MidgeBlood;
import dev.zt.UpliftedVFFV.inventory.MidgeProboscis;
import dev.zt.UpliftedVFFV.inventory.NewtonCradle;
import dev.zt.UpliftedVFFV.inventory.Paperweight;
import dev.zt.UpliftedVFFV.inventory.PostageStamp;
import dev.zt.UpliftedVFFV.inventory.SeeingEye;
import dev.zt.UpliftedVFFV.inventory.SimmerResent;
import dev.zt.UpliftedVFFV.inventory.SleepingPills;
import dev.zt.UpliftedVFFV.inventory.SmellingSalt;
import dev.zt.UpliftedVFFV.inventory.SummonConch;
import dev.zt.UpliftedVFFV.inventory.SummonLotus;
import dev.zt.UpliftedVFFV.inventory.SummonSauce;
import dev.zt.UpliftedVFFV.inventory.SummonTwofish;
import dev.zt.UpliftedVFFV.inventory.Unbeef;
import dev.zt.UpliftedVFFV.inventory.ZDrug;
import dev.zt.UpliftedVFFV.party.PenPal;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event3 extends Event {

	public static BufferedImage img=Assets.ElevatorDoor1;
	public Event3(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
	

	
	public void run(){
//		super.recruit(new PenPal());
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
		super.transport("res/Worlds/Lobby.txt", 7, 10,"South Lobby");
	}

	public static void main(String[] args) {
		
	}

}
