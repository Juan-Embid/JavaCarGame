package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

public class Game {
	private Level level;
	private Long seed;
	private Player player;
	private CoinList coinList;
	private ObstacleList obstacleList;
	private int contObstacles = 0;
	private String lastCommand;
	private Boolean roadCoin = false;
	
	public void initializeGameObject() { //falta inicializar el player. Habría que hacer dos funciones y usarlas aquí (tryToAddObstacle y tryToAddCoin
		double frecuenciaObstacle = getObstacleFrequency()*100, frecuenciaCoin = getCoinFrequency()* 100;
		for(int x=5;x<getLength();x++) {
			for(int y=0;y<getRoadWidth();y++) {
				if(!(contObstacles == getRoadWidth() - 1) && (obstacleList.initialize(frecuenciaObstacle,x,y)))
						contObstacles++;
				else 
					if(!roadCoin && coinList.initialize(frecuenciaCoin,x,y))
						roadCoin = true;
		}
			roadCoin = false;
			 contObstacles = 0;
	}}
	
	public Game(long seed, Level level) {
		this.level = level;
		this.seed = seed;
	}
	
	public void toggleTest() { //desactiva la acción del tiempo
	}
	public void update() { //Se actualizan los objetos que están en el tablero. En este caso los obstáculos no se mueven, en futuras versiones sí tendrán comportamiento.
	}
	public void reset() {
	}
	public void goUp() {
		player.update(1);
	}
	public void goDown() {
		player.update(-1);
	}
	public int getVisibility() {
		return level.getVisibility();}
	
	public int getRoadWidth() {
		return level.getWidth();}
	
	public int getLength() {
		return level.getLength();}
	
	public String getGameStatus() {
		return ""; 	} //HARDCODED
	
	
	public String positionToString(int x, int y) { //MUESTRA POR PANTALLA LOS GAME OBJECTS
		/*if (!obstacleList.isPositionEmpty(x, y))
			return "o"; //Obstacle.toString();
		else if (!coinList.isPositionEmpty(x, y))
			return "c"; //Coin.toString();
		else return ">";*/
		return "";
		//else if detecta coche entonces devuelve char player
	}
	
	public double getCoinFrequency() { //Si no se mete aquí se mete dentro del coinList
		return level.getCoinFrequency();}
	
	public double getObstacleFrequency() { //Si no se mete aquí se mete dentro del ObstacleList
		return level.getObstacleFrequency();}
	
	public void doPlayerCollision(Player player, int x, int y) {
		// coins
		Coin coin = coinList.getObjectInPosition(x, y);
		if(coin != null) {
			coin.receiveCollision();
		}
		
		// obstacle
		Obstacle obstacle = obstacleList.getObjectInPosition(x, y);
		if(obstacle != null) {
			obstacle.receiveCollision(player);
		}
	}
	
	public void setLastCommand(String msg) {
		lastCommand = msg;
	}
	public int distanceTofinish() {
		return (getLength()-player.cycles);
	}
	
	public String getInfo() {
		StringBuilder str = new StringBuilder();
		str.append("[DEBUG] Executing: " + lastCommand);
		System.out.println(lastCommand);
			distanceTofinish();
			String distancia = String.valueOf(distanceTofinish());
			System.out.println(distancia);
			String coin=String.valueOf(distanceTofinish());
			//int cycles=player.returnCycle();
			//System.out.println(player.cycles);

		/*[DEBUG] Executing: el comando que hayamos metido en controller
		 * Distance: distancia a meta
		 * 
		 * Coins: las monedas que hemos cogido
		 * Cicle: el ciclo del juego en el que nos encontramos
		 -* Total Obstacles: el número total de obstáculos
		 * Total coins: el número total de coins
		 * Ellapsed Time: el tiempo que ha pasado desde que empezamos la partida*/
		return str.toString();
	}
}
