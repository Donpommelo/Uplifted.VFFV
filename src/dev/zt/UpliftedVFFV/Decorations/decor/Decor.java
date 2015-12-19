package dev.zt.UpliftedVFFV.Decorations.decor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.world.World;

//This manages Decorations. Decorations are cosmetic things that can be drawn anywhere and cannot be interacted with.
//Unlike events and tiles, the locations of Decorations are specified by the pixel for more precision.
//Decorations never block a player's path. If you want one to be solid, overlay it with a solid, invisible event (event0)


public class Decor {
	int id;
	static World world;
	protected static Game game;
	protected static GameState gamestate;
	protected BufferedImage tex;

	public static Decor[] decors = new Decor[256];
	public static Decor decorclock = new DecorClock(0);
	public static Decor decorbed = new DecorBed(1);
	public static Decor decorwritingdesk = new DecorWritingDesk(2);
	public static Decor decortv = new DecorTv(3);
	public static Decor decorcalendar = new DecorCalender(4);
	public static Decor decorpelicanfloor = new DecorElevatorPelican(5);
	public static Decor decorwallpanel = new DecorWallPanel(6);
	public static Decor decorsofa1 = new DecorSofa1(7);
	public static Decor decorsofa2 = new DecorSofa1(8);
	public static Decor table0 = new DecorTable0(9);
	public static Decor table1 = new DecorTable1(10);
	public static Decor table2 = new DecorTable2(11);
	public static Decor table3 = new DecorTable3(12);
	public static Decor table4 = new DecorTable4(13);
	public static Decor table5 = new DecorTable5(14);
	public static Decor table6 = new DecorTable6(15);
	public static Decor table7 = new DecorTable7(16);
	public static Decor table8 = new DecorTable8(17);
	public static Decor table9 = new DecorTable9(18);





	public Decor(Game g, GameState gs){
		game=g;
		gamestate=gs;
	}
	
	
	public Decor(BufferedImage texture, int idnum) {
		this.tex = texture;
		this.id = idnum;
		decors[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(tex,x, y, tex.getWidth(), tex.getHeight(), null);
	}

	//Tex is the image that the Decoration is represented by.
	public BufferedImage getTex() {
		return tex;
	}
	
	public void setTex(BufferedImage tex) {
		this.tex = tex;
	}
	
	//Returns whether a decoration is rendered below the player. Most events are. Otherwise, override and return false to draw above player
	//as well as other events.
	public boolean renderBelow(){
		return true;
	}
}