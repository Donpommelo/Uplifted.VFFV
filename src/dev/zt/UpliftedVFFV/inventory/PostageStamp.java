package dev.zt.UpliftedVFFV.inventory;

public class PostageStamp extends Item{

	static String descr="A stamp. Use these to send messages to your Pen Pal.";
	public PostageStamp() {
		super(2, "Postage Stamp",false, false, true, descr);

	}
	
	public void use(Character c){
		
	}

}
