package dev.zt.UpliftedVFFV.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Display {				//everything shows up here. consists of a canvas where stuff is drawn and a frame where the canvas is drawn

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title=title;
		this.width=width;
		this.height=height;
		
		createDisplay();
	}

	private void createDisplay() {
		frame=new JFrame(title);								//controls name displayed in top left corner	
		frame.setSize(width, height);							//controls size of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//makes frame exit when x-ed out
		frame.setResizable(false);								//makes frame size permanent
		frame.setLocationRelativeTo(null);						
		frame.setVisible(true);									//makes frame visible
		
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	
	
}
