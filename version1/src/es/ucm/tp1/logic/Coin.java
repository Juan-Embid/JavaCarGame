package es.ucm.tp1.logic;

public class Coin {
	public static final String SYMBOL = "¢";
	public int x, y;
	private boolean alive;
	private static Game game;
	
	public Coin() {
		this.x = -1;
		this.y = -1;
		alive = true;
	}
	
	public static String toStringCoin() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void receiveCollision() {
		alive = false;
	}
}


