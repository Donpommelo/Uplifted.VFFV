package dev.zt.UpliftedVFFV.inventory;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

//items class.
//change usefrommenu to consummable later
public class Item implements Comparable<Item>{
	public BufferedImage ItemSprite;
	public String name,descr,descrShort;
	public int Id;
	public int value;
	
	public String janatorText;
	
	//0: Consummable 1: Equipment 2: Misc 3: Key Item
	public int slot;
	public Boolean usedfromMenu,usefromBattle, consummable, targeted = true;
	
	public Item(int id,String name,Boolean menu, Boolean battle, Boolean consume, Boolean target, String description,String descrShort,
			int value, int slot){
		this.Id=id;
		this.name=name;
		this.usedfromMenu=menu;
		this.usefromBattle=battle;
		this.consummable = consume;
		this.targeted = target;
		this.descr=description;
		this.descrShort = descrShort;
		this.value = value;
		this.slot = slot;
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

	public Boolean isConsummable() {
		return consummable;
	}
	
	public status[] getEnchantment(Schmuck s) {
		return null;
	}
	
	public void unEnchantment(Schmuck s) {
		
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
			
			break;
		case 3:
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
}
