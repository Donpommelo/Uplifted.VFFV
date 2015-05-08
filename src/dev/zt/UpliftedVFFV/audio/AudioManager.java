package dev.zt.UpliftedVFFV.audio;
import dev.zt.UpliftedVFFV.Game;

public class AudioManager {

	private Game game;
	static Sound sounds;
	
	public AudioManager(Game g){
		this.game = g;
		sounds = new Sound();
	}
	
	public void playSound(){
		sounds.test();
	}
}
