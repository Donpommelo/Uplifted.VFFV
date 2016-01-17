package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.io.IOException;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Decorations.DecorManager;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.EventSelfSwitchManager;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.party.PartyManager;
import dev.zt.UpliftedVFFV.quest.QuestManager;
import dev.zt.UpliftedVFFV.quest.SwitchManager;
import dev.zt.UpliftedVFFV.quest.VariableManager;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.WorldManager;

//the most important state of the game. This is active whenever walking around and exploring the main game.
//Consists of three things that must all be ticked and rendered; the World, Events, and the Player.
//This is created once and never popped unless exiting the game.
//Therefore, stuff that is universal should be kept track here; party, inventory, global variables, etc
public class GameState extends State {
	
	private static final long serialVersionUID = 8L;
	
	public Player player;
	private static WorldManager worldmanager;
	StateManager statemanager;
	static DecorManager decormanager;
	static EventManager eventmanager;
	public PartyManager partymanager;
	public InventoryManager inventorymanager;
	public AudioManager audiomanager;
	public SwitchManager switchmanager;
	public VariableManager variablemanager;
	public QuestManager questmanager;
	public EventSelfSwitchManager eventselfswitchmanager;
	public Event Events;
	
//	public int floor;
	public int Script=0;												//starting currency. Change later for save stuff
	
	//Upon creation, the gamestate will load the starting World and events. Other worlds are loaded through events and such
	//This can be temporarily changed for the purpose of testing
	//Come back to this starting world/event stuff later when you want to make save states
	public GameState(Game game, StateManager sm){
		super(game,sm);
		switchmanager = new SwitchManager(game);
		variablemanager = new VariableManager(game);
		questmanager = new QuestManager(game);
		eventselfswitchmanager = new EventSelfSwitchManager(game);
		
		Events = new Event(game, sm,this);											//creates a new Event class that controls all events
		for(Event e : Events.getEvents()){
			if(e != null){
				eventselfswitchmanager.resetSelfSwitches(e);
			}
		}
		
		partymanager = new PartyManager(game);										//creates a new partymanager that keeps track of your party
		inventorymanager = new InventoryManager(game);								//creates an inventorymanager that keeps track of inventory
		
//		String StartingFloor = "/Worlds/Floor3Offices/SouthWingOffices/SouthWingSection1.txt";
//		String StartingFloor = "/Worlds/Floor3Offices/EastWingOffices/EastOfficesRightMain2Room3.txt";
//		String StartingFloor = "/Worlds/ElevatorsandBackroom/HomeSweetElevator.txt";
		String StartingFloor = "/Worlds/ProbablyNotActuallyintheGame/CombatTesting.txt";
		
		worldmanager = new WorldManager(game, StartingFloor,"Home Sweet Home");		
		eventmanager = new EventManager(game,this,StartingFloor);
		decormanager = new DecorManager(game, this, StartingFloor);

		player = new Player(game, 32*worldmanager.getSpawnX(), 32*worldmanager.getSpawnY(), this);										//creates player
		game.getAudiomanager().playMusic(1,true);
		game.getGameCamera().centerOnEntity(player);
	}
	
	//Dummy gamestate used to read and display save files
	public GameState(Game game, StateManager sm, int meep){
		super(game,sm);
		switchmanager = new SwitchManager(game);
		variablemanager = new VariableManager(game);
		questmanager = new QuestManager(game);
		eventselfswitchmanager = new EventSelfSwitchManager(game);
		Events = new Event(game, sm,this);											//creates a new Event class that controls all events
		player = new Player(game, 0, 0, this);										//creates player
	}

	public WorldManager getWorld() {
		return worldmanager;
	}

	public static void setWorld(WorldManager w) {
		worldmanager = w;
	}
	
	public EventManager getEventmanager() {
		return eventmanager;
	}

	public static void setEventmanager(EventManager e) {
		eventmanager = e;
	}

	public Event[] getEvents() {
		return Events.getEvents();
	}
	
