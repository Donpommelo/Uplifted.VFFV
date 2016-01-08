package dev.zt.UpliftedVFFV.events;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.inventory.consumables.*;
import dev.zt.UpliftedVFFV.inventory.equipables.*;
import dev.zt.UpliftedVFFV.inventory.keyitems.*;
import dev.zt.UpliftedVFFV.inventory.misc.*;



public class EventTestItems extends Event {

	public static int stagenum = 0;
	public EventTestItems(float x, float y, int idnum) {
		super(Assets.Calendar,idnum,x, y,stagenum);
		
	}
	

	
	public void run(){
				
		super.loot(new AngryBeef(), 2);
		super.loot(new BeefBoyle(), 3);
		super.loot(new CaffeinePatch(), 5);
		super.loot(new CarrotJuice(), 3);
		super.loot(new CoffeeBean(), 2);
		super.loot(new CoffeedIce(), 1);
		super.loot(new Disease(),4);
		super.loot(new FennelDonut(), 1);
		super.loot(new FishWater(), 1);
		super.loot(new Lachiplatre(), 683);
		super.loot(new LemonyFresh(), 2);
		super.loot(new MedPak(), 6);
		super.loot(new MeltedIcecream(), 3);
		super.loot(new MentalLeakage(), 5);
		super.loot(new MidgeBlood(), 4);
		super.loot(new PostageStamp(),4);
		super.loot(new SeeingEye(), 1);
		super.loot(new SleepingPills(), 6);
		super.loot(new SmellingSalt(), 3);
		super.loot(new Unbeef(), 3);
		super.loot(new MetalRations(), 6);
				
		super.loot(new SummonConch(), 1);
		super.loot(new SummonLotus(), 1);
		super.loot(new SummonTwofish(), 1);
				
		super.loot(new RingofTesting(), 6);

		super.loot(new AbsoluteThreshold(), 2);
		super.loot(new AbyssalInsignia(), 2);
		super.loot(new AtomicPunchThrusters(), 2);
		super.loot(new AutoQuerier(), 1);
		super.loot(new BackpackBaphomet(),2);
		super.loot(new BackpackBuddy(),2);
		super.loot(new BadShell(),2);
		super.loot(new BandagedSword(),2);
		super.loot(new BloodSeal(), 1);
		super.loot(new BloodwoodsOvercoat(), 1);
		super.loot(new BossMug(), 1);
		super.loot(new BoxofFun(), 1);
		super.loot(new BucketBattery(), 1);
		super.loot(new CactusSuit(), 2);
		super.loot(new CatalogueofWant(), 1);
		super.loot(new CatalogueofNeed(), 1);
		super.loot(new CatchersGlove(), 1);
		super.loot(new CatchersMask(), 1);
		super.loot(new CensuredResonance(), 1);
		super.loot(new CompoundVitreous(), 1);
		super.loot(new CursedCilice(),2);
		super.loot(new DeadMansHand(), 3);
		super.loot(new DeploreApp(), 1);
		super.loot(new DreamEater(), 2);
		super.loot(new EchoShell(), 2);
		super.loot(new EightBall(), 1);
		super.loot(new EmaudelinesPrism(), 1);
		super.loot(new EmaudelinesRaincoat(), 1);
		super.loot(new EmpathyLink(),1);
		super.loot(new EnvenomEarth(), 1);
		super.loot(new EternalIce(), 2);
		super.loot(new FadedSash(), 1);
		super.loot(new FalseFace(), 1);
		super.loot(new FaradayCage(), 2);
		super.loot(new FensClippedWings(), 1);
		super.loot(new FestusClaw(), 2);
		super.loot(new FestusMask(), 2);
		super.loot(new Fishbones(), 1);
		super.loot(new FracturePlate(), 3);
		super.loot(new GGG(), 2);
		super.loot(new GloveoftheMaker(), 1);
		super.loot(new HandofGlory(), 2);
		super.loot(new HnHFake(), 1);
		super.loot(new InformantTie(), 2);
		super.loot(new KidneyStone(), 2);
		super.loot(new Kinhunter(), 1);
		super.loot(new LastBreath(), 1);
		super.loot(new LetterOpener(), 3);
		super.loot(new MadnessMantra(), 1);
		super.loot(new Magnum(), 1);
		super.loot(new MidgeProboscis(), 1);
		super.loot(new NewtonCradle(), 1);
		super.loot(new PainGate(), 3);
		super.loot(new Paperweight(), 3);
		super.loot(new PrehistoricSynapse(), 1);
		super.loot(new RecyclerBolus(),2);
		super.loot(new RingofGyges(), 2);
		super.loot(new SimmerResent(), 1);
		super.loot(new SimpleMind(), 1);
		super.loot(new SlackerSlacks(), 1);
		super.loot(new SpeedChute(), 2);
		super.loot(new TouchofDeath(), 1);

	}
	
	public boolean isSolid(int i){
		return true;
	}
}
