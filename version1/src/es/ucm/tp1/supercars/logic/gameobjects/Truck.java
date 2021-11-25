package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Truck extends Obstacle {
   Game game;
	public static final String SYMBOL= "←";
	public Truck(Game game, int x, int y) {
		super(game, x, y);
	}

	public String toString() {
		return SYMBOL;
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
		x--;
	}

	@Override
	public void onDelete() {
		
	}

}
