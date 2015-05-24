package dev.zt.UpliftedVFFV.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {  //takes keyboard input.
	
	private boolean[] keys;
	public boolean up, down, left, right, space, z,x,enter; //whether this button is currently being pressed
	public boolean held;
	public static boolean cutsceneMode = false;
	
	public KeyManager(){
		keys = new boolean[256];
		held=false;
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
	}

	public void keyPressed(KeyEvent ev) {
		keys[ev.getKeyCode()] = true;
		
	}

	public void keyReleased(KeyEvent ev) {
		keys[ev.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public static boolean isCutsceneMode() {
		return cutsceneMode;
	}

	public static void setCutsceneMode(boolean cutsceneMode) {
		KeyManager.cutsceneMode = cutsceneMode;
	}
	
	
	

}
