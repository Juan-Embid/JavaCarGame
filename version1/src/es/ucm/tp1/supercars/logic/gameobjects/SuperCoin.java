package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends Coin {

	public static final String SYMBOL = "$";
	public static int SUPERCOIN =1000;
	public static boolean alive = false;
	
	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
	}

	
	public String toString() {
		return SYMBOL;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		player.AddSuperCoin();
		alive =false;
		return false;
	}

	@Override
	public void onEnter() {
		alive = true;
	}

	@Override
	public void onDelete() {
	}
	
	
	public static void reset() {
		alive = false;
	}



	public boolean isAlive() {
		return alive;
	}

}
