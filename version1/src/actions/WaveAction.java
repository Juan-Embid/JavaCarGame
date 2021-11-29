package actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class WaveAction implements InstantAction{

	@Override
	public void execute(Game game) {
		boolean ok=false;
		
		for (int i = 0; i < game.getRoadWidth(); i++) {
			for (int j = game.getPlayerCycles()+game.getVisibility(); j >= game.getPlayerCycles() ; j--) {
                GameObject obj = game.getObjectInPosition(j, i);
                if(obj != null) {
                    obj.wave();
				}
			}
		}
	}
}
