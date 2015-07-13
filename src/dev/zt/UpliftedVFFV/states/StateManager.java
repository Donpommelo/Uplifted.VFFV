package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.util.Stack;

import dev.zt.UpliftedVFFV.Game;


//this manages all the states of the game. states are kept in a stack with the state on top being the active one
//This active state is the one that is ticked and rendered. when states are pushed, the states underneath will be paused
public class StateManager {
	
	public static Stack<State> states;
	
	
	public StateManager(Game g){
		states=new Stack<State>();
//		states.push(new TitleState(g, this));
	}
	
	public void tick(){
		states.peek().tick();
	}
	
	public void render(Graphics g){
		states.peek().render(g);
	}
	
	public void init(){
		states.peek().init();
	}

	public static Stack<State> getStates() {
		return states;
	}

	public static void setStates(Stack<State> states) {
		StateManager.states = states;
	}
	
	
}
