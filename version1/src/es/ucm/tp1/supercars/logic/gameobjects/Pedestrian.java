package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends Obstacle{

	public static final String SYMBOL = "☺";
	
	public static final int STEP = 1;
	private boolean impacted = false;
	
	boolean subiendo=false;

	
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
	}

	@Override
	public void onEnter() {
		
	}
	
	public String toString() {
		return SYMBOL;
	}
	@Override
	public void update() {	
		if(!impacted) {
		if(y - STEP >= 0 && subiendo) {
			y -= STEP;
		if(y==0)
			subiendo=false;
		}else if(y + STEP != game.getRoadWidth() && !subiendo) {
			y += STEP;
			if(y==game.getRoadWidth()-1)
				subiendo=true;
		}
		if(x<game.getPlayerCycles())
			alive=false;
		}
	}
	
	@Override
	public boolean receiveShoot() {
		alive = false;
		game.loseCoins();
		return true;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		player.SetNotAlive();
		impacted=true;
		return true;
	}
}
