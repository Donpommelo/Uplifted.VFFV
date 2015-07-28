package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.io.Serializable;

import dev.zt.UpliftedVFFV.Game;


public abstract class State implements Serializable{
	
//	private static State currentState = null;
	StateManager statemanager;
	
	private static final long serialVersionUID = 8L;
	
	private String stateType;
	
/*	public static void setState(State state){
		currentState=state;
	}
	
	public static State getState(){
		return currentState;
	}
	*/
	protected Game game;
	
	public State(Game game,StateManager sm){
		this.game = game;
		this.statemanager=sm;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void init();

	public Object getPartymanager() {

		return null;
	}
	
	public String getType(){
		return getStateType();
	}

	public String getStateType() {
		if(stateType != null){
			return stateType;
		} else{
			return "undefined";
		}
	}

	public void setStateType(String stateType) {
		this.stateType = stateType;
	}
	
}
