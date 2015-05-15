package dev.zt.UpliftedVFFV.audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	static File test;
	static AudioInputStream testStream;
	static Clip testClip;
	
	public static void main(String args[]){
/*		try{
			test = new File("res/Audio/Intro.wav");
			testStream = AudioSystem.getAudioInputStream(test);
			testClip = AudioSystem.getClip();
			testClip.open(testStream);
			testClip.start();
			testClip.loop(Clip.LOOP_CONTINUOUSLY);
		}catch (Exception e) {			}*/
	}
	
	public void test(){
		try{
			test = new File("res/Audio/Intro.wav");
			testStream = AudioSystem.getAudioInputStream(test);
			testClip = AudioSystem.getClip();
			testClip.open(testStream);
			testClip.start();
//			testClip.loop(Clip.LOOP_CONTINUOUSLY);

		}catch (Exception e) {			}
	}
}
