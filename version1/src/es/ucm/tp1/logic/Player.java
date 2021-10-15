package es.ucm.tp1.logic;

public class Player {
	public static final int INIT_COINS=5; //HARDCODED
	public static final int STEP =1;
	private int x = 2, y  = 1; //HARDCODED
	private boolean alive = true;
	private int coinCounter=0;
	Game game;
	Coin coin;
	Obstacle obstacle;
	
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
		else if(mov == -1) {
			godown();
		} x+=1;
	} 
	public void goup() {
		if(y+1!=game.getRoadWidth()) {
			y+=1;}
	}
		public void godown() {
			if(y-1!=0) {
				y-=1;
			}
		}
	public void doCollision() {
		game.doPlayerCollision(this, x, y);
	}
	public String PlayerPositionToString(int x, int y) { //mostramos el coche en la carretera
		if (isInPosition(x, y))
			return statusToString();
		else
			return "";}
}

/*hay que referenciar las cosas. 
 * Por ejemplo, si quiero saber si se ha salido de la carretera o no, tengo que llamar a game porque esa información ya está referenciada en game.
 *Los atributos siempre son privados
 *Integer es un objeto --> puedes usar métodos sobre él: equals() toString()
 *int no es nada*/