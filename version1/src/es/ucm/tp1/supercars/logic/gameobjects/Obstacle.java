package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	public static final String SYMBOL = "░";
	private boolean alive=true;
	public static int x, y,cont;
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
	}
	
	
	public String toString() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive;
	}
	public boolean getCoinAlive() {
		
		return coin.isAlive();
	}
	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.SetNotAlive();
		return false;
	}

	@Override
	public void onEnter() {
		cont++;
	}

	@Override
	public void update() {	
		x--;
	}

	@Override
	public void onDelete() {		
	}


	public static void reset() {
		cont=0;
	}


	@Override
	public boolean receiveShoot() {
		return false;
	}


	@Override
	public boolean receiveExplosion() {
		return false;
	}
}
