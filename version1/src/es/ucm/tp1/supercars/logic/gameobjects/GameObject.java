package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObject implements Collider {

	protected int x, y;
	
	protected Game game;
	Coin coin;
	Obstacle obstacle;
	Truck truck;
	static SuperCoin supercoin;
	protected String symbol;

	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
	}
	
	public static int getCoins() {
		return Coin.cont;
	}
	
	public static int getObstacles() {
		return Obstacle.cont;
	}
	
	protected String getSymbol() {
		
		return symbol;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}

		return "";
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public static boolean superCoinIsPresent() {
		return SuperCoin.alive;
	}
	public boolean isAlive() {
		return true;
	}
	public boolean ObstacleisAlive() {
		return obstacle.isAlive();
	}
	public boolean CoinisAlive() {
		return coin.isAlive();
	}
	
	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();

}