package es.ucm.tp1.logic;

public class Obstacle {
	public static final String SYMBOL = "░";
	public int x, y;
	private boolean alive;
	private static int gameObstaclesCount;
	private static Game game;
	
	public Obstacle(int x, int y) {
		this.x = -1;
		this.y = -1;
	}
	
	public void reset() {
		gameObstaclesCount = 0; 
	} //Pone a cero las obstacles que se ha llevado el jugador
	
	public String toStringObj() {
		return SYMBOL;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void receiveCollision(Player player) {
		gameObstaclesCount--;
		//player.Die()
	}
}

