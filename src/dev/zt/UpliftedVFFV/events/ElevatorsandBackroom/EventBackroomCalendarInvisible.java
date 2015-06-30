package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.AngryBeef;
import dev.zt.UpliftedVFFV.inventory.BeefBoyle;
import dev.zt.UpliftedVFFV.inventory.BossMug;
import dev.zt.UpliftedVFFV.inventory.BucketBattery;
import dev.zt.UpliftedVFFV.inventory.CactusSuit;
import dev.zt.UpliftedVFFV.inventory.CaffeinePatch;
import dev.zt.UpliftedVFFV.inventory.CarrotJuice;
import dev.zt.UpliftedVFFV.inventory.CoffeeBean;
import dev.zt.UpliftedVFFV.inventory.CoffeedIce;
import dev.zt.UpliftedVFFV.inventory.CursedCilice;
import dev.zt.UpliftedVFFV.inventory.DeploreApp;
import dev.zt.UpliftedVFFV.inventory.Disease;
import dev.zt.UpliftedVFFV.inventory.EightBall;
import dev.zt.UpliftedVFFV.inventory.EnvenomEarth;
import dev.zt.UpliftedVFFV.inventory.FadedSash;
import dev.zt.UpliftedVFFV.inventory.FennelDonut;
import dev.zt.UpliftedVFFV.inventory.FishWater;
import dev.zt.UpliftedVFFV.inventory.Fishbones;
import dev.zt.UpliftedVFFV.inventory.Lachiplatre;
import dev.zt.UpliftedVFFV.inventory.LemonyFresh;
import dev.zt.UpliftedVFFV.inventory.LetterOpener;
import dev.zt.UpliftedVFFV.inventory.Magnum;
import dev.zt.UpliftedVFFV.inventory.MedPak;
import dev.zt.UpliftedVFFV.inventory.MeltedIcecream;
import dev.zt.UpliftedVFFV.inventory.MentalLeakage;
import dev.zt.UpliftedVFFV.inventory.MetalRations;
import dev.zt.UpliftedVFFV.inventory.MidgeBlood;
import dev.zt.UpliftedVFFV.inventory.MidgeProboscis;
import dev.zt.UpliftedVFFV.inventory.NewtonCradle;
import dev.zt.UpliftedVFFV.inventory.Paperweight;
import dev.zt.UpliftedVFFV.inventory.PostageStamp;
import dev.zt.UpliftedVFFV.inventory.SeeingEye;
import dev.zt.UpliftedVFFV.inventory.SimmerResent;
import dev.zt.UpliftedVFFV.inventory.SleepingPills;
import dev.zt.UpliftedVFFV.inventory.SmellingSalt;
import dev.zt.UpliftedVFFV.inventory.SpeedChute;
import dev.zt.UpliftedVFFV.inventory.Unbeef;



public class EventBackroomCalendarInvisible extends Event {

	public boolean selfswitch1=false;
	public EventBackroomCalendarInvisible(float x, float y, int idnum) {
		super(Assets.Calendar,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.Dialog(166, 166,this.getId());
		super.loot(new AngryBeef(), 2);
		super.loot(new BeefBoyle(), 3);
		super.loot(new BossMug(), 1);
		super.loot(new BucketBattery(), 1);
		super.loot(new CaffeinePatch(), 5);
		super.loot(new CarrotJuice(), 3);
		super.loot(new CoffeeBean(), 2);
		super.loot(new CoffeedIce(), 1);
		super.loot(new DeploreApp(), 1);
		super.loot(new Disease(),4);
		super.loot(new EightBall(), 1);
		super.loot(new EnvenomEarth(), 1);
		super.loot(new FadedSash(), 1);
		super.loot(new FennelDonut(), 1);
		super.loot(new FishWater(), 1);
		super.loot(new Fishbones(), 1);
		super.loot(new Lachiplatre(), 683);
		super.loot(new LemonyFresh(), 2);
		super.loot(new LetterOpener(), 3);
		super.loot(new MedPak(), 6);
		super.loot(new MeltedIcecream(), 3);
		super.loot(new MentalLeakage(), 5);
		super.loot(new MidgeBlood(), 4);
		super.loot(new MidgeProboscis(), 1);
		super.loot(new NewtonCradle(), 1);
		super.loot(new Paperweight(), 3);
		super.loot(new SeeingEye(), 1);
		super.loot(new PostageStamp(),4);
		super.loot(new SimmerResent(), 1);
		super.loot(new SleepingPills(), 6);
		super.loot(new SmellingSalt(), 3);
		super.loot(new Unbeef(), 3);
		super.loot(new CactusSuit(), 2);
		super.loot(new CursedCilice(),2);
		super.loot(new Magnum(), 1);
		super.loot(new MetalRations(), 6);
		super.loot(new SpeedChute(), 2);
	}
	
	public boolean isSolid(){
		return true;
	}
}
