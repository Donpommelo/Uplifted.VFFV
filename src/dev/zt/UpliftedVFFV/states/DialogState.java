package dev.zt.UpliftedVFFV.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.concurrent.TimeUnit;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//DialogState. This controls which dialog is displayed
public class DialogState extends State {
	
	private StateManager statemanager;
	private int linenum,endline;
	private Dialog current;
	public int EventId;
	
	//Dialogstates require 2 ints when called; the first and last lines of dialog needed
	public DialogState(Game game, StateManager sm, int start, int end,int eventId){
		super(game,sm);
		this.linenum=start;
		this.endline=end;
		this.EventId=eventId;
	}

	public void tick() {
		
		//if space is pressed and the dialog is done scrolling, the next dialog will begin displaying if there is one
		if(game.getKeyManager().space){
			if(Dialog.scrolling==false){
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
				//if the last line is shown, the dialogstate ends
				if(linenum==endline){
					if (current!=null){					//This sets the charIndex at 0 so rereading dialog will still scroll
						current.charIndex=0;			
					}
					statemanager.states.pop();
					
					//This is used for multistage event processing. If there are multiple stages in the event being run, the stage will
					//increment and the event will be rerrun with the new stage.
					if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
						Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
						Event.events[this.EventId].run();
					}
					
					}	
				
				//if there is still dialog, pressing space will move on to the next dialog line
				else{
					linenum++;
					
				}
			}
			
			//if pressing space before the dialog is done scrolling, the text will speed up.
			else{
				if(current!=null){
					current.charIndex+=10;
				}
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			
		}	
			
	}
			
	//rendering the DialogState consists of rendering whatever the current dialog is.
	//Also, because dialog does not take up the whole screen, the state underneath it must be rendered first
	public void render(Graphics g) {


		current = Assets.dialog[linenum];
			statemanager.states.pop();
			statemanager.states.peek().render(g);
			statemanager.states.push(this);
			if(current!=null){
				current.render(g);
			}
			
		if(Dialog.scrolling==false){
			g.drawImage(Assets.Downarrow, 315, 410, null);
		}
		
		
		
		
	}

	@Override
	public void init() {
		
	}
	

}
