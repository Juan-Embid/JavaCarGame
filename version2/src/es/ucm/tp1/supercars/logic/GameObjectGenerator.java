package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;


// TODO add your imports

public class GameObjectGenerator {
	private static Game game;
	public static void generateGameObjects(Game game, Level level) {

		for (int x = game.getVisibility() / 2; x < game.getLength(); x++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.getCoinFrequency());
		}
	}

	public static void reset(Level level) {
		// TODO add your code
		Obstacle.reset();
		Coin.reset();
	}

	public static void generateRuntimeObjects(Game game) {
		// TODO add your code
	}
}
