package dev.zt.UpliftedVFFV.Battle;

public class BattleScene {

	public String text;
	public Action a;
	public boolean auto;
	public BattleAnimation ba;
	
	public BattleScene(String t, Action act, Boolean au){
		this.text = t;
		this.a = act;
		this.auto = au;
	}
	
	public BattleScene(String t, BattleAnimation ba, Boolean au){
		this.text = t;
		this.auto = au;
		this.ba = ba;
	}
	
	public BattleScene(String t, Boolean au){
		this.text = t;
		this.auto = au;
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
