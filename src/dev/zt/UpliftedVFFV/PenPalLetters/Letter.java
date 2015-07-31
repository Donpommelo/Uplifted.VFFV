package dev.zt.UpliftedVFFV.PenPalLetters;

import java.util.Arrays;

public class Letter {
	
	public static Letter[] letters = new Letter[100];
	public static Letter letter0Test = new Letter0Test(0);
	
	
	
	protected String[] prompts;
	boolean found;
	int id;
	String text = "";
	public Letter(String[] prompts, int id){
		this.id = id;
		this.prompts = prompts;
		this.found = false;
		letters[id] = this;
	}
		
	public static Letter checkPrompt(String prompt){
		for(Letter l : letters){
			if(Arrays.asList(l.prompts).contains(prompt)){
				return l;
			}
		}
		return letter0Test;
	}
	
	public String getLetter(){
		return text;
	}
	
	public boolean isFound(){
		return found;
	}

}
