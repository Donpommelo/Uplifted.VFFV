package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.io.IOException;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.party.PartyManager;
import dev.zt.UpliftedVFFV.quest.SwitchManager;
import dev.zt.UpliftedVFFV.quest.VariableManager;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.World;
import dev.zt.UpliftedVFFV.world.WorldManager;

//the most important state of the game. This is active whenever walking around and exploring the main game.
//Consists of three things that must all be ticked and rendered; the World, Events, and the Player.
//This is created once and never popped unless exiting the game.
//Therefore, stuff that is universal should be kept track here; party, inventory, global variables, etc
public class GameState extends State {
	
	private static final long serialVersionUID = 8L;
	
	public Player player;
	private static World world;
	StateManager statemanager;
	WorldManager worldmanager;
	static EventManager eventmanager;
	public PartyManager partymanager;
	public InventoryManager inventorymanager;
	public AudioManager audiomanager;
	public SwitchManager switchmanager;
	public VariableManager variablemanager;
	
//	public int floor;
	public int Script=0;												//starting currency. Change later for save stuff
	Event ugh;
	
	//Upon creation, the gamestate will load the starting World and events. Other worlds are loaded through events and such
	//This can be temporarily changed for the purpose of testing
	//Come back to this starting world/event stuff later when you want to make save states
	public GameState(Game game, StateManager sm){
		super(game,sm);
		switchmanager = new SwitchManager(game);
		variablemanager = new VariableManager(game);
		ugh = new Event(game, sm,this);												//creates a new Event class that controls all events
		partymanager = new PartyManager(game);										//creates a new partymanager that keeps track of your party
		inventorymanager = new InventoryManager(game);								//creates an inventorymanager that keeps track of inventory
		world = new World(game, "/Worlds/ElevatorsandBackroom/backroom.txt","Home Sweet Home");		
		eventmanager = new EventManager(game,"/Worlds/ElevatorsandBackroom/backroom.txt");
		
//		world = new World(game, "/Worlds/Floor3Offices/SouthWingOffices/SouthAquaHall.txt","Home Sweet Home");
//		eventmanager = new EventManager(game,"/Worlds/Floor3Offices/SouthWingOffices/SouthAquaHall.txt");
//		world = new World(game, "/Worlds/Floor3Offices/EastWingOffices/EastOfficesRightTopEntrance.txt","");
//		eventmanager = new EventManager(game,"/Worlds/Floor3Offices/EastWingOffices/EastOfficesRightTopEntrance.txt");
		player = new Player(game, 256, 288, this);										//creates player
		game.getAudiomanager().playMusic(1,true);
	}

	


	public static World getWorld() {
		return world;
	}

	public static void setWorld(World w) {
		world = w;

	}
	
	public static EventManager getEventmanager() {
		return eventmanager;
	}

	public static void setEventmanager(EventManager e) {
		eventmanager = e;
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
	
	public WorldManager getWorldManager(){
		return worldmanager;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void tick() {

		world.tick();
		eventmanager.tick();
		player.tick();
		if(game.getKeyManager().z){												//opens up a menu.
			StateManager.states.push(new MenuState(game,statemanager,this));
		}
	}
	
	public void render(Graphics g) {
		world.render(g);
		eventmanager.render(g);
		player.render(g);
		if(!game.getGameCamera().cameraControl){
			if(game.getGameCamera().getShakeDuration()<1){
				game.getGameCamera().setCameraControl(true);
			}
			else{
				game.getGameCamera().screenShake(game.getGameCamera().getShakeDuration());
			}
		}
		
//			StateManager.states.push(new BattleState(game,statemanager));
	}

	public int getVar(int i) {
		return variablemanager.getVar(i);
	}

	public void setVar(int i, int set) {
		variablemanager.setVar(i, set);;
	}
	
	public boolean getSwitch(int i) {
		return switchmanager.getSwitch(i);
	}

	public void setSwitch(int i, boolean set) {
		switchmanager.setSwitch(i, set);;
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
		world = new World(game, path, name);
		
		//Load player location.
		player.setPlayerX(stream.readFloat());
		player.setPlayerY(stream.readFloat());
		
		//TODO: Load music track.
		
		//Load party data.
//		partymanager = (PartyManager) stream.readObject();
		
		//Load inventory data.
//		inventorymanager = (InventoryManager) stream.readObject();
		
		//Load world/event flags.
//		eventmanager = (EventManager) stream.readObject();
		switchmanager.switches = (boolean[]) stream.readObject();
		variablemanager.variables = (int[]) stream.readObject();
	}
	
	public void writeObject(java.io.ObjectOutputStream stream) throws IOException{
		//Save world data.
		stream.writeObject(world.getName());
		stream.writeObject(world.getPath());
		
		//Save Player location.
		stream.writeFloat(player.getPlayerX());
		stream.writeFloat(player.getPlayerY());
		
		//TODO: Save music track. Maybe tie music to world.
		
		//Save party data.
//		stream.writeObject(partymanager);
		
		//Save inventory data.
//		stream.writeObject(inventorymanager);
		
		//Save world/event flags.
//		stream.writeObject(eventmanager);
		stream.writeObject(switchmanager.switches);
		stream.writeObject(variablemanager.variables);
	}
}
