package es.ucm.tp1.supercars.logic;

import java.text.DecimalFormat;
import java.util.Random;

import actions.InstantAction;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Player;

public class Game {
	private Level level;
	private GameObjectContainer container;
	private GameObject gameobject;
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
	public void update() {
		player.update();
		player.doPlayerCollision(this);
		container.update();
		GameObjectGenerator.generateRuntimeObjects(this);
		if (cycles == 0)
			initTime = System.currentTimeMillis();
		cycles++;
		eraseContainer();
	}
	public void reset() {
		random = new Random(seed);
	//	GameObjectGenerator.reset();
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
	
	public int getPlayerY() {
		return player.getY();
	}
	
	public String positionToString(int x, int y) {
		StringBuilder str = new StringBuilder();
		
		if (player.isInPosition(x, y))
			str.append(player.statusToString())
				.append(" ");
		GameObject obj = container.isinPosition(x, y);
		if (obj != null)
			str.append(obj.toString())
				.append(" ");
		else {
			if (level.getLength() == x) {
				str.append("¦");
			}
			//return "";
		}
		return str.toString();
	}
	
	public double getCoinFrequency() {
		return level.getCoinFrequency();}
	
	public double getObstacleFrequency() {
		return level.getObstacleFrequency();}

	public int distanceTofinish() {
		return (getLength()-player.getCycle());
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

	public GameObject getObjectInPosition(int x, int y) {
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
		
	}
	public void forceAddObject(GameObject o) {
		
	}
	public Level getLevel() {
		return level;
	}
	public void execute(InstantAction thunder) {
		
	}
	
	public void firstCollision() {
		player.doPlayerCollision(this);
	}
	
	public void eraseContainer() {
		container.erase();
	}
	/*public void setTurbo(int step) {
		container.doTurbo(step);
	}*/
	public boolean shoot() {
		if(player.getCoin()>0) {
			player.lessCoin();
			for (int i = player.getCycle(); i < player.getCycle() + getVisibility(); i++) {
				GameObject obj = container.isinPosition(i, getPlayerY());
				if(obj != null) {
					if(obj.receiveShoot()) {
						return true;
					}	
				}
		}
			}
			return false;
	}
	public void loseCoins() {
		player.resetCoin();
		
	}
	public boolean buy(int cost) {
		if(player.getCoin()>=cost) {
			for(int i=0;i<cost;i++) {
			player.lessCoin();
			}
			return true;
		}
		return false;
	}}