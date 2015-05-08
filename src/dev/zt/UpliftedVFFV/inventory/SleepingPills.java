package dev.zt.UpliftedVFFV.inventory;

public class SleepingPills extends Item{

	static String descr="You wonder if everyone in the building needs these to sleep, or if its\njust you.";
	public SleepingPills() {
		super(2, "Sleeping Pills", false, false, true,descr);

	}
	
	public void use(Character c){
		
	}

}
