package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends Obstacle{

	public static final String SYMBOL = "☺";
	
	public static final int STEP = 1;
	boolean subiendo=true;
	
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
	}

	@Override
	public void onEnter() {
		
	}
	
	public String toString() {
		return SYMBOL;
	}
	//TODO ARREGLAR CARA BAJANDO
	@Override
	public void update() {	
		if(subiendo) {
			if(y + STEP != game.getRoadWidth()) {
				y += STEP;
			}
			else 	subiendo=false;
		}else {
			if(y - STEP >0) {
				y-= STEP;
				}
			else subiendo=true;
		}
	}

	@Override
	public void onDelete() {
		
	}

}
