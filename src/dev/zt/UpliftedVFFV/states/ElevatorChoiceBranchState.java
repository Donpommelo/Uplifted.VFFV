package dev.zt.UpliftedVFFV.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

public class ElevatorChoiceBranchState extends ChoiceBranchState{

	private BufferedImage window, panel, cursor;
	
	public ElevatorChoiceBranchState(Game game, StateManager sm, int eventId, String[] choices) {
		super(game, sm, eventId, choices);
		window = ImageLoader.loadImage("/ui/Window/WindowBlack.png");
		panel = ImageLoader.loadImage("/ui/ElevatorPanelAlt.png");
		cursor = ImageLoader.loadImage("/ui/ElevatorPanelCursor.png");
	}
	
	//Overrides render method of super class to display custom icon.
	public void render(Graphics g){
		//ChoiceBranches do not take up the entire screen. The state underneath it should be rendered as well
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		
		//if x is pressed, the state is popped
		if(exit==true){
			StateManager.getStates().pop();
			Event.events[this.EventId].ChoiceMade(currentchoice);
			StateManager.getStates().pop();		//Choicebranch states must be called from dialog states or other, to exiting should pop both
			exit=false;
		}
		
		//if space is pressed, the states are exited and the event that called the ChoiceBranch receives the selected int
		if(selected==true){
			StateManager.getStates().pop();
			StateManager.getStates().pop();
			Event.events[this.EventId].ChoiceMade(currentchoice);
		}
		else{
			//Draw elevator panel.
			g.drawImage(panel, 440, 16, 200, 400, null);
			//Draw Cursor.
			g.drawImage(cursor, 502, 42 + 32 * (firstchoice + choicelocation), 25, 25, null);
			//Draw Text.
			Utils.drawDialogueBox(g, window, num[firstchoice + choicelocation], 15, Color.white, 440, 0, 200, 16, true);
		}
	}
	
}