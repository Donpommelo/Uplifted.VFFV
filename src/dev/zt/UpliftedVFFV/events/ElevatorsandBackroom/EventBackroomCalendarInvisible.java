package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.inventory.consummables.AngryBeef;
import dev.zt.UpliftedVFFV.inventory.consummables.BeefBoyle;
import dev.zt.UpliftedVFFV.inventory.consummables.CaffeinePatch;
import dev.zt.UpliftedVFFV.inventory.consummables.CarrotJuice;
import dev.zt.UpliftedVFFV.inventory.consummables.CoffeeBean;
import dev.zt.UpliftedVFFV.inventory.consummables.CoffeedIce;
import dev.zt.UpliftedVFFV.inventory.consummables.FennelDonut;
import dev.zt.UpliftedVFFV.inventory.consummables.Lachiplatre;
import dev.zt.UpliftedVFFV.inventory.consummables.LemonyFresh;
import dev.zt.UpliftedVFFV.inventory.consummables.MedPak;
import dev.zt.UpliftedVFFV.inventory.consummables.MeltedIcecream;
import dev.zt.UpliftedVFFV.inventory.consummables.MentalLeakage;
import dev.zt.UpliftedVFFV.inventory.consummables.MidgeBlood;
import dev.zt.UpliftedVFFV.inventory.consummables.SeeingEye;
import dev.zt.UpliftedVFFV.inventory.consummables.SmellingSalt;
import dev.zt.UpliftedVFFV.inventory.consummables.Unbeef;
import dev.zt.UpliftedVFFV.inventory.equipables.AbsoluteThreshold;
import dev.zt.UpliftedVFFV.inventory.equipables.AutoQuerier;
import dev.zt.UpliftedVFFV.inventory.equipables.BackpackBaphomet;
import dev.zt.UpliftedVFFV.inventory.equipables.BandagedSword;
import dev.zt.UpliftedVFFV.inventory.equipables.BossMug;
import dev.zt.UpliftedVFFV.inventory.equipables.BoxofFun;
import dev.zt.UpliftedVFFV.inventory.equipables.BucketBattery;
import dev.zt.UpliftedVFFV.inventory.equipables.CactusSuit;
import dev.zt.UpliftedVFFV.inventory.equipables.CatalogueofNeed;
import dev.zt.UpliftedVFFV.inventory.equipables.CatalogueofWant;
import dev.zt.UpliftedVFFV.inventory.equipables.CursedCilice;
import dev.zt.UpliftedVFFV.inventory.equipables.DeadMansHand;
import dev.zt.UpliftedVFFV.inventory.equipables.DeploreApp;
import dev.zt.UpliftedVFFV.inventory.equipables.EchoShell;
import dev.zt.UpliftedVFFV.inventory.equipables.EightBall;
import dev.zt.UpliftedVFFV.inventory.equipables.EmaudelinesRaincoat;
import dev.zt.UpliftedVFFV.inventory.equipables.EmpathyLink;
import dev.zt.UpliftedVFFV.inventory.equipables.EnvenomEarth;
import dev.zt.UpliftedVFFV.inventory.equipables.FadedSash;
import dev.zt.UpliftedVFFV.inventory.equipables.FalseFace;
import dev.zt.UpliftedVFFV.inventory.equipables.FaradayCage;
import dev.zt.UpliftedVFFV.inventory.equipables.FestusClaw;
import dev.zt.UpliftedVFFV.inventory.equipables.FestusMask;
import dev.zt.UpliftedVFFV.inventory.equipables.Fishbones;
import dev.zt.UpliftedVFFV.inventory.equipables.GGG;
import dev.zt.UpliftedVFFV.inventory.equipables.HandofGlory;
import dev.zt.UpliftedVFFV.inventory.equipables.HnHFake;
import dev.zt.UpliftedVFFV.inventory.equipables.InformantTie;
import dev.zt.UpliftedVFFV.inventory.equipables.KidneyStone;
import dev.zt.UpliftedVFFV.inventory.equipables.Kinhunter;
import dev.zt.UpliftedVFFV.inventory.equipables.LastBreath;
import dev.zt.UpliftedVFFV.inventory.equipables.LetterOpener;
import dev.zt.UpliftedVFFV.inventory.equipables.MadnessMantra;
import dev.zt.UpliftedVFFV.inventory.equipables.Magnum;
import dev.zt.UpliftedVFFV.inventory.equipables.MidgeProboscis;
import dev.zt.UpliftedVFFV.inventory.equipables.NewtonCradle;
import dev.zt.UpliftedVFFV.inventory.equipables.PainGate;
import dev.zt.UpliftedVFFV.inventory.equipables.Paperweight;
import dev.zt.UpliftedVFFV.inventory.equipables.PrehistoricSynapse;
import dev.zt.UpliftedVFFV.inventory.equipables.RecyclerBolus;
import dev.zt.UpliftedVFFV.inventory.equipables.RingofGyges;
import dev.zt.UpliftedVFFV.inventory.equipables.SimmerResent;
import dev.zt.UpliftedVFFV.inventory.equipables.SpeedChute;
import dev.zt.UpliftedVFFV.inventory.equipables.TouchofDeath;
import dev.zt.UpliftedVFFV.inventory.keyitems.SummonConch;
import dev.zt.UpliftedVFFV.inventory.keyitems.SummonLotus;
import dev.zt.UpliftedVFFV.inventory.keyitems.SummonTwofish;
import dev.zt.UpliftedVFFV.inventory.misc.Disease;
import dev.zt.UpliftedVFFV.inventory.misc.FishWater;
import dev.zt.UpliftedVFFV.inventory.misc.MetalRations;
import dev.zt.UpliftedVFFV.inventory.misc.PostageStamp;
import dev.zt.UpliftedVFFV.inventory.misc.SleepingPills;



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
		super.loot(new RingofTesting(), 6);
		super.loot(new AutoQuerier(), 1);
		super.loot(new EmpathyLink(),1);
		super.loot(new FaradayCage(), 2);
		super.loot(new DeadMansHand(), 3);
		super.loot(new CatalogueofWant(), 1);
		super.loot(new CatalogueofNeed(), 1);
		super.loot(new GGG(), 2);
		super.loot(new HandofGlory(), 2);
		super.loot(new MadnessMantra(), 1);
		super.loot(new KidneyStone(), 2);
		super.loot(new EchoShell(), 2);
		super.loot(new PrehistoricSynapse(), 2);
		super.loot(new PainGate(), 2);
		super.loot(new AbsoluteThreshold(), 2);
		super.loot(new BoxofFun(), 1);
		super.loot(new SummonConch(), 1);
		super.loot(new SummonLotus(), 1);
		super.loot(new SummonTwofish(), 1);
		super.loot(new BandagedSword(),2);
		super.loot(new RecyclerBolus(),2);
		super.loot(new BackpackBaphomet(),2);
		super.loot(new HnHFake(), 1);
		super.loot(new FalseFace(), 1);
		super.loot(new EmaudelinesRaincoat(), 1);
		super.loot(new InformantTie(), 2);
		super.loot(new FestusClaw(), 2);
		super.loot(new FestusMask(), 2);
		super.loot(new TouchofDeath(), 1);
		super.loot(new LastBreath(), 1);
		super.loot(new Kinhunter(), 1);
		super.loot(new RingofGyges(), 2);
}
	
	public boolean isSolid(int i){
		return true;
	}
}
