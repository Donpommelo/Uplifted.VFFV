package dev.zt.UpliftedVFFV.inventory;

public class MedPak extends Item{

	static String descr="A container of useful medicines. The Infirmary distributes these to\nother floors to avoid having to actually see any of your faces.";
	public MedPak() {
		super(1, "Med-Pak", true, true,descr);

	}
	
	public void use(Character c){
		
	}

}
