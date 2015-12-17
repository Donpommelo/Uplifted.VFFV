package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class Tutorializing extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public Tutorializing(int i, Schmuck perp, int pr){
		super(i, "Tutorializing", false, false, false, perp, pr);
	}
	
	public Tutorializing(Schmuck perp, int pr){
		super("Tutorializing", true, false, perp, pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		bs.bp.bt.textList.add(" ");
		Dialog[] d = new Dialog[8];
		d[0] = new Dialog("Operator",ImageLoader.loadImage("/CharacterBusts/Player-1.png"),0,"!!! What . . . What is going on?/");
		d[1] = new Dialog("Pen Pal",ImageLoader.loadImage("/CharacterBusts/Player-5.png"),0,"An attack! It seems some things never change./");
		d[2] = new Dialog("Pen Pal",ImageLoader.loadImage("/CharacterBusts/Player-5.png"),0,"Operator! Quick, how well learned are you in the ways of violence?/");
		d[3] = new Dialog("Operator",ImageLoader.loadImage("/CharacterBusts/Player-1.png"),0,"Err. . . well . . ./");
		d[4] = new Dialog("Pen Pal",ImageLoader.loadImage("/CharacterBusts/Player-5.png"),0,"Then I'll give you a quick rundown. Listen well./ Look to the bottom left. That is were you and I will be./On the other side stand our foe./");
		d[5] = new Dialog("Pen Pal",ImageLoader.loadImage("/CharacterBusts/Player-5.png"),0,"The premise of combat is simple. The two aforementioned parties shall entangle until it/is mutually agreed which of the two more deserves to witness the future./");
		d[6] = new Dialog("Pen Pal",ImageLoader.loadImage("/CharacterBusts/Player-5.png"),0,"You can keep track of the inevitable chaos in the battle text screen./That can be found right over . . ./Hmm. Where was it? I just saw it . . .");
		d[7] = new Dialog("Pen Pal",ImageLoader.loadImage("/CharacterBusts/Player-5.png"),0,". . ./ Ah, yes! Right over . . .");
		DialogState firstfite = new DialogState(bs.getGame(),bs.gs.getStateManager(),d ,7,0,true);
		StateManager.getStates().push(firstfite);
		bs.bp.bt.textList.add(" Pen Pal: Here!");
		bs.bp.bt.textList.add(" Pen Pal: Let us get right into it!");

	}
	
	public void endoffightEffect(Schmuck s, BattleState bs){
		Dialog[] d = new Dialog[3];
		d[0] = new Dialog("Pen Pal",ImageLoader.loadImage("/CharacterBusts/Player-5.png"),0,"Well, that wasn't so bad./Hopefully that doesn't happen too often around here./");
		d[1] = new Dialog("Pen Pal",ImageLoader.loadImage("/CharacterBusts/Player-5.png"),0,"And now to enjoy the spoils of victory!/Combat is an easy way to acquire Company Script./");
		d[2] = new Dialog("Pen Pal",ImageLoader.loadImage("/CharacterBusts/Player-5.png"),0,"Hopefully we can find somewhere to spend it./");

		DialogState firstfite = new DialogState(bs.getGame(),bs.gs.getStateManager(),d ,0,0,true);
		StateManager.getStates().push(firstfite);

	}
	
	public Boolean runWhenDead(){
		return true;
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Tutorialized.";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s finished the Tutorial.";
	}
	
}
