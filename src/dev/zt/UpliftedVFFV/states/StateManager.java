package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.util.Stack;

import dev.zt.UpliftedVFFV.Game;

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
}
