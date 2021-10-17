package es.ucm.tp1.logic;

import java.util.Random;

public class ObstacleList {
	private static Game game;
	private Obstacle obstacles[];
	private int cont;
	private static int MAX_OBSTACLE=  (int) ((int)game.getLength() * game.getObstacleFrequency()); 

	public ObstacleList(Game game) {
		cont=0;
		for (int i = 0; i < MAX_OBSTACLE; i++)
			this.obstacles[i] =new Obstacle();
	}
	public boolean initialize(double frecuencia, int x, int y) {
		Random rand = new Random();
		int probab = rand.nextInt(100);
		if(frecuencia<probab && cont < MAX_OBSTACLE) {
			obstacles[cont].x=x;
			obstacles[cont].y=y;
			cont++;
			return true;
		}else {return false;}
	}
	public void addcoin() {
		cont++;
	}
	public Obstacle getObjectInPosition(int x, int y) {
		Obstacle foundObstacle = null;
		for (int i = 0; i < obstacles.length && foundObstacle == null; i++) {
			if(obstacles[i].x == x && obstacles[i].y==y) {
				foundObstacle = obstacles[i];
			}
		}
		return foundObstacle;
	}
	
	public Boolean isPositionEmpty(int x, int y){ //he cambiado boolean por Boolean
		return getObjectInPosition(x, y).equals(null); //NO SE SI HAY QUE PONER .EQUALS() O ==. CREO QUE ES EQUALS PORQUE ES UN OBJETO
	}
}

