package dev.zt.UpliftedVFFV.states;
import java.awt.Graphics;
import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

//DialogState. This controls which dialog is displayed
public class DialogState extends State {
	
	private static final long serialVersionUID = 1L;
	
	private int linenum, endline, dialognum, dialogamount;
	private Dialog[] dialogs;
	private Dialog current;
	private int yoffset, ybob;
	private boolean yrise, showArrow;	//Booleans for arrow animation direction and frame skip.
	public int EventId;
	
	//KeyListener delay variables.
	private int delayNext = 500;
	private int delayScrolling = 120;
	
	//Dialogstates require 2 ints when called; the first and last lines of dialog needed
	public DialogState(Game game, StateManager sm, int start, int end, int eventId){
		super(game,sm);
		setStateType("dialogue");
		this.linenum=start;
		this.endline=end;
		this.EventId=eventId;
		this.yoffset = 0;
		this.ybob = 12;
		this.yrise = false;
		this.dialognum = 0;
		dialogamount = 1;
		showArrow = true;	//Arrow displays by default.
		game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
	}
	
	public DialogState(Game game, StateManager sm, Dialog[] d, int dialoglength, int eventId, boolean arrow){
		super(game,sm);
		this.dialogs = d;
		this.dialognum = 0;
		this.dialogamount = dialoglength;
		this.EventId=eventId;
		this.yoffset = 0;
		this.ybob = 12;
		this.yrise = false;
		this.linenum = 1;
		this.endline = 0;
		showArrow = arrow;
		game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			//if space is pressed and the dialog is done scrolling, the next dialog will begin displaying if there is one
			if(game.getKeyManager().space || game.getKeyManager().down){
				if(Dialog.scrolling==false){
					game.getKeyManager().disable(delayNext);
					game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
					//if the last line is shown, the dialogstate ends
					if(linenum == endline || dialogamount == dialognum){
						if (current!=null){					//This sets the charIndex at 0 so rereading dialog will still scroll
							current.charIndex=0;			
						}
						game.getKeyManager().disable(delayNext);
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
						if(this.dialogs == null){
							linenum++;
						}
						else{
							dialognum++;
						}
						game.getKeyManager().disable(delayScrolling + 100);
					}
				}
				//if pressing space before the dialog is done scrolling, the text will speed up.
				else{
					if(current!=null){
						current.charIndex+=10;
					}
					game.getKeyManager().disable(delayScrolling - 20);
				}
			}
		}
	}
			
	//rendering the DialogState consists of rendering whatever the current dialog is.
	//Also, because dialog does not take up the whole screen, the state underneath it must be rendered first
	public void render(Graphics g) {
		
		int width = game.getWidth();
		int height = game.getHeight();
		
		if(dialogs == null){
			current = Assets.dialog[linenum];
		}
		else{
			current = dialogs[dialognum];
		}
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		if(current!=null){
			current.render(g, width, height);
		}
			
		if(Dialog.scrolling==false && showArrow){
			g.drawImage(Assets.Downarrow, width/2 - Assets.Downarrow.getWidth() / 2, height - Assets.Downarrow.getHeight() + yoffset / 4, null);
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
