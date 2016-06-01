package dev.zt.UpliftedVFFV.display;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class FocusFrame extends JFrame implements WindowListener{
	
	private static final long serialVersionUID = 1L;
	private boolean printStuff = false;
	
	private boolean focus; 
	
	public FocusFrame(String title) {
		super(title);
		focus = true;
		addWindowListener(this);
	}
	
	public boolean isFocused(){
		return focus;
	}


	@Override
	public void windowActivated(WindowEvent e) {
		if(printStuff){
			System.out.println("Window Activated.");
		}
		focus = true;
	}

	@Override
	public void windowClosed(WindowEvent e) {
		if(printStuff){
			System.out.println("Window Closed.");
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(printStuff){
			System.out.println("Window Closing.");
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		if(printStuff){
			System.out.println("Window Deactivated.");
		}
		focus = false;
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		if(printStuff){
			System.out.println("Window Deiconified.");
		}
	}

	@Override
	public void windowIconified(WindowEvent e) {
		if(printStuff){
			System.out.println("Window Iconified.");
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		if(printStuff){
			System.out.println("Window Opened.");
		}
	}
}