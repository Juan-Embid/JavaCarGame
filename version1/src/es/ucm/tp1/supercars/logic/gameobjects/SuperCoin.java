package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends GameObject {

	public static int SUPERCOIN =1;
	private static boolean ispresent=false;
	
	public SuperCoin(Game game, int x, int y) {
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

	public static boolean hasSuperCoin() {
		return !ispresent;
	}

}
