package dev.zt.UpliftedVFFV.entities;

import java.awt.Graphics;
import dev.zt.UpliftedVFFV.Game;

public abstract class Entity {
	
	protected Game game;
	protected static float x;
	protected static float y;
	protected int width, height;
	
	public Entity(Game game, float x, float y, int width, int height){
		this.game = game;
		Entity.x = x;
		Entity.y = y;
		this.width = width;
		this.height = height;
	}
	
	public float getX() {
		return x;
	}

	public static void setX(float newx) {
		x = newx;
	}

	public float getY() {
		return y;
	}

	public static void setY(float newy) {
		y = newy;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();

	public abstract void render(Graphics g);
}
