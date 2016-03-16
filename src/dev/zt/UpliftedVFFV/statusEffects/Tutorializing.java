package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class Tutorializing extends status{
	
	public static String name = "Tutorializing";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	public Tutorializing(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Tutorializing(int pr){
		super(name, pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(bs.bp.roundNum == 1){
			Dialog[] d = new Dialog[12];
			d[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Well, you've survived your first round of combat!/How does it feel?/");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I . . . I'm not sure. . ./");
			d[2] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Perhaps more guidance is needed./Allow me to elaborate in greater detail the options at your disposal./");
			d[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"First is 'Attack'. This act of violence can be directed towards a single target;/a simple and effective (hopefully) method of letting others know how you feel./");
			d[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Next is 'Skill'. This brings up a character's collection of special talents./These can have all manner of effects, so be sure to carefully read their descriptions!/");
			d[5] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Most skills require Motivation Points (Mp) in order to use./Remember that an unmotivated employee is a soon-to-be-fired one./");
			d[6] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Moving on, we have the 'Item' option. You don't seem to need any items right now,/but when you do, keep this option in mind in case you feel the need for a mid-battle/snack./");
			d[7] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"The next option is 'Wait' and is my personal favorite./Making a decision is never easy, and post-poning those decisions can be a great relief./");
			d[8] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"That, is precisely what the 'Wait' option allows you to do!/When choosing to wait, a character will delay the decision-making process until his or/her turn to act comes, when the action is decided and executed immediately./");
			d[9] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Bear in mind that Waiting will make you lose some initiative./Wait too much and you may miss a golden opportunity!/");
			d[10] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Finally, there is the 'Run' action. This allows you to attempt to flee from combat./No one will judge you for selecting this option./");
			d[11] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"That just about does it! Now, lets finish this and continue our quest./");
			DialogState firstfite = new DialogState(bs.getGame(),bs.gs,bs.gs.getStateManager(),d ,11,0,true);
			StateManager.getStates().push(firstfite);
		}
		bs.bp.bt.addScene(" ");

	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		bs.bp.bt.addScene(" ");
		Dialog[] d = new Dialog[10];
		d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"!!! What . . . What is going on?/");
		d[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"An attack! It seems some things never change./");
		d[2] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Operator! Quick, how well learned are you in the ways of violence?/");
		d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Err . . . well . . ./");
		d[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Then I'll give you a quick rundown. Listen well./ Look to the bottom left. That is were you and I will be./On the other side stand our foe./");
		d[5] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"The premise of combat is simple. The two aforementioned parties shall entangle until it/is mutually agreed which of the two more deserves to witness the future./");
		d[6] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Use arrow keys to navigate the battle menu and space to select options and targets!/");
		d[7] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Press enter when you've selected an action for all team members./");
		d[8] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"You can keep track of the inevitable chaos in the battle text screen./That can be found right over . . ./Hmm. Where was it? I just saw it . . .");
		d[9] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,". . ./ Ah, yes! Right over . . .");
		DialogState firstfite = new DialogState(bs.getGame(),bs.gs,bs.gs.getStateManager(),d ,9,0,true);
		StateManager.getStates().push(firstfite);
		bs.bp.bt.addScene("Pen Pal: Here!");
		bs.bp.bt.addScene("Pen Pal: Let us get right into it!");
	}
	
	public void endoffightEffect(Schmuck s, Boolean won, BattleState bs){
		Dialog[] d = new Dialog[5];
		d[0] = new Dialog("Pen Pal", "/CharacterBusts/Player-5.png",0,"Well, that wasn't so bad./Hopefully that doesn't happen too often around here./");
		d[1] = new Dialog("Pen Pal", "/CharacterBusts/Player-5.png",0,"And now to enjoy the spoils of victory!/Combat is an easy way to acquire Company Script./");
		d[2] = new Dialog("Pen Pal", "/CharacterBusts/Player-5.png",0,"Hopefully we can find somewhere to spend it./");
		d[3] = new Dialog("Pen Pal", "/CharacterBusts/Player-5.png",0,"Combat also provides to its participants valuable Work Experience./Gain enough Exp to level up and climb the corporate ladder./Become a more valuable company asset and gain more transferable job skills!/");
		d[4] = new Dialog("Pen Pal", "/CharacterBusts/Player-5.png",0,"Lastly, enemies will sometimes drop valuable loot!/These items can be examined closely in your inventory, viewable from the menu! ('Z')/");

		DialogState firstfite = new DialogState(bs.getGame(),bs.gs,bs.gs.getStateManager(),d ,4,0,true);
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
