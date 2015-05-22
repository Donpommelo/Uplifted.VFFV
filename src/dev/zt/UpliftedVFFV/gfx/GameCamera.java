package dev.zt.UpliftedVFFV.gfx;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.entities.Entity;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;

//the gamecamera object. This controls where in the map the game views
//at the moment, the game  always centers on the player object, but later, perhaps in cutscenes or in special rooms, this can be changed
public class GameCamera {
	
	private Game game;
	private float xOffset, yOffset;
	public boolean cameraControl = true;
	public int shakeDuration;
	
	public GameCamera(Game game, float xOffset, float yOffset){
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void centerOnEntity(Player p){
		if(cameraControl){
			xOffset = p.getPlayerX() - game.getWidth() / 2 + p.getWidth() / 2;
			yOffset = p.getPlayerY() - game.getHeight() / 2 + p.getHeight() / 2;
		}
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	public void screenShake(int shake){
		shakeDuration = shake;
		cameraControl = false;
			if((shake/5)%2==0){
				setxOffset(getxOffset()-5);
			}
			else{
				setxOffset(getxOffset()+5);
			}
			shakeDuration--;
		}

	public boolean isCameraControl() {
		return cameraControl;
	}

	public void setCameraControl(boolean cameraControl) {
		this.cameraControl = cameraControl;
	}

	public int getShakeDuration() {
		return shakeDuration;
	}

	public void setShakeDuration(int shakeDuration) {
		this.shakeDuration = shakeDuration;
	}
	
	
	
	
}
