package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class LetterOpener extends Item{

	static String descr="An ornate knife almost threatening enough to be confiscated at an\nairport.";
	public LetterOpener() {
		super(3, "Letter Opener",false,false,false, false, true, descr);

	}
	
	public void use(Character c){
		
	}
	
	public void equipEffect(Schmuck s){
		s.buffedStats[5]+=3;
		s.buffedStats[4]+=3;
	}

}
