package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class RandomFoodSmall extends Item{

	static int id = 0;
	static String name = "fewd";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 1;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="Some bizarre and randomly generated foodstuffs.";
	static String descrShort="Restores a lot of Hp.";
	public RandomFoodSmall() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		String item1 = "";
		String item2 = "";
		int rand1 = (int)(Math.random()*71);
		switch(rand1){
		case 0:
			item1 = "Agnoletti";
			break;
		case 1:
			item1 = "Basil";
			break;
		case 2:
			item1 = "Chive";
			break;
		case 3:
			item1 = "Nougat";
			break;
		case 4:
			item1 = "Watercress";
			break;
		case 5:
			item1 = "Flan";
			break;
		case 6:
			item1 = "Brill Fish";
			break;
		case 7:
			item1 = "Chestnut";
			break;
		case 8:
			item1 = "Radish";
			break;
		case 9:
			item1 = "Turkey";
			break;
		case 10:
			item1 = "Bison";
			break;
		case 11:
			item1 = "Rabbit";
			break;
		case 12:
			item1 = "Taro";
			break;
		case 13:
			item1 = "Gelatin";
			break;
		case 14:
			item1 = "Shortbread";
			break;
		case 15:
			item1 = "Cucumber";
			break;
		case 16:
			item1 = "Salmon";
			break;
		case 17:
			item1 = "Ramen";
			break;
		case 18:
			item1 = "Quinoa";
			break;
		case 19:
			item1 = "Plantain";
			break;
		case 20:
			item1 = "Pumpkin";
			break;
		case 21:
			item1 = "Anchovy";
			break;
		case 22:
			item1 = "Yogurt";
			break;
		case 23:
			item1 = "Antelope";
			break;
		case 24:
			item1 = "Sturgeon";
			break;
		case 25:
			item1 = "Lotus Root";
			break;
		case 26:
			item1 = "Rutabaga";
			break;
		case 27:
			item1 = "Nagaimo";
			break;
		case 28:
			item1 = "Bamboo";
			break;
		case 29:
			item1 = "Jujube";
			break;
		case 30:
			item1 = "Roe";
			break;
		case 31:
			item1 = "Yam";
			break;
		case 32:
			item1 = "Beefsteak";
			break;
		case 33:
			item1 = "Trout";
			break;
		case 34:
			item1 = "Bass";
			break;
		case 35:
			item1 = "Tuna";
			break;
		case 36:
			item1 = "Swordfish";
			break;
		case 37:
			item1 = "Pork";
			break;
		case 38:
			item1 = "Venison";
			break;
		case 39:
			item1 = "Mutton";
			break;
		case 40:
			item1 = "Shrimp";
			break;
		case 41:
			item1 = "Scallop";
			break;
		case 42:
			item1 = "Quail";
			break;
		case 43:
			item1 = "Eel";
			break;
		case 44:
			item1 = "Bell Pepper";
			break;
		case 45:
			item1 = "Ginseng";
			break;
		case 46:
			item1 = "Tofu";
			break;
		case 47:
			item1 = "Mushroom";
			break;
		case 48:
			item1 = "Seaweed";
			break;
		case 49:
			item1 = "Jellyfish";
			break;
		case 50:
			item1 = "Fugu";
			break;
		case 51:
			item1 = "Veal";
			break;
		case 52:
			item1 = "Cuttlefish";
			break;
		case 53:
			item1 = "Asparagus";
			break;
		case 54:
			item1 = "Cauliflower";
			break;
		case 55:
			item1 = "Broccoli";
			break;
		case 56:
			item1 = "Mango";
			break;
		case 57:
			item1 = "Corn";
			break;
		case 58:
			item1 = "Chickpea";
			break;
		case 59:
			item1 = "Beet";
			break;
		case 60:
			item1 = "Pistachio";
			break;
		case 61:
			item1 = "Cod";
			break;
		case 62:
			item1 = "Duck";
			break;
		case 63:
			item1 = "Chicken";
			break;
		case 64:
			item1 = "Eggplant";
			break;
		case 65:
			item1 = "Liver";
			break;
		case 66:
			item1 = "Pommelo";
			break;
		case 67:
			item1 = "Bycatch";
			break;
		case 68:
			item1 = "Chocolate";
			break;
		case 69:
			item1 = "Spinach";
			break;
		case 70:
			item1 = "Bok Choy";
			break;
			
		}
		int rand2 = (int)(Math.random()*35);
		switch(rand2){
		case 0:
			item2 = " Sandwich";
			break;
		case 1:
			item2 = " Stew";
			break;
		case 2:
			item2 = " Casserole";
			break;
		case 3:
			item2 = " Soup";
			break;
		case 4:
			item2 = " Stir-Fry";
			break;
		case 5:
			item2 = " Salad";
			break;
		case 6:
			item2 = " Pie";
			break;
		case 7:
			item2 = " Jerky";
			break;
		case 8:
			item2 = " Burrito";
			break;
		case 9:
			item2 = " Lump";
			break;
		case 10:
			item2 = " Medallion";
			break;
		case 11:
			item2 = " Flakes";
			break;
		case 12:
			item2 = " Balls";
			break;
		case 13:
			item2 = " Omlette";
			break;
		case 14:
			item2 = " Wrap";
			break;
		case 15:
			item2 = " Bits";
			break;
		case 16:
			item2 = " Strip";
			break;
		case 17:
			item2 = " Pieces";
			break;
		case 18:
			item2 = " Chowder";
			break;
		case 19:
			item2 = " Chili";
			break;
		case 20:
			item2 = " Quiche";
			break;
		case 21:
			item2 = " Pizza";
			break;
		case 22:
			item2 = " Meal";
			break;
		case 23:
			item2 = " Goulash";
			break;
		case 24:
			item2 = " Hash";
			break;
		case 25:
			item2 = " Pottage";
			break;
		case 26:
			item2 = " Stroganoff";
			break;
		case 27:
			item2 = " Platter";
			break;
		case 28:
			item2 = " Roll";
			break;
		case 29:
			item2 = " Pastry";
			break;
		case 30:
			item2 = "-Flavored Ice Cream";
			break;
		case 31:
			item2 = " Pasta";
			break;
		case 32:
			item2 = " Paste";
			break;
		case 33:
			item2 = " Broth";
			break;
		case 34:
			item2 = " Wok";
			break;
		}
		super.setName(item1+item2);
	
	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(75*(1+perp.getItemPow())*(1+vic.getRegenBonus())),perp,vic,6);
		bs.bp.em.bpChange((int)(50*(1+perp.getItemPow())*(1+vic.getRegenBonus())),vic);

	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" eats a "+this.getName()+"!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a "+this.getName()+"!";
		}
	}
	
	
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(75*(1+s.getItemPow())*(1+s.getRegenBonus())));
		s.bpChange((int)(50*(1+s.getItemPow())*(1+s.getRegenBonus())));
		StateManager.states.push(new NotificationState(game, gs, sm, "The meal restores "+s.getName()+"'s Hp and Mp!", 0));
	}
}
