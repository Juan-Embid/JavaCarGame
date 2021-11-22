package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends GameObject {
	public static final String WEAK="░";
	public static final String MEDIUM="▒";
	public static final String HARD="█";
		
	private boolean alive=true;
	public static int x, y, cont, life = 3;

	public Wall(Game game, int x, int y) {
		super(game, x, y);
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.SetNotAlive();
		return false;
	}

	@Override
	public boolean receiveShoot() {
		life--;
		if(life == 0)
			alive = false;
		return true;
	}
	
	public String toString() {
		if(life == 3)
			return HARD;
		else if (life == 2)
			return MEDIUM;
		else
			return WEAK;
	}
	
	@Override
	public void onEnter() {
		cont++;
	}
	
	@Override
	public void update() {
		x--;
	}

	@Override
	public void onDelete() {
		cont--;
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}
	
	public static void reset() {
		cont = 0;
	}

}
