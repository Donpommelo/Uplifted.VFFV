package dev.zt.UpliftedVFFV.states;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.Game;

//Cutscene. This plays a series of pictures
public class CutsceneState extends State {
	
	private static final long serialVersionUID = 1L;
	
	public BufferedImage[] scenes;
	public int image;
	public int EventId;
	public BufferedImage img;
	private GameState gs;
	//KeyListener delay variables.
	private int nextImageDelay = 100;
	
	//Dialogstates require an arraylist of BufferedImages
	public CutsceneState(Game game, GameState gs, StateManager sm, BufferedImage[] slides,int eventId){
		super(game,sm);
		this.gs = gs;
		setStateType("cutscene");
		this.scenes = slides;
		this.EventId=eventId;
		this.image = 0;
	}

	public void tick() {
		
		//if space is pressed and the there re more images in the array, the next one will be displayed
		if(game.getKeyManager().space && game.getKeyManager().isActive()){
			game.getAudiomanager().playSound("/Audio/item_recipe_pickup_shop.wav", false);	
			if(image>=scenes.length-1){
					StateManager.getStates().pop();
					
					//This is used for multistage event processing. If there are multiple stages in the event being run, the stage will
					//increment and the event will be rerrun with the new stage.
					if(gs.getEvents()[this.EventId].getstage()!=gs.getEvents()[this.EventId].getfinalstage()){
						gs.getEvents()[this.EventId].setstage(gs.getEvents()[this.EventId].getstage()+1);
						gs.getEvents()[this.EventId].run();
					}
					
					}	
				else{					
					image++;
				}
				game.getKeyManager().disable(nextImageDelay);
		}	
			
	}
			
	//rendering the DialogState consists of rendering whatever the current dialog is.
	//Also, because dialog does not take up the whole screen, the state underneath it must be rendered first
	public void render(Graphics g) {
		img = scenes[image];
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public void init() {
		
	}
	

}
