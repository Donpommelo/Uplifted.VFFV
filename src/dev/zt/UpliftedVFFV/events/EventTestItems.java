package dev.zt.UpliftedVFFV.events;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.inventory.consumables.*;
import dev.zt.UpliftedVFFV.inventory.equipables.*;
import dev.zt.UpliftedVFFV.inventory.keyitems.*;
import dev.zt.UpliftedVFFV.inventory.misc.*;
import dev.zt.UpliftedVFFV.party.PenPal;



public class EventTestItems extends Event {

	public static int stagenum = 0;
	public EventTestItems(float x, float y, int idnum) {
		super(Assets.Calendar,idnum,x, y,stagenum);
		
	}
	

	
	public void run(){
		//super.cameraMove(0, 0, 50);
		//super.screenShake(50);
		super.recruit(new PenPal(1));
		super.scriptChange(1000);
		
		super.loot(new AngryBeef(), 2);
		super.loot(new Antiinflammatory(), 6);
		super.loot(new BadYolk(), 6);
		super.loot(new BagofCurses(), 6);
		super.loot(new BeefBoyle(), 3);
		super.loot(new BeefUnwell(), 3);
		super.loot(new BelugaBubblegum(), 6);
		super.loot(new Bettergent(), 6);
		super.loot(new CaffeinePatch(), 5);
		super.loot(new CarrotJuice(), 3);
		super.loot(new Charcoal(), 6);
		super.loot(new CoffeeBean(), 2);
		super.loot(new CoffeedIce(), 1);
		super.loot(new ColdMedicine(), 6);
		super.loot(new CoughDrops(), 6);
		super.loot(new Disease(),4);
		super.loot(new FennelDonut(), 1);
		super.loot(new FishWater(), 1);
		super.loot(new GlimpseattheEnd(), 600);
		super.loot(new JanitorDonationForm(), 6);
		super.loot(new Lachiplatre(), 683);
		super.loot(new LaserPointer(), 1);
		super.loot(new LemonyFresh(), 2);
		super.loot(new MagicBottle(), 1);
		super.loot(new MedPak(), 6);
		super.loot(new MeltedIcecream(), 3);
		super.loot(new MentalLeakage(), 5);
		super.loot(new MetalRations(), 6);
		super.loot(new MidgeBlood(), 4);
		super.loot(new MuscleRelaxant(), 6);
		super.loot(new PostageStamp(),4);
		super.loot(new PrinterTonerBlack(),4);
		super.loot(new PrinterTonerCyan(),4);
		super.loot(new PrinterTonerMagenta(),4);
		super.loot(new PrinterTonerYellow(),4);
		super.loot(new ProofofWill(),4);
		super.loot(new SaltedNori(), 6);
		super.loot(new SeeingEye(), 1);
		super.loot(new SleepingPills(), 6);
		super.loot(new SmellingSalt(), 3);
		super.loot(new StatScrubber(), 3);
		super.loot(new Stimulant(), 3);
		super.loot(new SummonSauce(), 6);
		super.loot(new SweetishFish(), 6);
		super.loot(new ThoughtFluid(), 3);
		super.loot(new Unbeef(), 3);
		super.loot(new UnheardWord(), 6);
		super.loot(new ZDrug(), 6);
		
		

		super.loot(new ColoredPlasticBall(1,0,0), 1);
		super.loot(new ColoredPlasticBall(0,1,0), 1);
		super.loot(new ColoredPlasticBall(0,0,1), 1);
		super.loot(new RandomFoodSmall(), 1);
		super.loot(new RandomFoodMedium(), 1);
		super.loot(new RandomFoodLarge(), 1);
		super.loot(new RandomPotion(), 1);
		super.loot(new RandomPotion(), 1);
		super.loot(new RandomPotion(), 1);
		super.loot(new RandomPotion(), 1);
		super.loot(new RandomPotion(), 1);
		super.loot(new RandomPotion(), 1);
		super.loot(new RandomPotion(), 1);
		super.loot(new RandomPotion(), 1);
		super.loot(new RandomPotion(), 1);

		super.loot(new SummonConch(), 1);
		super.loot(new SummonLotus(), 1);
		super.loot(new SummonTwofish(), 1);
				
		super.loot(new RingofTesting(), 6);

		super.loot(new AbsoluteThreshold(), 2);
		super.loot(new AbyssalInsignia(), 2);
		super.loot(new AetherFeather(), 2);
		super.loot(new AnchorTalisman(), 2);
		super.loot(new AquariumSouvenirTshirt(), 2);
		super.loot(new AtomicPunchThrusters(), 2);
		super.loot(new AutoQuerier(), 1);
		super.loot(new BackpackBaphomet(),2);
		super.loot(new BackpackBuddy(),2);
		super.loot(new BadShell(),2);
		super.loot(new BandagedSword(),2);
		super.loot(new BladeoftheFallen(), 2);
		super.loot(new BloodSeal(), 1);
		super.loot(new BloodwoodsOvercoat(), 1);
		super.loot(new BossMug(), 1);
		super.loot(new BoxofFun(), 1);
		super.loot(new BucketBattery(), 1);
		super.loot(new CactusSuit(), 2);
		super.loot(new CalloftheVoid(), 2);
		super.loot(new CannonCr4p(), 1);
		super.loot(new CannonElectrostatic(), 1);
		super.loot(new CannonHand(), 1);
		super.loot(new CannonSuperSoaker(), 1);
		super.loot(new CannonVenom(), 1);
		super.loot(new CatalogueofWant(), 1);
		super.loot(new CatalogueofNeed(), 1);
		super.loot(new CatchersGlove(), 1);
		super.loot(new CatchersMask(), 1);
		super.loot(new CelestialAnnointment(), 1);
		super.loot(new CensuredResonance(), 1);
		super.loot(new ClockwiseCage(), 1);
		super.loot(new CompoundVitreous(), 2);
		super.loot(new Conduit(), 2);
		super.loot(new CrawlingFortess(), 1);
		super.loot(new CullingGrinder(), 1);
		super.loot(new CurseCoat(),2);
		super.loot(new CursedCilice(),2);
		super.loot(new DailyDose(), 3);
		super.loot(new DeadMansHand(), 3);
		super.loot(new DeathCap(), 3);
		super.loot(new DeploreApp(), 1);
		super.loot(new DreamEater(), 2);
		super.loot(new DrippingFang(), 2);
		super.loot(new EchoShell(), 2);
		super.loot(new EightBall(), 1);
		super.loot(new EmaudelinesPrism(), 1);
		super.loot(new EmaudelinesRaincoat(), 1);
		super.loot(new EmpathyLink(),1);
		super.loot(new EnergySourceExhaust(),1);
		super.loot(new EnergySourceObsolete(),1);
		super.loot(new EnergySourceOvercharge(),1);
		super.loot(new EnergySourceUnethical(),1);
		super.loot(new EnergySourceVolatile(),1);
		super.loot(new EnvenomEarth(), 1);
		super.loot(new EternalIce(), 2);
		super.loot(new FadedSash(), 1);
		super.loot(new FaithlessCloak(), 2);
		super.loot(new FalseFace(), 1);
		super.loot(new FaradayCage(), 2);
		super.loot(new FensClippedWings(), 1);
		super.loot(new FestusClaw(), 2);
		super.loot(new FestusMask(), 2);
		super.loot(new Fishbones(), 1);
		super.loot(new FishbowlHelmet(), 1);
		super.loot(new FracturePlate(), 3);
		super.loot(new GeniusMalignus(), 3);
		super.loot(new GGG(), 2);
		super.loot(new GloveoftheMaker(), 1);
		super.loot(new GomezAmygdala(), 1);
		super.loot(new HandofGlory(), 2);
		super.loot(new HiredHand(), 2);
		super.loot(new HirtzCompass(), 2);
		super.loot(new HiveRhythm(), 1);
		super.loot(new HnHFake(), 1);
		super.loot(new HolyWaterSprinkler(), 2);
		super.loot(new HumanityModule(), 1);
		super.loot(new InfernalRacket(), 2);
		super.loot(new InformantTie(), 2);
		super.loot(new IronSights(), 1);
		super.loot(new KidneyStone(), 2);
		super.loot(new KillSwitch(), 1);
		super.loot(new Kinhunter(), 1);
		super.loot(new LastBreath(), 1);
		super.loot(new LeperKhansBlade(), 3);
		super.loot(new LetterOpener(), 3);
		super.loot(new LoamSkinTalisman(), 1);
		super.loot(new MadnessMantra(), 1);
		super.loot(new Magnum(), 1);
		super.loot(new MangroveTalisman(), 1);
		super.loot(new MidgeProboscis(), 1);
		super.loot(new NewtonCradle(), 1);
		super.loot(new NineLives(), 1);
		super.loot(new OriginCoil(), 1);
		super.loot(new OverloadSpark(), 1);
		super.loot(new PainGate(), 3);
		super.loot(new Paperweight(), 3);
		super.loot(new PelicanPlushToy(), 3);
		super.loot(new PrehistoricSynapse(), 1);
		super.loot(new RainbowScale(),2);
		super.loot(new RatTail(),2);
		super.loot(new RecyclerBolus(),2);
		super.loot(new RingofGyges(), 2);
		super.loot(new RubberReflexMallet(), 3);
		super.loot(new SalvagersHelmet(), 1);
		super.loot(new SalvagersScrapRipper(), 1);
		super.loot(new SalvagersToolbelt(), 1);
		super.loot(new SimmerResent(), 1);
		super.loot(new SimpleMind(), 1);
		super.loot(new SlackerSlacks(), 1);
		super.loot(new SleepytimeSurprise(),2);
		super.loot(new SpeedChute(), 2);
		super.loot(new SportsmanshipAward(),2);
		super.loot(new SpringHeeledJumpers(), 2);
		super.loot(new StatRingAnt(), 3);
		super.loot(new StatRingBeetle(), 3);
		super.loot(new StatRingCricket(), 3);
		super.loot(new StatRingFirefly(), 3);
		super.loot(new StatRingMoth(), 3);
		super.loot(new StatRingRoach(), 3);
		super.loot(new StatRingSpider(), 3);
		super.loot(new StatRingWasp(), 3);
		super.loot(new StickOnGills(), 3);
		super.loot(new SuckerPunch(),2);
		super.loot(new TheTentativelyNamedFiles(),1);
		super.loot(new TommorowmanTalisman(),2);
		super.loot(new TomeofEcdysis(), 1);
		super.loot(new TomeofPermanence(), 1);
		super.loot(new TomeoftheEnd(), 1);
		super.loot(new TomeoftheUnknowable(), 1);
		super.loot(new Torchlight(), 5);
		super.loot(new UsurpersChemSet(),2);
		super.loot(new VoodooPin(), 1);
		super.loot(new ZenBand(), 1);
		super.Timer(this.getId(), 25);
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
