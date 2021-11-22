package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends GameObject{

	public static final String SYMBOL = "☺";
	
	public static final int STEP = 1;
	 
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
	}

	@Override
	public boolean doCollision() {
		return false;
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
	public boolean receiveExplosion() {
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

}
