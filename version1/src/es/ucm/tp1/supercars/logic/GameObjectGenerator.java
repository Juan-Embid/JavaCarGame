package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.gameobjects.SuperCoin;
import es.ucm.tp1.supercars.logic.gameobjects.Turbo;
import es.ucm.tp1.supercars.logic.gameobjects.Wall;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class GameObjectGenerator {
	static Game game;
	private static final GameObject[] AVAILABLE_OBJECTS = {
			new Wall(game, game.getVisibility()+game.getCycles(), game.getRandomLane()),
			new Turbo(game, game.getVisibility()+game.getVisibility()+game.getCycles(), game.getRandomLane()),
			new SuperCoin(game, game.getVisibility()+game.getCycles(), game.getRandomLane()),
			/*new Truck(),
			new Pedestrian*/
		};
	public static void generateGameObjects(Game game, Level level) {
	
		for (int x = game.getVisibility() / 2; x < game.getLength(); x++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.getCoinFrequency());
		}
	}
	public static void SetStatus() {
	}
	
	public static void reset() {
		Obstacle.reset();
		Coin.reset();
	}

	public static void generateRuntimeObjects(Game game) {
	}
	public static void forceAdvanceObject(Game game, int id, int x) {
		GameObject o = null;
		switch (id) {
		case 1:
		o = new Wall(game, x, game.getRandomLane());
		break;
		case 2:
		o = new Turbo(game, x, game.getRandomLane());
		break;
		case 3:
		o = new SuperCoin(game, x, game.getRandomLane());
		break;
		case 4:
		o = new Truck(game, x, game.getRandomLane());
		break;
		case 5:
		o = new Pedestrian(game, x, 0);
		break;
		}
		game.forceAddObject(o);*/
	}
}
