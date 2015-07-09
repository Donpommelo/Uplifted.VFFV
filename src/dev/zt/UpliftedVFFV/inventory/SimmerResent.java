package dev.zt.UpliftedVFFV.inventory;

public class SimmerResent extends Item{

	static String descr="Resentment is like swallowing poison and hoping your enemy will\nsuffer; it demonstrates commitment.";
	static String descrShort = "Helps you hold a grudge";
	public SimmerResent() {
		super(2, "Simmering Resentment",false,false,false, false, true, descr, descrShort);

	}
	
	public void use(Character c){
		
	}

}
