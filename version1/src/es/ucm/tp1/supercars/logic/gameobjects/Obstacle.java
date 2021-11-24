package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	public static final String SYMBOL = "░";
	protected boolean alive=true;
	public static int cont;
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
	}
	
	
	public String toString() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.SetNotAlive();
		alive=false;
		return true;
	}

	@Override
	public void onEnter() {
		cont++;
	}

	@Override
	public void update() {	
	}

	@Override
	public void onDelete() {
		cont--;
	}


	public static void reset() {
		cont=0;
	}


	@Override
	public boolean receiveShoot() {
		alive = false;
		return true;
	}


	@Override
	public boolean receiveExplosion() {
		return false;
	}
}
