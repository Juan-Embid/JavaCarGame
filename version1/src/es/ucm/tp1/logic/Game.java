package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

public class Game {
	private Level level;
	private Long seed;
	private Player player;
	private CoinList coinList;
	private ObstacleList obstacleList;
	private int contObstacles = 0, cycles = 0;
	private String lastCommand;
	private Boolean roadCoin = false;
	private long initTime;
	
	public void initializeGameObject(long initTime_) {
		initTime = initTime_;
		double frecuenciaObstacle = getObstacleFrequency()*100, frecuenciaCoin = getCoinFrequency()* 100;
		for(int x=4;x<getLength() -1;x++) {
			for(int y=0;y<getRoadWidth();y++) {
				if(!(contObstacles >= 1) && (obstacleList.initialize(frecuenciaObstacle,x, y)))
						contObstacles++;
				else 
					if(!roadCoin && coinList.initialize(frecuenciaCoin,x, y))
						roadCoin = true;
		}
			roadCoin = false;
			 contObstacles = 0;
	}}
	
	public Game(long seed, Level level) {
		this.seed = seed;
		this.level = level;
		obstacleList = new ObstacleList(this);
		coinList = new CoinList();
		player = new Player(this);
	}
	
	public void toggleTest() { //desactiva la acción del tiempo
	}
	public boolean update() {
		obstacleList.update();
		coinList.update();
		cycles++;
		return player.doPlayerCollision(this);
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
	
	public Coin getCoin(int x, int y) {
		return coinList.getObjectInPosition(x, y);
	}
	
	public Obstacle getObstacle(int x, int y) {
		return obstacleList.getObjectInPosition(x, y);
	}
	
	public String positionToString(int x, int y) {
		if (!obstacleList.isPositionEmpty(x, y))
			return Obstacle.toStringObj();
		else if (!coinList.isPositionEmpty(x, y))
			return Coin.toStringCoin();
		else if (player.isInPosition(x, y))
			return player.PlayerPositionToString(x, y);
		else {
			if (distanceTofinish() == x) {
				return "¦";
			}
			return "";
		}
	}
	
	public double getCoinFrequency() { //Si no se mete aquí se mete dentro del coinList
		return level.getCoinFrequency();}
	
	public double getObstacleFrequency() { //Si no se mete aquí se mete dentro del ObstacleList
		return level.getObstacleFrequency();}
	
	public void setLastCommand(String msg) {
		lastCommand = msg;
	}
	public int distanceTofinish() {
		return (getLength()-cycles);
	}
	
	public String getInfo() {
		StringBuilder str = new StringBuilder();
		str.append("[DEBUG] Executing: " + lastCommand);
		String distancia = String.valueOf(distanceTofinish());
		System.out.println("Distancia: " + distancia);
		System.out.println("Coins: " + player.coinCounter);
		System.out.println("Cycle: " + cycles);
		System.out.println("Total obstacles: " + obstacleList.getObstacles());
		System.out.println("Total coins: " + coinList.getCoins());
		System.out.println("Ellapsed time: " + (System.currentTimeMillis() - initTime) / 1000. + " s");
		if (cycles > 0)
			System.out.print("");

			//int cycles=player.returnCycle();

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
