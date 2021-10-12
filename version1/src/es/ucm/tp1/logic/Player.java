package es.ucm.tp1.logic;

public class Player {
	public static final int INIT_COINS=5; //HARDCODED
	public static final int STEP =1;
	private int x1 = 3, y1  = 1; //HARDCODED
	private boolean alive = true;
	
	Game game;
	
	public Player(Game game) { //no se que es, pero lo puso el profe en la pizarra
		this.game = game;
		}
	
	public boolean isInPosition(int x, int y) {
		return (x1 == x && y1 == y);
	}
	
	public String statusToString() {
		if (alive == true) 
			return ">";
		else
			return "@";
	}
}

/*hay que referenciar las cosas. 
 * Por ejemplo, si quiero saber si se ha salido de la carretera o no, tengo que llamar a game porque esa información ya está referenciada en game.
 *Los atributos siempre son privados
 *Integer es un objeto --> puedes usar métodos sobre él: equals() toString()
 *int no es nada*/