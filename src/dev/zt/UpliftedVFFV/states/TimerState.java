package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import dev.zt.UpliftedVFFV.Game;

//Cutscene. This plays a series of pictures
public class TimerState extends State {
	
	
	private static final long serialVersionUID = 1L;
	public GameState gs;
	public int time;
	public int EventId;
	public int timer;
	
	//Dialogstates require an arraylist of BufferedImages
	public TimerState(Game game,GameState gs, StateManager sm,int eventId, int time){
		super(game,sm);
		this.EventId=eventId;
		this.time = time;
		this.gs = gs;
	}

	public void tick() {
		if(timer>=time){
			StateManager.getStates().pop();
			if(gs.getEvents()[this.EventId].getstage()!=gs.getEvents()[this.EventId].getfinalstage()){
				gs.getEvents()[this.EventId].setstage(gs.getEvents()[this.EventId].getstage()+1);
				gs.getEvents()[this.EventId].run();
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
