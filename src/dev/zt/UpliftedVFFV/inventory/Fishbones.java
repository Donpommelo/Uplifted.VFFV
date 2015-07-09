package dev.zt.UpliftedVFFV.inventory;

public class Fishbones extends Item{

	static String descr="The dried remains of an ancient fish. Its probably a symbol of thanks\nin whatever country Svente emigrated from.";
	static String descrShort = "temp";
	public Fishbones() {
		super(2, "Fish Bones", false, false, false, false, true, descr, descrShort);

	}
	
	public void use(Character c){
		
	}

}
