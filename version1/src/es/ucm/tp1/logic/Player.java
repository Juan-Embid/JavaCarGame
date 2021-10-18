package es.ucm.tp1.logic;

import javax.security.auth.x500.X500PrivateCredential;

public class Player {
	public static final int INIT_COINS=0;
	public static final int STEP =1;
	private int x, y;
	private boolean alive = true;
	public Integer coinCounter=0, cycles = 0;
	private Game game;
	
	public Player(Game game) {
		this.game = game;
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
	
	public void update(int mov) {
		if(mov==-1) goup();
		else if(mov == 1)
			godown();
		cycles++;
	} 
	
	public int getCycle() {
		return cycles;
	}
	
	public void goup() {
		if(y+1!=game.getRoadWidth()) {
			y+=STEP;}
	}
		public void godown() {
			if(y-1>=0) {
				y-=STEP;
			}
		}
	public Boolean doPlayerCollision(Game game) {
		// coins
			Coin coin = game.getCoin(this.x, this.y);
			if(coin != null) {
				coin.receiveCollision();
				coinCounter++;
			}
			
			// obstacle
			Obstacle obstacle = game.getObstacle(this.x, this.y);
			if(obstacle != null)
				return true;
			return false;
	}
	
	public int getCoin() {
		return coinCounter;
	}
	
	public void reset() {
		initPos();
		coinCounter = 0;
		cycles = 0;
	}
	
	public String PlayerPositionToString(int x, int y) { //mostramos el coche en la carretera
		if (isInPosition(x, y))
			return statusToString();
		else
			return "";}
}