package dev.zt.UpliftedVFFV.states;
import java.awt.Graphics;
import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

//DialogState. This controls which dialog is displayed
public class DialogState extends State {
	
	private int linenum,endline;
	private Dialog current;
	private int yoffset, ybob;
	private boolean yrise;
	public int EventId;
	
	//Dialogstates require 2 ints when called; the first and last lines of dialog needed
	public DialogState(Game game, StateManager sm, int start, int end,int eventId){
		super(game,sm);
		this.linenum=start;
		this.endline=end;
		this.EventId=eventId;
		this.yoffset = 0;
		this.ybob = 3;
		this.yrise = false;
		game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
					StateManager.getStates().pop();
					
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
			StateManager.getStates().pop();
			StateManager.getStates().peek().render(g);
			StateManager.getStates().push(this);
			if(current!=null){
				current.render(g);
			}
			
		if(Dialog.scrolling==false){
			g.drawImage(Assets.Downarrow, 320 - Assets.Downarrow.getWidth() / 2, 416 - Assets.Downarrow.getHeight() + yoffset, null);
			//Edit y offsets for animation.
			if(yrise){
				yoffset--;
				if (yoffset <= -ybob){
					yrise = false;
				}
			} else{
				yoffset++;
				if (yoffset >= ybob){
					yrise = true;
				}
			}
		}		
		
	}

	@Override
	public void init() {
		
	}
	

}
