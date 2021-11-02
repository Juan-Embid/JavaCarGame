package es.ucm.tp1.supercars.logic.gameobjects;

import java.util.Random;

import es.ucm.tp1.supercars.logic.Game;

public class ObstacleList {
	private static Game game;
	private static int MAX_OBSTACLE;
	private Obstacle obstacles[];
	private int cont;

	public ObstacleList(Game game) {
		cont=0;
		MAX_OBSTACLE = (int) ((int)game.getLength() * game.getObstacleFrequency());
		obstacles = new Obstacle[MAX_OBSTACLE];
		for (int i = 0; i < MAX_OBSTACLE; i++)
			this.obstacles[i] =new Obstacle();
	}
	public boolean initialize(double frecuencia, int x, int y) {
		Random rand = new Random();
		int probab = rand.nextInt(100);
		if(frecuencia<probab && cont < MAX_OBSTACLE) {
			obstacles[cont].x=x;
			obstacles[cont].y=y;
			addObstacle();
			return true;
		}else {return false;}
	}
	public void addObstacle() {
		cont++;
	}
	
	public void reset() {
		cont = 0;
	}
	
	public void update() {
		for (int i = 0; i < MAX_OBSTACLE; i++)
			this.obstacles[i].x--;
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
	
	
	public int getObstacles() {
		return cont;
	}
	
	public boolean isPositionEmpty(int x, int y){
		return getObjectInPosition(x, y) == null;
	}
}

