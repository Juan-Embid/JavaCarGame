package es.ucm.tp1.supercars.logic.gameobjects;

import actions.ExplotionAction;
import es.ucm.tp1.supercars.logic.Game;

public class Grenade extends GameObject {
	public static final String SYMBOL = "ð";
	private int countdown = 3;
	
	public Grenade(Game game, int x, int y) {
		super(game, x, y);}
	
	public String toString() {
		return SYMBOL + "[" + countdown + "]";}

	@Override
	public boolean receiveCollision(Player player) {
		return false;}

	@Override
	public boolean receiveShoot() {
		return false;}

	@Override
	public void onEnter() {
		alive = true;}

	@Override
	public void update() {
		countdown--;
		if (countdown == 0)
			onDelete();
	}

	@Override
	public void onDelete() {
		game.execute(new ExplotionAction());
		alive = false;
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}
}