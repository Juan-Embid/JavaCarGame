package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject {
	public static final int INIT_COINS=0;
	public static final int STEP =1;
	private static int x, y;
	private boolean alive = true;
	public Integer coinCounter=0, cycles = 0;
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
		if(mov==-1) goup(width);
		else if(mov == 1)
			godown();
		cycles++;
	} 
	
	public int getCycle() {
		return cycles;
	}
	
	public void goup(Game width) {
		if(y+1!=width.getRoadWidth()) {
			y+=STEP;}
	}
		public void godown() {
			if(y-1>=0) {
				y-=STEP;
			}
		}
	public Boolean doPlayerCollision(Game game) {
		// coins
		Collider other = game.getObjectInPosition(x, y);
		if (other != null) {
		return other.receiveCollision (this);
		}
		return false;
		/*
			Coin coin = game.getCoin(this.x, this.y);
			if(coin != null) {
				coin.receiveCollision();
				coinCounter++;
			}
			
			// obstacle
			Obstacle obstacle = game.getObstacle(this.x, this.y);
			if(obstacle != null)
				return true;
			return false;*/
	}
	
	public int getCoin() {
		return coinCounter;
	}
	
	public void reset() {
		//initPos();
		coinCounter = 0;
		cycles = 0;
	}
	
	public String PlayerPositionToString(int x, int y) { //mostramos el coche en la carretera
		if (isInPosition(x, y))
			return statusToString();
		else
			return "";}

	@Override
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
		if (other != null) {
		return other.receiveCollision (this);
		}
		return false;
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
		
	}

	@Override
	public void onDelete() {
		
	}

	public void AddCoin() {
		coinCounter++;
	}

	public void SetAlive() {
		alive=false;
	}
}