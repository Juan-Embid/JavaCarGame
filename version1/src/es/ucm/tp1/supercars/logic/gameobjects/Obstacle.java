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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		player.SetAlive();
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


	public static void reset() {
		// TODO Auto-generated method stub
		cont=0;
	}


	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}
}

