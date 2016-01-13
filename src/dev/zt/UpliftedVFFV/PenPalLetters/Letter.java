package dev.zt.UpliftedVFFV.PenPalLetters;

import java.util.ArrayList;
import java.util.Arrays;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.misc.PostageStamp;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class Letter {
	
	public static Letter[] letters = new Letter[100];
	public static Letter letter0Test = new Letter0Test(0);
	public static Letter letter1Lachiplatre = new Letter1Lachiplatre(1);

	
	public static ArrayList<Letter> received = new ArrayList<Letter>();
	
	protected String[] prompts;
	boolean found;
	int id;
	String text = "";
	public Letter(String[] prompts, int id, String text){
		this.id = id;
		this.prompts = prompts;
		this.found = false;
		letters[id] = this;
		this.text = text;
	}
		
	public static Letter checkPrompt(String prompt, Game g, StateManager sm, GameState gs){
		for(Letter l : letters){
			if(l != null){
				if(Arrays.asList(l.prompts).contains(prompt)){
					if(!received.contains(l)){
						StateManager.states.push(new NotificationState(g, sm, "The fabric of time changes in strange and unpredictable ways!", 0));
						received.add(l);
						gs.inventorymanager.use(new PostageStamp());
					}
					else{
						StateManager.states.push(new NotificationState(g, sm, "A letter of this topic has already been received!", 0));
					}
					return l;
				}
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

	public void setFound(boolean found){
		this.found = found;
	}

	public String[] getPrompts() {
		return prompts;
	}

	public void setPrompts(String[] prompts) {
		this.prompts = prompts;
	}
	
	
}
