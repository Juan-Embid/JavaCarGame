package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo extends GameObject {
	public static final String SYMBOL = ">>>";
	private static final int STEP = 3;
	public int x, y;
	
	public Turbo(Game game, int x, int y) {
		super(game, x, y);}

	public String toString() {
		return SYMBOL;}
	
	
	public boolean isAlive() {
		return alive;}

	@Override
	public boolean receiveCollision(Player player) {
		player.doTurbo(STEP);
		alive=false;
		return false;
	}

	@Override
	public boolean receiveShoot() {
		return false;}

	@Override
	public void onEnter() {	
		alive=true;}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
		alive = false;}

	@Override
	public boolean receiveExplosion() {
		return false;}
}