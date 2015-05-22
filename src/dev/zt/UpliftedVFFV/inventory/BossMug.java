package dev.zt.UpliftedVFFV.inventory;

public class BossMug extends Item{

	static String descr="A coffee mug belonging to the number one boss. You certainly don¡¦t\nknow anyone in this office who fits that description, so don¡¦t bother\nlooking for its rightful owner.";
	
	public BossMug() {
		super(2, "#1 Boss Mug", false, false, false, false, true, descr);

	}
	
	public void use(Character c){
		
	}

}
