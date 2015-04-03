package dev.zt.UpliftedVFFV.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right, space, z,x;
	public boolean held;
	
	public KeyManager(){
		keys = new boolean[256];
		held=false;
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
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

}
