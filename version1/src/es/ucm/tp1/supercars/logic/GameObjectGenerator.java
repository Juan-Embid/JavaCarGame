package es.ucm.tp1.supercars.logic;

import actions.ThunderAction;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.gameobjects.Pedestrian;
import es.ucm.tp1.supercars.logic.gameobjects.SuperCoin;
import es.ucm.tp1.supercars.logic.gameobjects.Truck;
import es.ucm.tp1.supercars.logic.gameobjects.Turbo;
import es.ucm.tp1.supercars.logic.gameobjects.Wall;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;

public class GameObjectGenerator {
	static Game game;
	static SuperCoin supercoin;
	static Coin coin;
	static Obstacle obstacle;
	public static void generateRuntimeObjects(Game game) {
		// Note we use this method to create and inject new objects or actions on runtime.
		if (game.getLevel().hasAdvancedObjects()) {
		game.execute(new ThunderAction());
		}
		}
		
	public static void generateGameObjects(Game game, Level level) {
		for(int x = game.getVisibility() /2; x < game.getLength(); x ++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.getCoinFrequency());
			if (level.hasAdvancedObjects()) {
				game.tryToAddObject(new Wall(game, x, game.getRandomLane()), level.getAdvancedObjectFrequency());
				game.tryToAddObject(new Turbo(game, x, game.getRandomLane()), level.getAdvancedObjectFrequency());
				if (!SuperCoin.alive) {
					game.tryToAddObject(new SuperCoin(game, x, game.getRandomLane()), level.getAdvancedObjectFrequency());
				}
					game.tryToAddObject(new Truck(game, x, game.getRandomLane()), level.getAdvancedObjectFrequency());
					game.tryToAddObject(new Pedestrian(game, x, 0), level.getAdvancedObjectFrequency());
				}
			}
		}

	
	public static void SetStatus() {
	}
	
	public static void reset() {
		obstacle.reset();
		coin.reset();
	}

}
