package dev.zt.UpliftedVFFV.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.zt.UpliftedVFFV.Game;

public class KeyManager implements KeyListener {  //takes keyboard input.
	
	private boolean[] keys;
	public boolean up, down, left, right, space, z,x,enter; //whether this button is currently being pressed
	public String keyTyped;
	public boolean typing;
	public int lastPressed;
	//Boolean and counter for built in button delay, and window minimization, and loss of control during cutscenes.
	private boolean active;
	private boolean keyFocus;
	private double counter;
	private double duration;

	private double holdCounter;
	
	public static boolean cutsceneMode = false;
	
	public boolean printStuff = false;
	
	public Game game;
	
	public KeyManager(Game g){
		keys = new boolean[256];
		lastPressed = -1;
		active = true;
		counter = 0;
		duration = 0;

		holdCounter = 0;
		
		typing = false;
		keyTyped = "";
		
		this.game = g;
	}
	
	public void tick(){						//add keys here. Change wasd to arrow keys later when done testing.
			up = keys[KeyEvent.VK_UP];
			down = keys[KeyEvent.VK_DOWN];
			left = keys[KeyEvent.VK_LEFT];
			right = keys[KeyEvent.VK_RIGHT];
			space = keys[KeyEvent.VK_SPACE];
			enter = keys[KeyEvent.VK_ENTER];
			z = keys[KeyEvent.VK_Z];
			x = keys[KeyEvent.VK_X];
			if(!active){
				if(System.currentTimeMillis() - counter >= duration){
					active = true;
//					if(printStuff){
//						System.out.println("Enabled");
//					}
//					if(printStuff){
//						System.out.println("Duration: " + duration);
//					}
				}
			}
			if(printStuff){
//				System.out.println("FOCUS: " + keyFocus);
			}
			
	}
	
	
	public void keyPressed(KeyEvent ev) {
		if(typing){
			keyTyped = KeyEvent.getKeyText(ev.getKeyCode());
			
		}
		else{
			keys[ev.getKeyCode()] = true;
			holdCounter++;
		}
	
	}

	public void keyReleased(KeyEvent ev) {
		if(typing){
			keyTyped = "";
		}
		else{
			keys[ev.getKeyCode()] = false;
			holdCounter = 0;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	public static boolean isCutsceneMode() {
		return cutsceneMode;
	}

	public static void setCutsceneMode(boolean cutsceneMode) {
		KeyManager.cutsceneMode = cutsceneMode;
	}
	
	public void disable(int disableDuration){
		if(active){
			if(printStuff){
				System.out.println("Disabled " + disableDuration);
			}
			counter = System.currentTimeMillis();
			duration = disableDuration;
			if(holdCounter > 5){
				duration = duration / 2;
			}
			active = false;
		}
	}
	
	public void setFocus(boolean focus){
		keyFocus = focus;
		if(keyFocus == false){
			loseFocus();
		}
	}
	
	public void loseFocus(){
		for(int i = 0; i < keys.length; i++){
			keys[i] = false;
		}
//		if(printStuff){
//			System.out.println("Focus Lost");
//		}
	}
	
	public boolean isActive() {
		return active;
	}

	
	

}
