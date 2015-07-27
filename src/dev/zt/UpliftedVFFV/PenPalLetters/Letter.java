package dev.zt.UpliftedVFFV.PenPalLetters;

import java.util.Arrays;

public class Letter {
	
	public static Letter[] letters = new Letter[100];
	
	
	
	
	protected String[] prompts;
	boolean found;
	int id;
	String text;
	public Letter(String[] prompts, int id){
		this.id = id;
		this.prompts = prompts;
		this.found = false;
		letters[id] = this;
	}
	
	
	
	public void checkPrompt(String prompt){
		if(Arrays.asList(prompts).contains(prompt)){
			
		}
	}

}