	public EventSelfSwitchManager getEventselfswitchmanager() {
		return eventselfswitchmanager;
	}

	public void setEventselfswitchmanager(
			EventSelfSwitchManager eventselfswitchmanager) {
		this.eventselfswitchmanager = eventselfswitchmanager;
	}

	public static DecorManager getDecormanager() {
		return decormanager;
	}

	public static void setDecormanager(DecorManager d) {
		decormanager = d;
	}

	public PartyManager getPartymanager() {
		return partymanager;
	}

	public void setPartymanager(PartyManager partymanager) {
		this.partymanager = partymanager;
	}
	
	public StateManager getStateManager(){
		return statemanager;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void tick() {

		worldmanager.tick();
		eventmanager.tick();
		player.tick(this);
		if(game.getKeyManager().z){												//opens up a menu.
			StateManager.states.push(new MenuState(game,statemanager,this));
		}
	}
	
	public void render(Graphics g) {
		worldmanager.render(g);
		decormanager.renderBelow(g);
		eventmanager.renderBelow(g);
		player.render(g);
		eventmanager.renderAbove(g);
		decormanager.renderAbove(g);
		worldmanager.renderNameplate(g);
		if(!game.getGameCamera().cameraControl){
			if(game.getGameCamera().getShakeDuration()<1){
				game.getGameCamera().setCameraControl(true);
			}
			else{
				game.getGameCamera().screenShake(game.getGameCamera().getShakeDuration());
			}
		}		
		
	}

	public int getVar(int i) {
		return variablemanager.getVar(i);
	}

	public void setVar(int i, int set) {
		variablemanager.setVar(i, set);
	}
	
	public boolean getSwitch(int i) {
		return switchmanager.getSwitch(i);
	}

	public void setSwitch(int i, boolean set) {
		switchmanager.setSwitch(i, set);
	}
	
	public int getQuest(int i){
		return questmanager.getQuest(i);
	}
	
	public void setQuest(int i, int set) {
		questmanager.setQuest(i, set);
	}
	
	public void scriptChange(int change){
		Script+=change;
		if(Script<0){
			Script = 0;
		}
	}

	@Override
	public void init() {
		
	}
	
	//Saving and loading.
	public void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException{
		//Load world data and recreate world.
		String name= (String) stream.readObject();
		String path = (String) stream.readObject();
		
		//Load party data.
		partymanager = (PartyManager) stream.readObject();
				
		worldmanager = new WorldManager(game, path, name);
		eventmanager = new EventManager(game,this, path);
		decormanager = new DecorManager(game, this, path);
		//Load player location.
		player.setPlayerX(stream.readFloat());
		player.setPlayerY(stream.readFloat());
		
		//TODO: Load music track.
		
		
		
		//Load inventory data.
		inventorymanager = (InventoryManager) stream.readObject();
		
		//Load world/event flags.
		eventselfswitchmanager.events = (int[]) stream.readObject();
		switchmanager.switches = (boolean[]) stream.readObject();
		variablemanager.variables = (int[]) stream.readObject();
		questmanager.quests = (int[]) stream.readObject();
		
		for(Event e : Events.getEvents()){
			if(e != null){
				eventselfswitchmanager.setSelfSwitches(e);
			}
		}
		
	}
	
	public void writeObject(java.io.ObjectOutputStream stream) throws IOException{
		//Save world data.
		stream.writeObject(worldmanager.getName());
		stream.writeObject(worldmanager.getPath());
		
		//Save party data.		
		stream.writeObject(partymanager);
				
		//Save Player location.
		stream.writeFloat(player.getPlayerX());
		stream.writeFloat(player.getPlayerY());
		
		//TODO: Save music track. Maybe tie music to world.
				
		//Save inventory data.
		stream.writeObject(inventorymanager);
		
		//Save world/event flags.
		stream.writeObject(eventselfswitchmanager.events);
		stream.writeObject(switchmanager.switches);
		stream.writeObject(variablemanager.variables);
		stream.writeObject(questmanager.quests);

	}
}
