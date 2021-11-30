package actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ExplotionAction implements InstantAction{

	@Override
	public void execute(Game game) {
        GameObject ok=null;
        
		for(int i =game.getXGrenade()-1;i<=game.getXGrenade()+1;i++) {
            for(int j =game.getYGrenade()-1;j<=game.getYGrenade()+1;j++) {
	            ok= game.getObjectInPosition(i, j);
	            if(ok!=null)
	            	ok.receiveExplosion();
            }
        }
	}
}
