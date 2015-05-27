package dev.zt.UpliftedVFFV.audio;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	static URL test;
	static AudioInputStream testStream;
	static Clip testClip;
	public static Clip currentSong;
	public static String currentFile;
	public static Clip Intro, ElevatorTheme, OfficeTheme, BattleTheme, BossTheme;
	
	public static void main(String args[]){

	}
	
	public void initiate(){
		try{
			test = Sound.class.getResource("/Audio/Intro.wav");
			testStream = AudioSystem.getAudioInputStream(test);
			Intro = AudioSystem.getClip();
		}catch (Exception e) {			}
		try{
			test = Sound.class.getResource("/Audio/Piano_de_Bossa_-_Samba_de_Ver_o_.wav");
			testStream = AudioSystem.getAudioInputStream(test);
			ElevatorTheme = AudioSystem.getClip();
		}catch (Exception e) {			}
		try{
			test = Sound.class.getResource("/Audio/Piano_de_Bossa_-_Wave.wav");
			testStream = AudioSystem.getAudioInputStream(test);
			Intro = AudioSystem.getClip();
		}catch (Exception e) {			}
		try{
			test = Sound.class.getResource("/Audio/Output 1-2.wav");
			testStream = AudioSystem.getAudioInputStream(test);
			Intro = AudioSystem.getClip();
		}catch (Exception e) {			}
		try{
			test = Sound.class.getResource("/Audio/Brownout_-_African_Battle.wav");
			testStream = AudioSystem.getAudioInputStream(test);
			Intro = AudioSystem.getClip();
		}catch (Exception e) {			}
	}
	
	
	public void playOnce(String fileName){
		try{
			test = Sound.class.getResource(fileName);
			testStream = AudioSystem.getAudioInputStream(test);
			testClip = AudioSystem.getClip();
			testClip.open(testStream);
			testClip.start();
		}catch (Exception e) {			}
	}
	
	public void playLoop(String fileName){
		try{
			test = Sound.class.getResource(fileName);
			testStream = AudioSystem.getAudioInputStream(test);
			testClip = AudioSystem.getClip();
			testClip.open(testStream);
			testClip.start();
			testClip.loop(Clip.LOOP_CONTINUOUSLY);
		}catch (Exception e) {			}
	}
	
	public void startMusic(int track, boolean looped){
		if(currentSong!=null){
			currentSong.stop();
		}
		switch(track){
		case 0:
			setCurrentSong(Intro);
			currentFile = "/Audio/Intro.wav";
			break;
		case 1:
			setCurrentSong(ElevatorTheme);
			currentFile = "/Audio/Piano_de_Bossa_-_Samba_de_Ver_o_.wav";
			break;
		case 2:
			setCurrentSong(OfficeTheme);
			currentFile = "/Audio/Piano_de_Bossa_-_Wave.wav";
			break;
		case 3:
			setCurrentSong(BattleTheme);
			currentFile = "/Audio/Output 1-2.wav";
			break;
		case 4:
			setCurrentSong(BossTheme);
			currentFile = "/Audio/Brownout_-_African_Battle.wav";
			break;
			
		}
		try{
			test = Sound.class.getResource(currentFile);
			testStream = AudioSystem.getAudioInputStream(test);
			currentSong = AudioSystem.getClip();
			currentSong.open(testStream);
			currentSong.start();
			if(looped){
				currentSong.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}catch (Exception e) {			}
	}


	public static void setCurrentSong(Clip currentSong) {
		Sound.currentSong = currentSong;
	}

	public static Clip getCurrentSong() {
		return currentSong;
	}
	
	public static String getCurrentFile(){
		return currentFile;
	}
	
	
	
}
