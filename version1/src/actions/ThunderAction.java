package actions;

import java.util.Random;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ThunderAction implements InstantAction{
	private Random random;
	private static int ancho, largo;
	
	@Override
	public void execute(Game game) {
        random = new Random();
        ancho = game.getRandomLane();
        largo = random.nextInt(game.getVisibility());
        GameObject obj = game.getObjectInPosition(game.getPlayerCycles() + largo, ancho);
        
        if(obj != null) {
            game.setThunderKill(obj.toString());
            obj.onDelete();}
        
        else game.setThunderKill(" ");
        
        game.setThunderAncho(largo);
        game.setThunderLargo(ancho);
    }
}