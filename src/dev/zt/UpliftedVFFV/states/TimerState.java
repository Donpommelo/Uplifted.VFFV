package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.events.Event;

//Cutscene. This plays a series of pictures
public class TimerState extends State {
	
	
	private static final long serialVersionUID = 1L;
	
	public int time;
	public int EventId;
	public int timer;
	
	//Dialogstates require an arraylist of BufferedImages
	public TimerState(Game game, StateManager sm,int eventId, int time){
		super(game,sm);
		this.EventId=eventId;
		this.time = time;

	}

	public void tick() {
		if(timer>=time){
			StateManager.getStates().pop();
			if(Event.getEvents()[this.EventId].getstage()!=Event.getEvents()[this.EventId].getfinalstage()){
				Event.getEvents()[this.EventId].setstage(Event.getEvents()[this.EventId].getstage()+1);
				Event.getEvents()[this.EventId].run();
			}
		}
		else{
			timer++;
		}
		
			
	}
			
	
	public void render(Graphics g) {
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
	}

	@Override
	public void init() {
		
	}
	

}
