package dev.zt.UpliftedVFFV.inventory;

public class PostageStamp extends Item{

	static String descr="A stamp. Use these to send messages to your Pen Pal.";
	static String descrShort = "Used to send letters to your pen pal.";
	public PostageStamp() {
		super(2, "Postage Stamp",false, false, true, false, descr, descrShort,100,2);

	}
	
	public void use(Character c){
		
	}

}
