package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject {
	public static final String SYMBOL = "¢";
	public static int x, y;
	private boolean alive;
	private static Game game;
	
	public Coin() {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
}


