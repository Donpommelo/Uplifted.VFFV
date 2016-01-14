package dev.zt.UpliftedVFFV.party;

import java.io.Serializable;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;

public class PartyManager implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	//	private Game game;
	public ArrayList<Schmuck> party=new ArrayList<Schmuck>(5);
	
	
	public PartyManager(Game game){
//		this.game=game;
		Schmuck operator=new Operator(1);
		party.add(operator);
/*		Schmuck penpal=new PenPal(1);
		party.add(penpal);
		Schmuck penpal1=new PenPal(1);
		party.add(penpal1);
		Schmuck penpal2=new PenPal(1);
		party.add(penpal2);
		Schmuck penpal3=new PenPal(1);
		party.add(penpal3);*/
		
		
	}
	
	public PartyManager(Game game, ArrayList<Schmuck> party){
//		this.game=game;
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
