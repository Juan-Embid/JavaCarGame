package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject {
	public static final int INIT_COINS=0;
	public static final int STEP =1;
	private int x, y;
	private boolean alive = true;
	private Integer coinCounter=0, cycles = 0;
	private static Game game;
	
	public Player(Game game, int x, int y) {
		super(game, x, y);
		this.x=x;
		this.y=y;
		}
	
	public void initPos() {
			x = 0;
			y = game.getRoadWidth()/ 2; 
	}

	public boolean isInPosition(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	public String statusToString() {
		if (alive == true) 
			return ">";
		else
			return "@";
	}
	
	public void update(int mov, Game width) {
		if(mov==-1) goUp(width);
		else 
			goDown();
		cycles++;
	} 
	
	public int getCycle() {
		return cycles;
	}
	
	public void goUp(Game width) {
		if(y + STEP != width.getRoadWidth()) {
			y += STEP;
		}
	}
	
	public void goDown() {
		if(y - STEP >= 0) {
			y -= STEP;
		}
	}
	public Boolean doPlayerCollision(Game game) {
		// coins
		Collider other = game.getObjectInPosition(x, y);
		if (other != null) {
		return other.receiveCollision (this);
		}
		return false;
	}
	public int getCoin() {
		return coinCounter;
	}
	
	public void reset() {
		coinCounter = 0;
		cycles = 0;
	}
	
	@Override
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
		if (other != null) {
		return other.receiveCollision (this);
		}
		return false;
	}
	
	public boolean isAlive() {
		return alive;
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void update() {
		x++;
	}

	@Override
	public void onDelete() {
		
	}

	public void AddCoin() {
		coinCounter++;
	}

	public void SetNotAlive() {
		alive=false;
	}
	public int getX() {
		return x;
	}
}