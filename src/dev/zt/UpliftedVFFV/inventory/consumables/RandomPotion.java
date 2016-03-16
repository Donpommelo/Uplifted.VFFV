package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.*;
import dev.zt.UpliftedVFFV.statusEffects.Stats.*;

public class RandomPotion extends Item{

	static int id = 2;
	static String name = "pohshun";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 1;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A flask of mysterious liquid.";
	static String descrShort="Does something strange.";
	static int effect;
	String[] possibilities;
	public RandomPotion() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		String item1 = "";
		String item2 = "";
		int rand1 = (int)(Math.random()*53);
		switch(rand1){
		case 0:
			item1 = "Bubbling";
			break;
		case 1:
			item1 = "Frothing";
			break;
		case 2:
			item1 = "Seething";
			break;
		case 3:
			item1 = "Churning";
			break;
		case 4:
			item1 = "Foaming";
			break;
		case 5:
			item1 = "Smoking";
			break;
		case 6:
			item1 = "Cloudy";
			break;
		case 7:
			item1 = "Clear";
			break;
		case 8:
			item1 = "Translucent";
			break;
		case 9:
			item1 = "Limpid";
			break;
		case 10:
			item1 = "Pellucid";
			break;
		case 11:
			item1 = "Glassy";
			break;
		case 12:
			item1 = "Frosted";
			break;
		case 13:
			item1 = "Murky";
			break;
		case 14:
			item1 = "Milky";
			break;
		case 15:
			item1 = "Turbid";
			break;
		case 16:
			item1 = "Sparkling";
			break;
		case 17:
			item1 = "Glistening";
			break;
		case 18:
			item1 = "Fizzy";
			break;
		case 19:
			item1 = "Effervescent";
			break;
		case 20:
			item1 = "Metallic";
			break;
		case 21:
			item1 = "Lukewarm";
			break;
		case 22:
			item1 = "Tepid";
			break;
		case 23:
			item1 = "Simmering";
			break;
		case 24:
			item1 = "Squirming";
			break;
		case 25:
			item1 = "Shadowy";
			break;
		case 26:
			item1 = "Inchoate";
			break;
		case 27:
			item1 = "Vitreous";
			break;
		case 28:
			item1 = "Misty";
			break;
		case 29:
			item1 = "Hazy";
			break;
		case 30:
			item1 = "Mysterious";
			break;
		case 31:
			item1 = "Blurry";
			break;
		case 32:
			item1 = "Runny";
			break;
		case 33:
			item1 = "Swirly";
			break;
		case 34:
			item1 = "Arcane";
			break;
		case 35:
			item1 = "Impure";
			break;
		case 36:
			item1 = "Purified";
			break;
		case 37:
			item1 = "Pasteurized";
			break;
		case 38:
			item1 = "Dilute";
			break;
		case 39:
			item1 = "Concentrated";
			break;
		case 40:
			item1 = "Steamy";
			break;
		case 41:
			item1 = "Viscous";
			break;
		case 42:
			item1 = "Oily";
			break;
		case 43:
			item1 = "Syrupy";
			break;
		case 44:
			item1 = "Pale";
			break;
		case 45:
			item1 = "Shiny";
			break;
		case 46:
			item1 = "Luminous";
			break;
		case 47:
			item1 = "Gleeming";
			break;
		case 48:
			item1 = "Twitching";
			break;
		case 49:
			item1 = "Aged";
			break;
		case 50:
			item1 = "Ancient";
			break;
		case 51:
			item1 = "Dusty";
			break;
		case 52:
			item1 = "Stagnant";
			break;
			
		}
		int rand2 = (int)(Math.random()*97);
		switch(rand2){
		case 0:
			item2 = " Amaranth";
			break;
		case 1:
			item2 = " Amethyst";
			break;
		case 2:
			item2 = " Aquamarine";
			break;
		case 3:
			item2 = " Auburn";
			break;
		case 4:
			item2 = " Aureolin";
			break;
		case 5:
			item2 = " Azure";
			break;
		case 6:
			item2 = " Beige";
			break;
		case 7:
			item2 = " Black";
			break;
		case 8:
			item2 = " Burgundy";
			break;
		case 9:
			item2 = " Carmine";
			break;
		case 10:
			item2 = " Carnelian";
			break;
		case 11:
			item2 = " Catawba";
			break;
		case 12:
			item2 = " Celadon";
			break;
		case 13:
			item2 = " Celeste";
			break;
		case 14:
			item2 = " Cerulean";
			break;
		case 15:
			item2 = " Chartreuse";
			break;
		case 16:
			item2 = " Cinereous";
			break;
		case 17:
			item2 = " Cinnabar";
			break;
		case 18:
			item2 = " Citrine";
			break;
		case 19:
			item2 = " Coquelicot";
			break;
		case 20:
			item2 = " Coral";
			break;
		case 21:
			item2 = " Cordovan";
			break;
		case 22:
			item2 = " Crimson";
			break;
		case 23:
			item2 = " Cyan";
			break;
		case 24:
			item2 = " Cyclamen";
			break;
		case 25:
			item2 = " Ebony";
			break;
		case 26:
			item2 = " Ecru";
			break;
		case 27:
			item2 = " Emerald";
			break;
		case 28:
			item2 = " Feldspar";
			break;
		case 29:
			item2 = " Flavescent";
			break;
		case 30:
			item2 = " Fuchsia";
			break;
		case 31:
			item2 = " Fulvous";
			break;
		case 32:
			item2 = " Gold";
			break;
		case 33:
			item2 = " Granite";
			break;
		case 34:
			item2 = " Grey";
			break;
		case 35:
			item2 = " Harlequin";
			break;
		case 36:
			item2 = " Heliotrope";
			break;
		case 37:
			item2 = " Icterine";
			break;
		case 38:
			item2 = " Imperial";
			break;
		case 39:
			item2 = " Indigo";
			break;
		case 40:
			item2 = " Ivory";
			break;
		case 41:
			item2 = " Jade";
			break;
		case 42:
			item2 = " Jasmine";
			break;
		case 43:
			item2 = " Jasper";
			break;
		case 44:
			item2 = " Keppel";
			break;
		case 45:
			item2 = " Jonquil";
			break;
		case 46:
			item2 = " Lavender";
			break;
		case 47:
			item2 = " Lilac";
			break;
		case 48:
			item2 = " Magenta";
			break;
		case 49:
			item2 = " Mahogany";
			break;
		case 50:
			item2 = " Malachite";
			break;
		case 51:
			item2 = " Marigold";
			break;
		case 52:
			item2 = " Maroon";
			break;
		case 53:
			item2 = " Mauve";
			break;
		case 54:
			item2 = " Midnight";
			break;
		case 55:
			item2 = " Moonstone";
			break;
		case 56:
			item2 = " Mulberry";
			break;
		case 57:
			item2 = " Navy";
			break;
		case 58:
			item2 = " Neon";
			break;
		case 59:
			item2 = " Ochre";
			break;
		case 60:
			item2 = " Olivine";
			break;
		case 61:
			item2 = " Onyx";
			break;
		case 62:
			item2 = " Orange";
			break;
		case 63:
			item2 = " Orchid";
			break;
		case 64:
			item2 = " Peridot";
			break;
		case 65:
			item2 = " Periwinkle";
			break;
		case 66:
			item2 = " Phthalo";
			break;
		case 67:
			item2 = " Pink";
			break;
		case 68:
			item2 = " Platinum";
			break;
		case 69:
			item2 = " Puce";
			break;
		case 70:
			item2 = " Quartz";
			break;
		case 71:
			item2 = " Rose";
			break;
		case 72:
			item2 = " Ruby";
			break;
		case 73:
			item2 = " Rufous";
			break;
		case 74:
			item2 = " Russet";
			break;
		case 75:
			item2 = " Saffron";
			break;
		case 76:
			item2 = " Sage";
			break;
		case 77:
			item2 = " Sapphire";
			break;
		case 78:
			item2 = " Scarlet";
			break;
		case 79:
			item2 = " Sepia";
			break;
		case 80:
			item2 = " Sienna";
			break;
		case 81:
			item2 = " Silver";
			break;
		case 82:
			item2 = " Sinopia";
			break;
		case 83:
			item2 = " Smalt";
			break;
		case 84:
			item2 = " Taupe";
			break;
		case 85:
			item2 = " Teal";
			break;
		case 86:
			item2 = " Topaz";
			break;
		case 87:
			item2 = " Turqoise";
			break;
		case 88:
			item2 = " Umber";
			break;
		case 89:
			item2 = " Verdigris";
			break;
		case 90:
			item2 = " Vermilion";
			break;
		case 91:
			item2 = " Violet";
			break;
		case 92:
			item2 = " Viridian";
			break;
		case 93:
			item2 = " Wisteria";
			break;
		case 94:
			item2 = " Zaffe";
			break;
		case 95:
			item2 = " Hooloovoo";
			break;
		case 96:
			item2 = " Octarine";
			break;			
		}
		super.setName(item1+item2+" Potion");
		
