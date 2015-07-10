package dev.zt.UpliftedVFFV.inventory;

public class ZDrug extends Item{

	static String descr="A potent sleeping aid for when the constant grinding noise of the\nelevators keeps you up at night.";
	static String descrShort = "Helps you sleep at night.";
	public ZDrug() {
		super(2, "Z-Drug",false, false, true, false, descr, descrShort,150,2);

	}
	
	public void use(Character c){
		
	}

}
