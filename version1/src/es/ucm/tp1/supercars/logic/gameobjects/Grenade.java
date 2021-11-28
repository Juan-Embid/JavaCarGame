package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Grenade extends GameObject {
	
	public static final String SYMBOL = "ð";
	private int countdown = 3; //TODO ponerlo a 4 si vemos que nos va mal
	
	public Grenade(Game game, int x, int y) {
		super(game, x, y);
	}
	
	public String toString() {
		return SYMBOL + "[" + countdown + "]";
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void update() {
		countdown--;
	}

	@Override
	public void onDelete() {
		
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}

}
