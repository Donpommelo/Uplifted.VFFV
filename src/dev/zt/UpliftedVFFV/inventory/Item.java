package dev.zt.UpliftedVFFV.inventory;

import java.awt.image.BufferedImage;

public class Item implements Comparable<Item>{
	public BufferedImage ItemSprite;
	public String name,descr;
	public int Id;
	public Boolean usedfromMenu,usefromBattle;
	
	public Item(int id,String name,Boolean menu, Boolean battle){
		this.Id=id;
		this.name=name;
		this.usedfromMenu=menu;
		this.usefromBattle=battle;
	}
	
	public Item(int id,String name,Boolean menu, Boolean battle,String description){
		this.Id=id;
		this.name=name;
		this.usedfromMenu=menu;
		this.usefromBattle=battle;
		this.descr=description;
	}
	

	public Item(int id,String name){
		this.Id=id;
		this.name=name;
		this.usedfromMenu=false;
		this.usefromBattle=false;
	}
	
	public void use(){
		
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

}
