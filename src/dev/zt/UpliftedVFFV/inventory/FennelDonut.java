package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class FennelDonut extends Item{

	static String descr="Mick always had the worst taste in donuts.";
	public FennelDonut() {
		super(2, "Fennel Off-Gazpacho Donut", true,true,true,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic){
		vic.hpChange(20);
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return vic.getName()+" eats the donut.";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "20 Hp was restored.";
	}

}
