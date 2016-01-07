package dev.zt.UpliftedVFFV.Battle;

public class BattleScene {

	public String text;
	public Action a;
	
	public BattleScene(String t, Action act){
		this.text = t;
		this.a = act;
	}
	
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

	
}
