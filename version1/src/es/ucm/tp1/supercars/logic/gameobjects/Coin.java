package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject {
	public static final String SYMBOL = "¢";
	public static int x, y, cont;
	private boolean alive;
	private static Game game;
	
	public Coin(Game game, int x, int y) {
		super(game, x,y);
	}
	
	public static String toStringCoin() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void receiveCollision() {
		alive = false;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.AddCoin();
		return false;
	}

	@Override
	public void onEnter() {
		cont++;
	}

	@Override
	public void onDelete() {
		cont--;
	}

	public static void reset() {
		cont=0;
	}

	public static int ask() {
		// TODO Auto-generated method stub
		return cont;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		x--;
	}
}


