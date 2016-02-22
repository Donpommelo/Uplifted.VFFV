package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpCubicleDroneM extends Event {

	public static int stagenum = 0;			
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM1);
	public EmpCubicleDroneM(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		Dialog[] d = new Dialog[1];
		String character = "/CharacterBusts/3rdWestOffices-1.png";
		switch((int)(Math.random()*63)){
		case 0:
			d[0] = new Dialog("Employee",character,1,". . ./");
			break;
		case 1:
			d[0] = new Dialog("Employee",character,1,"Work . . . ennobles . . . me . . ./");
			break;
		case 2:
			d[0] = new Dialog("Employee",character,1,"All is . . . as it should be . . ./");
			break;
		case 3:
			d[0] = new Dialog("Employee",character,1,"Mend . . . broken . . . windows . . ./");
			break;
		case 4:
			d[0] = new Dialog("Employee",character,1,"I . . . built a treehouse . . . once . . ./");
			break;
		case 5:
			d[0] = new Dialog("Employee",character,1,"Hello . . . how may I help you . . . ?/");
			break;
		case 6:
			d[0] = new Dialog("Employee",character,1,"The end is not the end is not the end is not the end is not the end is not the end is not the end./");
			break;
		case 7:
			d[0] = new Dialog("Employee",character,1,"Sweep square rooms circularly . . ./");
			break;
		case 8:
			d[0] = new Dialog("Employee",character,1,"Buy . . . local . . ./");
			break;
		case 9:
			d[0] = new Dialog("Employee",character,1,"Are . . . my . . . ankles broken?/");
			break;
		case 10:
			d[0] = new Dialog("Employee",character,1,"Take me to . . .Floor 10, please . . ./");
			break;
		case 11:
			d[0] = new Dialog("Employee",character,1,"You've got the wrong guy . . . I just work here . . ./");
			break;
		case 12:
			d[0] = new Dialog("Employee",character,1,"I . . . miss my Mom . . ./");
			break;
		case 13:
			d[0] = new Dialog("Employee",character,1,"What . . . time is it . . . ?/");
			break;
		case 14:
			d[0] = new Dialog("Employee",character,1,"Did I . . . miss the bus . . . ?/");
			break;
		case 15:
			d[0] = new Dialog("Employee",character,1,"The sky . . . looks beautiful today . . ./");
			break;
		case 16:
			d[0] = new Dialog("Employee",character,1,"How is the weather?/");
			break;
		case 17:
			d[0] = new Dialog("Employee",character,1,"Is it . . . quieter than usual today . . . ?/");
			break;
		case 18:
			d[0] = new Dialog("Employee",character,1,"My eyes are . . . dry . . ./");
			break;
		case 19:
			d[0] = new Dialog("Employee",character,1,"Haven't slept in . . . weeks . . ./");
			break;
		case 20:
			d[0] = new Dialog("Employee",character,1,"You look . . . familiar . . ./");
			break;
		case 21:
			d[0] = new Dialog("Employee",character,1,"Do you . . . work here . . . ?/");
			break;
		case 22:
			d[0] = new Dialog("Employee",character,1,"Is the Servery . . . closed today . . .?/");
			break;
		case 23:
			d[0] = new Dialog("Employee",character,1,"I think I hear . . . ringing . . ./");
			break;
		case 24:
			d[0] = new Dialog("Employee",character,1,"A fence . . . That'll stop my mind from wandering . . ./");
			break;
		case 25:
			d[0] = new Dialog("Employee",character,1,"Have you ever had a dream that you, um, you had, your, you, you could, you’ll do, you,/you wants, you, you could do so, you , you’ll do, you could, you, you want, you want them,/to do you so much, you could do anything?/");
			break;
		case 26:
			d[0] = new Dialog("Employee",character,1,"Must . . . stay . . . awake . . ./");
			break;
		case 27:
			d[0] = new Dialog("Employee",character,1,"A furnace . . . to burn us . . ./");
			break;
		case 28:
			d[0] = new Dialog("Employee",character,1,"The crate . . . Is that . . . me? In the crate?/");
			break;
		case 29:
			d[0] = new Dialog("Employee",character,1,"Sorry . . . I don't drink . . ./");
			break;
		case 30:
			d[0] = new Dialog("Employee",character,1,"Are . . . you . . . real?/");
			break;
		case 31:
			d[0] = new Dialog("Employee",character,1,"What is that . . . chirping sound . . . ?/");
			break;
		case 32:
			d[0] = new Dialog("Employee",character,1,"I don't think it counts . . . if you die . . ./");
			break;
		case 33:
			d[0] = new Dialog("Employee",character,1,"When did this . . . fog roll in?/");
			break;
		case 34:
			d[0] = new Dialog("Employee",character,1,"That wouldn't be . . . very nice . . ./");
			break;
		case 35:
			d[0] = new Dialog("Employee",character,1,"There . . . are . . . more of us . . . ?/");
			break;
		case 36:
			d[0] = new Dialog("Employee",character,1,"It is by doing whatever . . . that we become . . . whomever . . ./");
			break;
		case 37:
			d[0] = new Dialog("Employee",character,1,"Please . . . just for a moment . . ./");
			break;
		case 38:
			d[0] = new Dialog("Employee",character,1,"Next time . . . next time will be different . . ./");
			break;
		case 39:
			d[0] = new Dialog("Employee",character,1,"Is that . . . blood I taste?/");
			break;
		case 40:
			d[0] = new Dialog("Employee",character,1,"Just one of those days . . ./");
			break;
		case 41:
			d[0] = new Dialog("Employee",character,1,"Why can't I . . . leave . . . ?/");
			break;
		case 42:
			d[0] = new Dialog("Employee",character,1,"Pelicans . . . hunt in well coordinated packs  . . . and are . . . known for their . . . complex/social patterns./");
			break;
		case 43:
			d[0] = new Dialog("Employee",character,1,"I don't like . . . ball pits . . .");
			break;
		case 44:
			d[0] = new Dialog("Employee",character,1,"Let . . . me . . . go . . ./");
			break;
		case 45:
			d[0] = new Dialog("Employee",character,1,"I . . . should stretch more . . ./");
			break;
		case 46:
			d[0] = new Dialog("Employee",character,1, "I . . . can't feel my legs . . . /");
			break;
		case 47:
			d[0] = new Dialog("Employee",character,1,"Hell . . . I'm in hell . . ./");
			break;
		case 48:
			d[0] = new Dialog("Employee",character,1,"Warning . . . batteries low . . ./");
			break;
		case 49:
			d[0] = new Dialog("Employee",character,1,"Are you going around in circles?/");
			break;
		case 50:
			d[0] = new Dialog("Employee",character,1,"The void . . . is calling me . . ./");
			break;
		case 51:
			d[0] = new Dialog("Employee",character,1,"I feel . . . lightheaded . . ./");
			break;
		case 52:
			d[0] = new Dialog("Employee",character,1,"There's no reward for surviving . . ./");
			break;
		case 53:
			d[0] = new Dialog("Employee",character,1,"Oh . . . dear . . ./");
			break;
		case 54:
			d[0] = new Dialog("Employee",character,1,"I . . . can't . . . swim . . ./");
			break;
		case 55:
			d[0] = new Dialog("Employee",character,1,"I've seen it in my dreams . . ./");
			break;
		case 56:
			d[0] = new Dialog("Employee",character,1,"Just . . . don't think about it . . ./");
			break;
		case 57:
			d[0] = new Dialog("Employee",character,1,". . . heard there was a . . . job opening . . ./");
			break;
		case 58:
			d[0] = new Dialog("Employee",character,1,"This all made sense . . . in my head . . ./");
			break;
		case 59:
			d[0] = new Dialog("Employee",character,1,"What do we even . . . do here . . . ?/");
			break;
		case 60:
			d[0] = new Dialog("Employee",character,1,"How . . . long has it been . . . since . . ./");
			break;
		case 61:
			d[0] = new Dialog("Employee",character,1,"My legs fell asleep . . ./");
			break;
		case 62:
			d[0] = new Dialog("Employee",character,1,"Stay . . . focused . . ./");
			break;			
		}
		super.Dialog(d, 0, this.getId(), true);

		
	}


	public boolean isSolid(int i){
		return true;
	}
	
}
