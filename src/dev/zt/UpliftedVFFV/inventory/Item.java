package dev.zt.UpliftedVFFV.inventory;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.party.Schmuck;

//items class.
//change usefrommenu to consummable later
public class Item implements Comparable<Item>{
	public BufferedImage ItemSprite;
	public String name,descr;
	public int Id;
	public Boolean usedfromMenu,usefromBattle, consummable;
	
	public Item(int id,String name,Boolean menu, Boolean battle, Boolean consume){
		this.Id=id;
		this.name=name;
		this.usedfromMenu=menu;
		this.usefromBattle=battle;
		this.consummable = consume;
	}
	
	public Item(int id,String name,Boolean menu, Boolean battle,Boolean consume, String description){
		this.Id=id;
		this.name=name;
		this.usedfromMenu=menu;
		this.usefromBattle=battle;
		this.descr=description;
		this.consummable = consume;
	}
	

	public Item(int id,String name){
		this.Id=id;
		this.name=name;
		this.usedfromMenu=false;
		this.usefromBattle=false;
	}
	
	//ran when an item is used. Every item will override this method with whatever effect it has,
	public void use(Schmuck perp, Schmuck vic){

	}
	
	public String getName() {
		return name;
	}
	
	public String getDescr() {
		return descr;
	}

	
	public int compareTo(Item obj) {
		 return this.name.compareTo(obj.name);
	}
	
	//text displayed when used. Atm only used from Battlestate.
	public String useText(Schmuck perp, Schmuck vic){
		return "";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "";
	}

}
