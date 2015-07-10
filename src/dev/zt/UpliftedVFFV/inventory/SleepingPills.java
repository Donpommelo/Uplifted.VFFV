package dev.zt.UpliftedVFFV.inventory;

public class SleepingPills extends Item{

	static String descr="You wonder if everyone in the building needs these to sleep, or if its\njust you.";
	static String descrShort = "Helps you sleep at night";
	public SleepingPills() {
		super(2, "Sleeping Pills", false, false, true,false, descr, descrShort,100,2);

	}
	
	public void use(Character c){
		
	}

}
