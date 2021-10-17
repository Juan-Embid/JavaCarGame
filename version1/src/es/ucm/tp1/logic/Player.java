package es.ucm.tp1.logic;

public class Player {
	public static final int INIT_COINS=0; //HARDCODED
	public static final int STEP =1;
	private int x, y; 
	private boolean alive = true;
	public Integer coinCounter=0, cycles = 0;
	private Game game;
	
	public Player(Game game) { //no se que es, pero lo puso el profe en la pizarra
		this.game = game;
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
		if(mov==1) goup();
		else if(mov == -1)
			godown();
		x+=STEP;
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
	public void doCollision() {
		game.doPlayerCollision(this, x, y);
	}
	
	public void getCoin() {
		//game.getcoin o como se tenga que hacer
		//coinCounter
	}
	
	public String PlayerPositionToString(int x, int y) { //mostramos el coche en la carretera
		if (isInPosition(x, y))
			return statusToString();
		else
			return "";}
}