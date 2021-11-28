package actions;

import java.util.Random;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ThunderAction implements InstantAction{

	private Random random;
	private static int ancho, largo;
	
	@Override
	public void execute(Game game) { //TODO
		random = new Random();
		ancho = game.getRandomLane();
		largo = random.nextInt(game.getVisibility());
		GameObject obj = game.getObjectInPosition(game.getPlayerCycles() + largo, ancho); //siempre devuelve null
		if(obj != null) {
			obj.onDelete(); //no se si los borra
		}
		game.setThunderAncho(largo);
		game.setThunderLargo(ancho);
	}

}
