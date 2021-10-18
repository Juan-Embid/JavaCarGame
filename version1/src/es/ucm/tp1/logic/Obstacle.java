package es.ucm.tp1.logic;

public class Obstacle {
	public static final String SYMBOL = "░";
	public int x, y;
	private boolean alive;
	private static Game game;
	
	public Obstacle() {
		this.x = -1;
		this.y = -1;
	}
	
	public static String toStringObj() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive;
	}
}

