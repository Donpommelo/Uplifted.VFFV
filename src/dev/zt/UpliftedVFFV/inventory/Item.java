package dev.zt.UpliftedVFFV.inventory;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

//items class.
//change usefrommenu to consumable later
public class Item implements Comparable<Item>, Serializable{
	
	private static final long serialVersionUID = -4363739757604804621L;
	
	public String name,descr,descrShort;
	public int Id;
	public int value;
	public int lvlReq;
	public String janitorText;
	
	//0: Consumable 1: Equipment 2: Misc 3: Key Item
	public int slot;
	public Boolean usedfromMenu, usefromBattle, consumable, targeted = true;
	
	public Item(int id,String name,Boolean menu, Boolean battle, Boolean consume, Boolean target, String description,String descrShort,
			int value, int slot, int lvlReq){
		this.Id=id;
		this.name=name;
		this.usedfromMenu=menu;
		this.usefromBattle=battle;
		this.consumable = consume;
		this.targeted = target;
		this.descr=description;
		this.descrShort = descrShort;
		this.value = value;
		this.slot = slot;
		this.lvlReq = lvlReq;
	}	

	//ran when an item is used. Every item will override this method with whatever effect it has,
	
	//Nontargeted item used from menu
	public void use(){

	}
	
	
	//targeted item used in battle
	public void use(Schmuck perp, Schmuck vic, BattleState bs){

	}
	
	//targeted item used from menu
	public void use(Schmuck s){

	}
	
	public String getName() {
		return name;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	//0: All targets
	//1: No target: automatically performs action
	//2: All targetable allies (used in reviving)
	public int getTargetType(){
		return 0;
	}

	
	public int compareTo(Item obj) {
		 return this.name.compareTo(obj.name);
	}
		
	public boolean startTeamTarget(){
		return true;
	}
	
	public Boolean isUsedfromMenu() {
		return usedfromMenu;
	}

	public Boolean isUsefromBattle() {
		return usefromBattle;
	}

	//Zach can't spell.
	public Boolean isConsummable() {
		return consumable;
	}
	
	public status[] getEnchantment(Schmuck s) {
		return null;
	}
	
	public void unEnchantment(Schmuck s, InventoryManager meep) {
		
	}

	public void TOQChange(Action a, BattleState bs){
		
	}
	
	public boolean isLegendary(){
		return false;
	}
	
	public int value(){
		return value;
	}
	
	public int getSlot(){
		return slot;
	}
	
	public int getLvlReq(){
		return lvlReq;
	}
	
	public boolean isSellable(){
		return true;
	}
	
	public String getJanitorText(Item i){
		int rand = (int)(Math.random()*7);
		String text = "";
		switch(rand){
		case 0:
			text = "Ah, "+i.getName()+"s. That could be nice, I suppose. I'll add it to my stock.";
			break;
		case 1:
			text = "Hmm. I don't know if I need that. But I like you, so I'll buy it.";
			break;
		case 2:
			text = "Well, its not amazing, but I guess I'll buy it anyways. Out of charity, really.";
			break;
		case 3:
			text = "That could be nice. Yeah, that could be real nice . . . ";
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}
		return text;
	}
	
	public BufferedImage getIcon(){
		//Return image icon if it exists, otherwise use a placeholder.
		if(Assets.itemIcons!= null && Assets.itemIcons.length > Id && Assets.itemIcons[Id] != null){
			return Assets.itemIcons[Id];
		}
		else{
			return Assets.skillIcons[4];
		}
	}
	
	public BufferedImage getImage(){
		//Return image picture if it exists, otherwise use a placeholder.
		if(Assets.itemSprites!= null && Assets.itemSprites.length > Id && Assets.itemSprites[Id] != null){
			return Assets.itemSprites[Id];
		}
		else{
			return Assets.skillIcons[4];
		}
	}
	
	public String toString(){
		return getName();
	}
}
