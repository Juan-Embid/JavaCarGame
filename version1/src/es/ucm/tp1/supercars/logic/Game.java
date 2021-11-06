package es.ucm.tp1.supercars.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Player;

public class Game {
	private Level level;
	private GameObjectContainer container;
	private GameObjectGenerator generator;
	private Long seed;
	private Player player;
	private int cycles = 0;
	private String lastCommand;
	private Boolean activate = false, exit=false;
	private long initTime;
	

	
	public Game(long seed, Level level) {
		this.seed = seed;
		this.level = level;
	}
	public void toggleTest() {
		activate = true;
	}
	public boolean update() {
		container.update(); //cada objeto tiene su propio update
		cycles++;
		return player.doPlayerCollision(this);
	}
	public void reset() {
		initTime = System.currentTimeMillis();
		GameObjectGenerator.reset();
		this.player = new Player(this, 0, this.level.getWidth()/2);
		player.reset();
		cycles = 0;	
		this.container = new GameObjectContainer();
		GameObjectGenerator.generateGameObjects(this, level);
				 
		}
	public void goUp() {
		player.update(1, this);
	}
	public void goDown() {
		player.update(-1, this);
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
		GameObject obj = container.isinPosition(x, y);
		if (obj != null)
			return obj.toString();
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
		System.out.println("Total obstacles: " + GameObject.getObstacles()); //la cuenta la tenemos dentro del coin y del obstacle
		System.out.println("Total coins: " + GameObject.getCoins());
		if (!activate)
			System.out.println("Ellapsed time: " + (System.currentTimeMillis() - initTime) / 1000. + " s");
		return str.toString();
	}

	public void tryToAddObject(GameObject gameobject, double coinFrequency) {
		if(container.isinPosition(gameobject.getX(), gameobject.getY())==null) {
			//Random y tener en cuenta la frecuencia
			container.Add(gameobject);
		}
	}

	public int getRandomLane() {
		Random rand = new Random();
		return rand.nextInt(level.getWidth());
		 //genera un número aleaatorio entre 0 y la anchura de la carretera
	}

	public Collider getObjectInPosition(int x, int y) {
		return container.isinPosition(x, y);
	}

	public boolean isFinished() {
		//Controla el final del juego.
		boolean exit =false;
		if(!player.isAlive()) exit = true;
		else if(distanceTofinish() == 0) exit = true;
		else if(this.exit) exit= true;
			return exit;	
		
	}
	public String PrintFinish() {
		String finalmes="Derrota";
		if(exit) {finalmes= "exit";}
		else if(distanceTofinish() == 0) {finalmes= "victory";}
		return finalmes;
	}

	public void setExit() {
		exit=true;
	}
}