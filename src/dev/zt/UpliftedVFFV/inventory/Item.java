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
	public Boolean usedfromMenu,usefromBattle, consummable, targeted, equipable = true;
	
	public Item(int id,String name,Boolean menu, Boolean battle, Boolean consume, Boolean target, Boolean equip, String description){
		this.Id=id;
		this.name=name;
		this.usedfromMenu=menu;
		this.usefromBattle=battle;
		this.consummable = consume;
		this.targeted = target;
		this.equipable = equip;
		this.descr=description;
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
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){

	}
	
	public void use(Schmuck s){

	}
	
	public String getName() {
		return name;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public String getDescrShort() {
		return "meep";
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
	
	//text displayed when used. Atm only used from Battlestate.
	public String useText(Schmuck perp, Schmuck vic){
		return "";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "";
	}
	
	public boolean startTeamTarget(){
		return true;
	}
	
	public Boolean getUsedfromMenu() {
		return usedfromMenu;
	}

	public Boolean getUsefromBattle() {
		return usefromBattle;
	}


	public Boolean getConsummable() {
		return consummable;
	}
	
	public status[] getEnchantment(Schmuck s) {
		return null;
	}
	
	public void unEnchantment(Schmuck s) {
		
	}

	public void TOQChange(Action a, BattleState bs){
		
	}

}
