package es.ucm.tp1.logic;

public class Obstacle {
	public static final String SYMBOL = "░";
	public int x, y;
	private static int gameObstaclesCount;
	private static Game game;
	
	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void reset() {
		gameObstaclesCount = 0; 
	} //Pone a cero las obstacles que se ha llevado el jugador
	
	public String toString() {
		return SYMBOL;
	}
	
	public void receiveCollision(Player player) {
		gameObstaclesCount--;
		//player.Die()
	}
}

