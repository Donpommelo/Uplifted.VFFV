package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventAmdahlOffices extends Event {

	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EventAmdahlOffices(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			this.setSelfswitch1(true);
			Dialog[] d = new Dialog[13];
			d[0] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"Salutations my Elevator-Operating friend./Pray tell, what business brings you so far from your typical operations?");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I was ... running an errand.");
			d[2] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"Hmm?/What sort of errand?/May I ask who it is that asks of this from you?");
			d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"...uh...my...uh.../My...Pen Pal...?");
			d[4] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"Personal matters, I see./Be certain that you do not neglect your duties in the meantime.");
			d[5] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"You better be on your way then.//Wait...");
			d[6] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"That plant.../Does it...have something to do with this 'errand' of yours?");
			d[7] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Yes./I was supposed to...");
			d[8] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"...");
			d[9] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"Why don't I take that off your hands for you? You could get back to your elevator and I'd handle this little errand for you.");
			d[10] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"...Thanks...but I...don't think...");
			d[11] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"Maybe your Pen Pal wouldn't approve?/Well you better hurry then.");
			d[12] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"You wouldn't want to get mulch in the carpet, would you? You know how hard our Janitor already works.");
			super.Dialog(d, 12, this.getId(), true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Amdahl","/CharacterBusts/Amdahl1small.png",1,"There is nothing pressing that Management would like to convey to you at this moment.");
			super.Dialog(d, 0, this.getId(), true);

		}
	}
	
	
	public boolean isSolid(int i){
		return true;
	}
		
}
