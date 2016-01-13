package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//State for when the player must choose an option from a list of any size
public class ChoiceBranchState extends State {
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage window;
	public int EventId;
	public String[] num;
	public int currentchoice, choicelocation,firstchoice, boxsize, width;
	public boolean selected,exit;
	
	//KeyListener delay variables.
	private int delayCursor = 120;
	private int delaySelection = 200;
		
	public ChoiceBranchState(Game game, StateManager sm, int eventId,String[] choices){
		super(game,sm);
		setStateType("choice");
		this.EventId=eventId;
		this.num=choices;
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		currentchoice=0;				//which item is selected
		choicelocation=0;				//where does the item show up on the menu
		firstchoice=0;					//where out of all the options is the list currently looking at
		selected=false;			
		this.width = 100;
		exit=false;						//pressed when exiting. back button
		if(num.length>5){				//list is 5 items long. Any longer and the list will scroll
			boxsize=5;
		}
		else{
			boxsize=num.length;
		}
	}
	public ChoiceBranchState(Game game, StateManager sm, int eventId,String[] choices, int width){
		super(game,sm);
		setStateType("choice");
		this.EventId=eventId;
		this.num=choices;
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		currentchoice=0;				//which item is selected
		choicelocation=0;				//where does the item show up on the menu
		firstchoice=0;					//where out of all the options is the list currently looking at
		selected=false;					
		exit=false;						//pressed when exiting. back button
		this.width = width;
		if(num.length>5){				//list is 5 items long. Any longer and the list will scroll
			boxsize=5;
		}
		else{
			boxsize=num.length;
		}
	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			//pressing x goes back
			if(game.getKeyManager().x){
				exit=true;
				game.getKeyManager().disable(delayCursor);
			}
			
			//pressing space runs the currently selected option
			if(game.getKeyManager().space){
				selected=true;
				game.getKeyManager().disable(delaySelection);
			}
			
			//up and down choose options
			if(game.getKeyManager().up){
				if(currentchoice>0){
					game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
					currentchoice--;
					if(choicelocation==0){
						firstchoice--;
					}
					else{
						choicelocation--;
					}
					game.getKeyManager().disable(delayCursor);
				}
				
			}
			if(game.getKeyManager().down){
				if(currentchoice<num.length-1){
					game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
					currentchoice++;
					if(choicelocation==boxsize-1){
						firstchoice++;
					}
					else{
						choicelocation++;
					}
					game.getKeyManager().disable(delayCursor);
				}
			}
		}			
	}
			

	public void render(Graphics g) {
		
		//ChoiceBranches do not take up the entire screen. The state underneath it should be rendered as well
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		
		//if x is pressed, the state is popped
//		if(exit==true){
//			StateManager.getStates().pop();
//			Event.events[this.EventId].ChoiceMade(currentchoice);
//			if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
//				Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
//				Event.events[this.EventId].run();
//			}
//			if(StateManager.getStates().peek().getStateType() == "dialogue"){
//				StateManager.getStates().pop();		//Choicebranch states must be called from dialog states or other, to exiting should pop both
//			}
//			exit=false;
//		}
		
		//if space is pressed, the states are exited and the event that called the ChoiceBranch receives the selected int
		if(selected==true){
			StateManager.getStates().pop();
			StateManager.getStates().pop();
			if(StateManager.getStates().peek().getStateType() == "dialogue"){
				StateManager.getStates().pop();
			}
			Event.getEvents()[this.EventId].ChoiceMade(currentchoice);
/*			if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
				Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
				Event.events[this.EventId].run();
			}*/

		}
		else{
//			g.setColor(new Color(102, 178,255, 200));
//			g.fillRect(5, 30, width, 25*boxsize);
//			g.setColor(new Color(200, 200,200, 200));
//			g.fillRect(5, 30+25*choicelocation, width, 25);
//			g.setFont(new Font("Chewy", Font.PLAIN, 18));
//			g.setColor(Color.BLACK);
//			for(int i=0;i<boxsize;i++){
//				g.drawString(num[firstchoice+i], 5, 50+25*i);
//			}
			Utils.drawMenu(g, window, num, Color.black, 18, choicelocation, 5, 150, width, 32 * num.length, true);
		}
//		if(firstchoice != 0){
//			g.drawImage(Assets.Uparrow, width/2, 25, null);
//		}
//		if(firstchoice != num.length - boxsize){
//			g.drawImage(Assets.Downarrow, width/2, 20 + 25 * boxsize, null);
//		}
	
	}

	@Override
	public void init() {
		
	}
	

}
