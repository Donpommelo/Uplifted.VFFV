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


public class DialogState extends State {
	
	private StateManager statemanager;
	private int linenum,endline;
	private Dialog current;
	public int EventId;
	
	public DialogState(Game game, StateManager sm, int start, int end,int eventId){
		super(game,sm);
		this.linenum=start;
		this.endline=end;
		this.EventId=eventId;
	}

	public void tick() {
		
		if(game.getKeyManager().space){
			if(Dialog.scrolling==false){
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(linenum==endline){
					if (current!=null){
						current.charIndex=0;
					}
					statemanager.states.pop();
					if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
						Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
						Event.events[this.EventId].run();
					}
					
					}
				else{
					linenum++;
					
				}
			}
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
			

	public void render(Graphics g) {


		current = Assets.dialog[linenum];
			statemanager.states.pop();
			statemanager.states.peek().render(g);
			statemanager.states.push(this);
			if(current!=null){
				current.render(g);
			}
		
		
		
		
	}

	@Override
	public void init() {
		
	}
	

}
