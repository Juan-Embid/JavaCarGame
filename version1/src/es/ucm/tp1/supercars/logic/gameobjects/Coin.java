package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject {
	public static final String SYMBOL = "¢";
	public static int cont=0;
	private boolean alive=true;
	
	public Coin(Game game, int x, int y) {
		super(game, x,y);
	}
	
	public String toString() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		player.AddCoin();
		alive=false;
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

	@Override
	public void update() {
		
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

