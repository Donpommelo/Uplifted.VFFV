package dev.zt.UpliftedVFFV.Battle;

import dev.zt.UpliftedVFFV.states.BattleState;

public class BattleScene {

	//A Battle Scene is the the thing that Battle Text displays.
	//They contain a Line of text and/or an animation 
	
	//text: text being displayed
	public String text;
	
	//a is the Battle Scene's Action if it corresponds to one
	public Action a;
	
	//Whether the Scene automaticall moves to the next.
	//Later, give option to decide the amount of time manually.
	public boolean auto;
	
	//The animation if there is one.
	public BattleAnimation ba;
	public BattleState bs;
	//Most Battle Scenes right now are just a line of text that scrolls automaticall.
	public BattleScene(String t, Action act, Boolean au, BattleState bs){
		this.text = t;
		this.a = act;
		this.auto = au;
		this.bs = bs;
	}
	
	public BattleScene(String t, BattleAnimation ba, Boolean au, BattleState bs){
		this.text = t;
		this.auto = au;
		this.ba = ba;
		this.bs = bs;
	}
	
	public BattleScene(String t, Boolean au, BattleState bs){
		this.text = t;
		this.auto = au;
		this.bs = bs;
	}
	
	
	//Getters and Setters
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Action getA() {
		return a;
	}

	public void setA(Action a) {
		this.a = a;
	}
	
	public BattleAnimation getBa() {
		return ba;
	}

	public void setBa(BattleAnimation ba) {
		this.ba = ba;
	}

	public boolean isAuto() {
		return auto;
	}

	public void setAuto(boolean auto) {
		this.auto = auto;
	}
	
}