		this.possibilities = new String[3];
		
		for(int i = 0; i < 3; i++){
			int effect = (int)(Math.random()*58);
			switch(effect){
			case 0:
				possibilities[i] = "Regeneration";
				break;
			case 1:
				possibilities[i] = "Inspiration";
				break;
			case 2:
				possibilities[i] = "Exsanguination";
				break;
			case 3:
				possibilities[i] = "Domination";
				break;
			case 4:
				possibilities[i] = "Fortification";
				break;
			case 5:
				possibilities[i] = "Immediacy";
				break;
			case 6:
				possibilities[i] = "Competance";
				break;
			case 7:
				possibilities[i] = "Fortune";
				break;
			case 8:
				possibilities[i] = "Lucidity";
				break;
			case 9:
				possibilities[i] = "Impotence";
				break;
			case 10:
				possibilities[i] = "Fraility";
				break;
			case 11:
				possibilities[i] = "Sloth";
				break;
			case 12:
				possibilities[i] = "Buffoonery";
				break;
			case 13:
				possibilities[i] = "Misfortune";
				break;
			case 14:
				possibilities[i] = "Idiocy";
				break;
			case 15:
				possibilities[i] = "Precision";
				break;
			case 16:
				possibilities[i] = "Dodginess";
				break;
			case 17:
				possibilities[i] = "Dynamism";
				break;
			case 18:
				possibilities[i] = "Punctuality";
				break;
			case 19:
				possibilities[i] = "Variance";
				break;
			case 20:
				possibilities[i] = "Efficiency";
				break;
			case 21:
				possibilities[i] = "Resistances";
				break;
			case 22:
				possibilities[i] = "Corrosion";
				break;
			case 23:
				possibilities[i] = "Vulnerability";
				break;
			case 24:
				possibilities[i] = "Experience";
				break;
			case 25:
				possibilities[i] = "Enrichment";
				break;
			case 26:
				possibilities[i] = "Hibernation";
				break;
			case 27:
				possibilities[i] = "Infancy";
				break;
			case 28:
				possibilities[i] = "Beefyness";
				break;
			case 29:
				possibilities[i] = "Rage";
				break;
			case 30:
				possibilities[i] = "Combustibility";
				break;
			case 31:
				possibilities[i] = "Proliferation";
				break;
			case 32:
				possibilities[i] = "Reflection";
				break;
			case 33:
				possibilities[i] = "Palatability";
				break;
			case 34:
				possibilities[i] = "Pacifism";
				break;
			case 35:
				possibilities[i] = "Terror";
				break;
			case 36:
				possibilities[i] = "Frost";
				break;
			case 37:
				possibilities[i] = "Stagnation";
				break;
			case 38:
				possibilities[i] = "Impatience";
				break;
			case 39:
				possibilities[i] = "Intimidation";
				break;
			case 40:
				possibilities[i] = "Invisibility";
				break;
			case 41:
				possibilities[i] = "Invulnerability";
				break;
			case 42:
				possibilities[i] = "Isolation";
				break;
			case 43:
				possibilities[i] = "Insolvency";
				break;
			case 44:
				possibilities[i] = "Masochism";
				break;
			case 45:
				possibilities[i] = "Misalignment";
				break;
			case 46:
				possibilities[i] = "Momentum";
				break;
			case 47:
				possibilities[i] = "Negativity";
				break;
			case 48:
				possibilities[i] = "Palsy";
				break;
			case 49:
				possibilities[i] = "Toxicity";
				break;
			case 50:
				possibilities[i] = "Purification";
				break;
			case 51:
				possibilities[i] = "Inaudibility";
				break;
			case 52:
				possibilities[i] = "Stupefication";
				break;
			case 53:
				possibilities[i] = "Vision";
				break;
			case 54:
				possibilities[i] = "Unresistance";
				break;
			case 55:
				possibilities[i] = "Vampirism";
				break;
			case 56:
				possibilities[i] = "Volatility";
				break;
			case 57:
				possibilities[i] = "Cowardice";
				break;			
			}
		}
		super.setDescrShort("Your intuition considers:\n"+possibilities[0]+"\n"+possibilities[1]+"\n"+possibilities[2]);
		
	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		int rand1 = (int)(Math.random()*3);
		String effect = possibilities[rand1];
		bs.bp.bt.addScene(this.getName()+" of "+possibilities[rand1]+"!");
		switch(effect){
		case "Regeneration":
			bs.bp.em.hpChange(75, perp, vic, 6);
			break;
		case "Inspiration":
			bs.bp.em.bpChange(75, vic);
			break;
		case "Exsanguination":
			bs.bp.em.hpChange(-75, perp, vic, 6);
			break;
		case "Domination":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 2, 1.5, perp, vic,50));
			break;
		case "Fortification":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 3, 1.5, perp, vic,50));
			break;
		case "Immediacy":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 4, 1.5, perp, vic,50));
			break;
		case "Competance":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 5, 1.5, perp, vic,50));
			break;
		case "Fortune":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 7, 1.5, perp, vic,50));
			break;
		case "Lucidity":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 6, 1.5, perp, vic,50));
			break;
		case "Impotence":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 2, 0.5, perp, vic,50));
			break;
		case "Fraility":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 3, 0.5, perp, vic,50));
			break;
		case "Sloth":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 4, 0.5, perp, vic,50));
			break;
		case "Buffoonery":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 5, 0.5, perp, vic,50));
			break;
		case "Misfortune":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 7, 0.5, perp, vic,50));
			break;
		case "Idiocy":
			bs.bp.stm.addStatus(vic, new StatBuffMult(3, 6, 0.5, perp, vic,50));
			break;
		case "Precision":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 0, 0.5, perp, vic,50));
			break;
		case "Dodginess":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 1, 0.5, perp, vic,50));
			break;
		case "Dynamism":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 16, 0.5, perp, vic,50));
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 17, 0.5, perp, vic,50));
			break;
		case "Punctuality":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 14, 0.5, perp, vic,50));
			break;
		case "Variance":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 15, 0.5, perp, vic,50));
			break;
		case "Efficiency":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 13, 0.5, perp, vic,50));
			break;
		case "Resistances":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 19, 0.25, perp, vic,50));
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 20, 0.25, perp, vic,50));
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 21, 0.25, perp, vic,50));
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 22, 0.25, perp, vic,50));
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 23, 0.25, perp, vic,50));
			break;
		case "Corrosion":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 10, -0.5, perp, vic,50));
			break;
		case "Vulnerability":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 28, -0.5, perp, vic,50));
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 32, -0.5, perp, vic,50));
			break;
		case "Experience":
			bs.bp.bt.addScene(vic.getName()+" gains 30 Exp!");
			vic.expGain(30);
			break;
		case "Enrichment":
			bs.bp.bt.addScene("30 Script gained!");
			bs.gs.scriptChange(30);
			break;
		case "Dormancy":
			bs.bp.stm.addStatus(vic, new Asleep(3,perp,vic,50));
			break;
		case "Infancy":
			bs.bp.stm.addStatus(vic, new BaselineStats(3,perp,vic,5));
			break;
		case "Beefyness":
			bs.bp.stm.addStatus(vic, new BeefedUp(3,perp,vic,50));
			break;
		case "Rage":
			bs.bp.stm.addStatus(vic, new Berzerk(3,perp,vic,50));
			break;
		case "Combustibility":
			bs.bp.stm.addStatus(vic, new Combustibility(3,perp,vic,50));
			break;
		case "Proliferation":
			bs.bp.stm.addStatus(vic, new Contagious(3,perp,vic,50));
			break;
		case "Reflection":
			bs.bp.stm.addStatus(vic, new DamageReflect(3, 0.5, perp,vic,50));
			break;
		case "Palatability":
			bs.bp.stm.addStatus(vic, new Delicious(3, 0.5, perp,vic,50));
			break;
		case "Pacifism":
			bs.bp.stm.addStatus(vic, new Disarmed(3,perp,vic,50));
			break;
		case "Terror":
			bs.bp.stm.addStatus(vic, new Fear(3,perp, perp,vic,50));
			break;
		case "Frost":
			bs.bp.stm.addStatus(vic, new Frozen(3,perp,vic,50));
			break;
		case "Stagnation":
			bs.bp.stm.addStatus(vic, new HealBlock(3,perp,vic,50));
			bs.bp.stm.addStatus(vic, new MeterBlock(3,perp,vic,50));
			break;
		case "Impatience":
			bs.bp.stm.addStatus(vic, new Impatient(3,perp,vic,50));
			break;
		case "Intimidation":
			bs.bp.stm.addStatus(vic, new Intimidated(3, 0.5, perp, vic,50));
			break;
		case "Invisibility":
			bs.bp.stm.addStatus(vic, new Invisible(3, perp, vic,50));
			break;
		case "Invulnerability":
			bs.bp.stm.addStatus(vic, new Invuln(3, perp, vic,100));
			break;
		case "Isolation":
			bs.bp.stm.addStatus(vic, new Isolated(3, perp, vic,100));
			break;
		case "Insolvency":
			bs.bp.stm.addStatus(vic, new Insolvent(3, perp, vic,100));
			break;
		case "Masochism":
			bs.bp.stm.addStatus(vic, new Masochist(3, 0.5, perp, vic,100));
			break;
		case "Misalignment":
			bs.bp.stm.addStatus(vic, new Misaligned(3, perp, vic,100));
			break;
		case "Momentum":
			bs.bp.stm.addStatus(vic, new Momentum(3, perp, vic,100));
			bs.bp.bt.addScene(vic.getName()+" gained Momentum!");
			break;
		case "Negativity":
			bs.bp.stm.addStatus(vic, new Negative(3, perp, vic,100));
			break;
		case "Palsy":
			bs.bp.stm.addStatus(vic, new Paralysis(3, perp, vic,100));
			break;
		case "Toxicity":
			bs.bp.stm.addStatus(vic, new Poisoned(3, perp, vic,100));
			break;
		case "Purification":
			bs.bp.stm.addStatus(vic, new Purified(3, perp, vic,100));
			break;
		case "Inaudibility":
			bs.bp.stm.addStatus(vic, new Silenced(3, perp, vic,100));
			break;
		case "Stupefication":
			bs.bp.stm.addStatus(vic, new Stunned(3, perp, vic,100));
			break;
		case "Vision":
			bs.bp.stm.addStatus(vic, new TrueSight(3, perp, vic,100));
			break;
		case "Unresistance":
			bs.bp.stm.addStatus(vic, new Unresistant(3, perp, vic,100));
			break;
		case "Vampirism":
			bs.bp.stm.addStatus(vic, new Vampirism(3, 0.5, perp, vic,100));
			break;
		case "Volatility":
			bs.bp.stm.addStatus(vic, new Volatile(3, perp, vic,100));
			break;
		case "Cowardice":
			bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 25, 0.5, perp, vic,50));
			break;
		}
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" uses a mysterious potion!";
	}
	
}
