package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends Coin {

	public static final String SYMBOL = "$";
	public static int SUPERCOIN =1000;
	
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
		cont=0;
		return false;
	}

	@Override
	public void onEnter() {
		alive = true;
	}

	@Override
	public void onDelete() {
	}
	
	
	public void reset() {
		alive = false;
		cont=0;
	}



	public boolean isAlive() {
		return alive;
	}

}
