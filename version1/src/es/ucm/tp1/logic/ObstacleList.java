package es.ucm.tp1.logic;

import java.util.Random;

public class ObstacleList {
	private Obstacle obstacles[];
	private int cont; //obstacles totales
	private static int MAX_OBSTACLE=70; //HARDCODED

		public ObstacleList() {
			this.cont=0;
			this.obstacles =new Obstacle[MAX_OBSTACLE];
		}
		public boolean initialize(double frecuencia, int x, int y) {
			Random rand = new Random();
			int probab = rand.nextInt(100);
			if(frecuencia<=probab && cont <= MAX_OBSTACLE) {
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
		
		public boolean isPositionEmpty(int x, int y){
			return getObjectInPosition(x, y) == null;
		}
	}

