package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Paperweight extends Item{

	static String descr="This is a solid metal paperweight. It weighs down stacks of paperwork\nthat, consequently, weigh down your hopes and dreams.";
	public Paperweight() {
		super(4, "Paperweight",false,false,false,false, true, descr);

	}
	
	public void use(Character c){
		
	}
	
	public void equipEffect(Schmuck s){
		s.buffedStats[3]+=5;
	}

}
