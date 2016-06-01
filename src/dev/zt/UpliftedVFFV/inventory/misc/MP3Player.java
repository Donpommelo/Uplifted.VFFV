package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MP3Player extends Item{
	
	static int id = 2;
	static String name = "Mp3 Player";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = true;
	static int value = 10;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Plays Music.\nNot consumed on use.\nNot Implemented yet.";
	public MP3Player() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" turns up the music!");
		//Change battle music
		
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
