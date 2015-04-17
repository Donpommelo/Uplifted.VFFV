package dev.zt.UpliftedVFFV.party;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;

public class TroopManager {
	private Game game;
	
	Schmuck operator=new Operator();
	Schmuck penpal=new PenPal();
	Schmuck jorge1= new BossJorge();
	Schmuck jorge2= new BossJorge();
	Schmuck jorge3= new BossJorge();
	
	public TroopManager(Game game){
		this.game=game;
	}
	
	public ArrayList<Schmuck> Troop(int index){
		ArrayList<Schmuck> enemy=new ArrayList<Schmuck>(1);
		enemy.add(jorge1);
		enemy.add(jorge2);
		enemy.add(jorge3);
		return enemy;
	}

}
