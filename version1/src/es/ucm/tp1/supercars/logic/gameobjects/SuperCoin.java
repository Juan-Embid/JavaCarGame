package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends Coin {

	public static final String SYMBOL = "$";
	public static int SUPERCOIN =1000;
	private static boolean alive = false;
	
	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
	}

	
	public String toString() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive; //TODO revisar esta funcion a ver si se usa
	}

	@Override
	public boolean receiveCollision(Player player) {
		onDelete();
		player.AddSuperCoin();
		return false;
	}

	@Override
	public void onEnter() {
		alive = true;
	}

	@Override
	public void onDelete() {
		alive = false;
	}
	
	
	public static void reset() {
		alive = false;
	}



	public static boolean hasSuperCoin() {
		return alive;
	}

}
