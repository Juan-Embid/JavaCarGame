package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends GameObject {
	public static final String WEAK="░";
	public static final String MEDIUM="▒";
	public static final String HARD="█";
		
	private boolean alive=true;
	public static int x, y,cont;

	public Wall(Game game, int x, int y) {
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
	public void onEnter() {
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void onDelete() {
		
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}

}
