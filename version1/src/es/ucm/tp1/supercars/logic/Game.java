package es.ucm.tp1.supercars.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Player;

public class Game {
	private Level level;
	private GameObjectContainer container;
	private Long seed;
	private Player player;
	private int contObstacles = 0, cycles = 0;
	private String lastCommand;
	private Boolean activate = false;
	private long initTime;
	
	public void initializeGameObject(long initTime_) {
		initTime = initTime_;
		player.initPos();
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
	}
	public void toggleTest() {
		activate = true;
	}
	public boolean update() {
		obstacleList.update();
		coinList.update();
		cycles++;
		return player.doPlayerCollision(this);
	}
	public void reset() {
		initTime = System.currentTimeMillis();
		generator.reset(level);
		initializeGameObject(initTime);
		player.reset();
		cycles = 0;
	}
	public void goUp() {
		player.update(1);
	}
	public void goDown() {
		player.update(-1);
	}
	
	public boolean getActivate() {
		return activate;
	}
	
	public int getVisibility() {
		return level.getVisibility();}
	
	public int getRoadWidth() {
		return level.getWidth();}
	
	public int getLength() {
		return level.getLength();}
	
	public Coin getCoin(int x, int y) {
		return coinList.getObjectInPosition(x, y);
	}
	
	public Obstacle getObstacle(int x, int y) {
		return obstacleList.getObjectInPosition(x, y);
	}
	
	public String positionToString(int x, int y) {
		if (!obstacleList.isPositionEmpty(x, y))
			return Obstacle.toStringObj();
		else if (player.isInPosition(x, y))
			return player.PlayerPositionToString(x, y);
		else if (!coinList.isPositionEmpty(x, y))
			return Coin.toStringCoin();
		else {
			if (distanceTofinish() == x) {
				return "¦";
			}
			return "";
		}
	}
	
	public double getCoinFrequency() {
		return level.getCoinFrequency();}
	
	public double getObstacleFrequency() {
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
		if (!activate)
			System.out.println("Ellapsed time: " + (System.currentTimeMillis() - initTime) / 1000. + " s");
		return str.toString();
	}

	public void tryToAddObject(GameObject gameobject, double coinFrequency) {
		// TODO Auto-generated method stub
		if(gameobject.getX()!=container.getpositionX() && gameobject.getY()!=container.getpositionY()) {
			
		}
		
		
	}

	public int getRandomLane() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collider getObjectInPosition(int x, int y) {
		// TODO Auto-generated method stub
		//if(x==)
		return null;
	}

	public boolean isFinished() {
		//Controla el final del juego.
		return false;
	}
}
