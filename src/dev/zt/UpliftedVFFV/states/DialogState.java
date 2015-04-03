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
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;


public class DialogState extends State {
	
	private BufferedImage Char;
	private boolean position, complete, dialogscrolling;
	private StateManager statemanager;
	private int linenum,endline;
	private GameState gamestate;
	private Dialog[] chatlog;
	private Dialog current;
	
	public DialogState(Game game, StateManager sm, int start, int end){
		super(game,sm);
		this.linenum=start;
		this.endline=end;
		complete=false;
		dialogscrolling=false;
	}

	public void tick() {
		
/*		if(dialogscrolling==true){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dialogscrolling=false;
		}
	else*/if(game.getKeyManager().space){
			if(Dialog.scrolling==false){
		//		Dialog.charIndex=1;
		//		Dialog.lastIndex=0;
		//		Dialog.currentLine=1;
		//		Dialog.Line1="";Dialog.Line2="";Dialog.Line3="";
		//		dialogscrolling=true;
				if(linenum==endline){
					statemanager.states.pop();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					}
				else{
					linenum++;
				}
			}
			else{
		//		Dialog.charIndex+=5;
					
				}
			
		}	
			
	}
			

	public void render(Graphics g) {
	//	if(complete==true){
	//		System.out.print("meep");
			
			
	//	}
//		else {
		current = Assets.dialog[linenum];
			statemanager.states.pop();
			statemanager.states.peek().render(g);
			statemanager.states.push(this);
			if(current!=null){
				current.render(g);
			}
		
//		}
		
		
		
	}

	@Override
	public void init() {
		
	}
	

}
