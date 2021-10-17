package es.ucm.tp1.logic;

public class Coin {
	public static final String SYMBOL = "¢";
	public int x, y;
	private boolean alive;
	private static int gameCoinsCount;
	private static Game game;
	
	public Coin(int x, int y) {
		this.x = -1;
		this.y = -1;
		alive = true;
	}
	
	public static void reset() {
		gameCoinsCount = 0; 
	} //Pone a cero las coins que se ha llevado el jugador
	
	public static String toStringCoin() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void receiveCollision() {
		gameCoinsCount--;
		alive = false;
	}
}


