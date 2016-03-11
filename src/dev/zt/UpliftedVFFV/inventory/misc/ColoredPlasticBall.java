package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ColoredPlasticBall extends Item{
	
	static int id = 2;
	static String name = "OVERRIDE";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="OVERRIDE";
	static String descrShort="OVERRIDE";
	public int red,blue,yellow;
	public ColoredPlasticBall(int red, int blue, int yellow) {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		int color = 0;
		color += (red + 3*blue + 9*yellow);
//		System.out.print(color);
		this.setCharges(color);
		this.red = red;
		this.blue = blue;
		this.yellow = yellow;
		String thisname = "Grey Plastic Ball";
		switch(this.getCharges()){
		case 1:
			thisname = "Red Plastic Ball";
			break;
		case 3:
			thisname = "Blue Plastic Ball";
			break;
		case 4:
			thisname = "Purple Plastic Ball";
			break;
		case 5:
			thisname = "Magenta Plastic Ball";
			break;
		case 7:
			thisname = "Violet Plastic Ball";
			break;
		case 9:
			thisname = "Yellow Plastic Ball";
			break;
		case 10:
			thisname = "Orange Plastic Ball";
			break;
		case 11:
			thisname = "Vermillion Plastic Ball";
			break;
		case 12:
			thisname = "Green Plastic Ball";
			break;
		case 14:
			thisname = "Russet Plastic Ball";
			break;
		case 15:
			thisname = "Teal Plastic Ball";
			break;
		case 16:
			thisname = "Slate Plastic Ball";
			break;
		case 19:
			thisname = "Amber Plastic Ball";
			break;
		case 21:
			thisname = "Chartreuse Plastic Ball";
			break;
		case 22:
			thisname = "Citron Plastic Ball";
			break;
		}
		this.setName(thisname);
	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(-10*red, perp, vic, 0);
		bs.bp.em.hpChange(-10*blue, perp, vic, 1);
		bs.bp.em.hpChange(-10*yellow, perp, vic, 3);

	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
