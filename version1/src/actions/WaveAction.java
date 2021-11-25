package actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class WaveAction implements InstantAction{

	@Override
	public void execute(Game game) { //TODO poner la lógica del commando	
		boolean ok=false;
		
		for (int i = 0; i < game.getRoadWidth(); i++) {
			for (int j = game.getPlayerCycles(); j < game.getVisibility(); j++) {
				GameObject obj = game.getObjectInPosition(i, j);
				if(obj != null) {
					obj.wave();
					game.playerUnUpdate();
				}
			}
		}
	}
}
