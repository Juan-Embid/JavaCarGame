package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	public static final String SYMBOL = "░";
	private boolean alive;
	private static Game game;
	private static int x, y,cont;
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
	}
	
	
	public static String toStringObj() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.SetAlive();
		return false;
	}

	@Override
	public void onEnter() {		
	}

	@Override
	public void update() {		
	}

	@Override
	public void onDelete() {		
	}


	public static void reset() {
		cont=0;
	}


	/*@Override
	public boolean receiveShoot() {
		return false;
	}


	@Override
	public boolean receiveExplosion() {
		return false;
	}*/
}

