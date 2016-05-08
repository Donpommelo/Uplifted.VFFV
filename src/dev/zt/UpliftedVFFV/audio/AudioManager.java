package dev.zt.UpliftedVFFV.audio;
import java.io.Serializable;

import javax.sound.sampled.Clip;

import dev.zt.UpliftedVFFV.Game;

public class AudioManager implements Serializable{

	private static final long serialVersionUID = 8L;
	
	//	private Game game;
	static Sound sounds;
	
	public AudioManager(Game g){
//		this.game = g;
		sounds = new Sound();
		sounds.initiate();
	}
	
	public void playSound(String fileName, Boolean loop){
		if(loop){
			sounds.playLoop(fileName);
		}
		else{
			sounds.playOnce(fileName);
		}
	}
	
	public void playMusic(int track, boolean looped){
		sounds.startMusic(track,looped);
	}
	
	public Clip getMusic(){
		return Sound.getCurrentSong();
	}
	
	public String getCurrentFile(){
		return Sound.getCurrentFile();
	}
	
}
