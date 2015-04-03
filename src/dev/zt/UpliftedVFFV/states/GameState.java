package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.party.Operator;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.World;
import dev.zt.UpliftedVFFV.world.WorldManager;

public class GameState extends State {
	
	private Player player;
	private static World world;
	StateManager statemanager;
	WorldManager worldmanager;
	static EventManager eventmanager;
	Event ugh;
	ArrayList<Character> party= new ArrayList<Character>();
	public Character Operator;
	public GameState(Game game, StateManager sm){
		super(game,sm);
		ugh = new Event(game, sm);
		world = new World(game, "res/Worlds/backroom.txt","Home Sweet Home");
		eventmanager=new EventManager(game,"res/Worlds/backroom.txt");
		player = new Player(game, 128, 128);
		
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
	
	public void tick() {

		world.tick();
		eventmanager.tick();
		player.tick();
	}
	
	public void render(Graphics g) {
		world.render(g);
		eventmanager.render(g);
		player.render(g);
		if(game.getKeyManager().z){
//			StateManager.states.push(new MenuState(game,statemanager));
			StateManager.states.push(new BattleState(game,statemanager));
			
		}
		
	}

	@Override
	public void init() {
		
	}
	

}
