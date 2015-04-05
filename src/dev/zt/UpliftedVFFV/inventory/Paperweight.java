package dev.zt.UpliftedVFFV.inventory;

public class Paperweight extends Item{

	static String descr="This is a solid metal paperweight. It weighs down stacks of paperwork\nthat, consequently, weigh down your hopes and dreams.";
	public Paperweight() {
		super(4, "Paperweight", true, true,descr);

	}
	
	public void use(Character c){
		
	}

}
