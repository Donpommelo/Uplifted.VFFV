package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.PartyManager;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.quest.SwitchManager;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.World;
import dev.zt.UpliftedVFFV.world.WorldManager;

//the most important state of the game. This is active whenever walking around and exploring the main game.
//Consists of three things that must all be ticked and rendered; the World, Events, and the Player.
//This is created once and never popped unless exiting the game.
//Therefore, stuff that is universal should be kept track here; party, inventory, global variables, etc
public class GameState extends State {
	
	private Player player;
	private static World world;
	StateManager statemanager;
	WorldManager worldmanager;
	static EventManager eventmanager;
	public PartyManager partymanager;
	public InventoryManager inventorymanager;
	public AudioManager audiomanager;
	public SwitchManager switchmanager;
	public int floor;
	public int Script=0;												//starting currency. Change later for save stuff
	Event ugh;
	
	//Upon creation, the gamestate will load the starting World and events. Other worlds are loaded through events and such
	//This can be temporarily changed for the purpose of testing
	//Come back to this starting world/event stuff later when you want to make save states
	public GameState(Game game, StateManager sm){
		super(game,sm);
		ugh = new Event(game, sm,this);												//creates a new Event class that controls all events
		partymanager = new PartyManager(game);										//creates a new partymanager that keeps track of your party
		inventorymanager = new InventoryManager(game);								//creates an inventorymanager that keeps track of inventory
		world = new World(game, "res/Worlds/backroom.txt","Home Sweet Home");		
		eventmanager = new EventManager(game,"res/Worlds/backroom.txt");
		
//		world = new World(game, "res/Worlds/Mailroom.txt","Home Sweet Home");
//		eventmanager = new EventManager(game,"res/Worlds/Mailroom.txt");
//		world = new World(game, "res/Worlds/SouthHallSmall.txt","");
//		eventmanager = new EventManager(game,"res/Worlds/SouthHallSmall.txt");
		player = new Player(game, 128, 128, this);										//creates player
//		game.getAudiomanager().playSound();
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

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}




	@Override
	public void init() {
		
	}
	

}
