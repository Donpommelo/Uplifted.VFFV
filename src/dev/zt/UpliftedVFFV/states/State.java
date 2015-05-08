package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Game;


public abstract class State {
	
//	private static State currentState = null;
	StateManager statemanager;
	
	
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
	
}
