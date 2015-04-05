package dev.zt.UpliftedVFFV.party;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;

public class PartyManager {
	
	private Game game;
	public ArrayList<Schmuck> party=new ArrayList<Schmuck>(5);
	
	
	public PartyManager(Game game){
		this.game=game;
		Schmuck operator=new Operator();
		party.add(operator);
		
	}
	
	public PartyManager(Game game, ArrayList<Schmuck> party){
		this.game=game;
		this.party=party;
	}
	
	public void recruit(Schmuck recruit){
		if(party.size()<5){
			this.party.add(recruit);
		}
	}
	


	public void unrecruit(Schmuck unrecruit){
		if(party.contains(unrecruit)){
			party.remove(unrecruit);
		}
	}
	
	public ArrayList<Schmuck> getParty() {
		return party;
	}

	public void setParty(ArrayList<Schmuck> party) {
		this.party = party;
	}

}
