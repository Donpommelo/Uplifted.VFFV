package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class BeefUnwell extends Item{

	static String descr="A meaty, beef sandwich. There aren¡¦t any obvious defects with\nit, but it makes you feel nauseated nonetheless.";
	
	public BeefUnwell() {
		super(2, "Beef Unwellington", false, true, true,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic){

	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return vic.getName()+" reluctantly eats the Beef Unwellington.";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return vic.getName()+" looks suitable unwell.";
	}

}
