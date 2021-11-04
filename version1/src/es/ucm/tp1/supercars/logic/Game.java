package es.ucm.tp1.supercars.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Player;

public class Game {
	private Level level;
	private GameObjectContainer container;
	private GameObject gameobjects;
	private GameObjectGenerator generator;
	private Long seed;
	private Player player;
	private int contObstacles = 0, cycles = 0;
	private String lastCommand;
	private Boolean activate = false, exit=false;
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
		container.update(); //cada objeto tiene su propio update
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
	
	/*public Coin getCoin(int x, int y) {
		return coinList.getObjectInPosition(x, y);
	}
	
	public Obstacle getObstacle(int x, int y) {
		return obstacleList.getObjectInPosition(x, y);
	}*/
	
	public String positionToString(int x, int y) { //mostrabamos los objetos por pantalla
		if (player.isInPosition(x, y)) //TODO pasar por whatsapp
			return player.PlayerPositionToString(x, y);
		else if (!gameobjects.isInPosition(x, y))
			return gameobjects.toString();
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
		System.out.println("Total obstacles: " + getObstacle().toString() ); //la cuenta la tenemos dentro del coin y del obstacle
		System.out.println("Total coins: " + getCoin().toString());
		if (!activate)
			System.out.println("Ellapsed time: " + (System.currentTimeMillis() - initTime) / 1000. + " s");
		return str.toString();
	}

	public void tryToAddObject(GameObject gameobject, double coinFrequency) {
		if(gameobject.getX()!=container.getpositionX() && gameobject.getY()!=container.getpositionY()) {
			//Random y tener en cuenta la frecuencia
			container.update(gameobject);
		}
		
		
	}

	public int getRandomLane() {
		return 0; //genera un número aleaatorio entre 0 y la anchura de la carretera
	}

	public Collider getObjectInPosition(int x, int y) {
		//if(x==)
		return null;
	}

	public boolean isFinished() {
		//Controla el final del juego.
		if(!player.isAlive() ||distanceTofinish() == 0 || exit) {
			return false;	
		}else return true;
		
	}
	public String PrintFinish() {
		String finalmes="Derrota";
		if(exit) {finalmes= "exit";}
		else if(distanceTofinish() == 0) {finalmes= "victory";}
		return finalmes;
	}
	public Integer getCoin() {
		Integer coins= Integer.valueOf(gameobjects.getterCoin());
		return coins;
		
	}
	public Integer getObstacle() {
		Integer obstacles= Integer.valueOf(gameobjects.getterObstacle());
		return obstacles;
	}
}
