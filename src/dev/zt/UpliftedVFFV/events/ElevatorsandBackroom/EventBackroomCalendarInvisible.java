package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;



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
		super.loot(new MiracleCure(), 2);
	}
	
	public boolean isSolid(){
		return true;
	}
}
