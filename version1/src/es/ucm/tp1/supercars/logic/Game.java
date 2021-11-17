package es.ucm.tp1.supercars.logic;

import java.text.DecimalFormat;
import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Player;

public class Game {
	private Level level;
	private GameObjectContainer container;
	private Long seed;
	private Player player;
	private int cycles = 0;
	private Boolean activate = false, exit=false;
	private long initTime = 0;
	private Random random;
		
	public Game(long seed, Level level) {
		this.seed = seed;
		this.level = level;
		random = new Random(seed);
	}
	public void toggleTest() {
		activate = true;
	}
	public boolean update() {
		//container.update();
		player.update();
		if (cycles == 0)
			initTime = System.currentTimeMillis();
		cycles++;
		return player.doPlayerCollision(this);
	}
	public void reset() {
		random = new Random(seed);
		GameObjectGenerator.reset();
		this.player = new Player(this, 0, this.level.getWidth()/2);
		player.reset();
		cycles = 0;	
		this.container = new GameObjectContainer();
		GameObjectGenerator.generateGameObjects(this, level);
				 
		}
public void reset(Long newSeed, Level newLevel) {
	seed =newSeed;
	level=newLevel;
	reset();
	}
	
	public void setSeed(long semilla) {
		seed = semilla;
	}
	
	public void setLevel(Level nivel) {
		if (nivel == null)
			setExit();
		level = nivel;
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
	
	public int getPlayerX() {
		return player.getX();
	}
	
	public String positionToString(int x, int y) {
		if (player.isInPosition(x, y))
			return player.statusToString();
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

	public int distanceTofinish() {
		return (getLength()-cycles);
	}
	
	
	
	public String getTime() {
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format((double) ((System.currentTimeMillis() - initTime) / 1000.));
	}
	public void tryToAddObject(GameObject gameobject, double coinFrequency) {
		int freq = (int) (coinFrequency * 100);
		int ran = random.nextInt(100);   
		if(container.isinPosition(gameobject.getX(), gameobject.getY())==null && ran <= freq) {
			container.Add(gameobject);
			container.onEnter(gameobject);
		}
	}

	public int getRandomLane() {
		return random.nextInt(level.getWidth());
	}

	public Collider getObjectInPosition(int x, int y) {
		return container.isinPosition(x, y);
	}

	public boolean isFinished() {
		boolean exit =false;
		if(!player.isAlive()) exit = true;
		else if(distanceTofinish() == 0) exit = true;
		else if(this.exit) exit= true;
			return exit;	
		
	}
	public int PrintFinish() {
		int finalmes=0;
		if(exit) {finalmes= 1;}
		else if(distanceTofinish() == 0) {finalmes=2;}
		return finalmes;
	}

	public void setExit() {
		exit=true;
	}
	public Level stringToLevel(String nivel) {
		return Level.valueOfIgnoreCase(nivel);
	}
	public int getCoinCounter() {
		
		return player.getCoin();
	}
	public int getCycles() {
		
		return cycles;
	}
	public long GetInitTime() {
		return initTime;
	}
	public void restart() {
		// TODO Auto-generated method stub
		
	}
	
}