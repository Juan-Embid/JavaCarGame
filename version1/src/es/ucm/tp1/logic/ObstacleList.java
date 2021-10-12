package es.ucm.tp1.logic;

public class ObstacleList {
	Game game;
	private Obstacle obstacleList[][];
	private int cont; //Coins totales
	private static int MAX_OBSTACLE=70; //HARDCODED
	
	public ObstacleList() {
	    this.cont=0;
	    this.obstacleList=new Obstacle[game.getLength()][game.getRoadWidth()];}
	
	public void addcoin() {}
	
	public Obstacle getObjectInPosition(int x, int y) {
		return obstacleList[x][y];}    //HARDCODED
	
	public double frequency() {
		return game.getObstacleFrequency();
	}
}
