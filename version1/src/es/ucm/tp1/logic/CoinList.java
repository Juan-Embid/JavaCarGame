package es.ucm.tp1.logic;

public class CoinList {
	Game game;
	private Coin coinlist[][];
	private int cont; //Coins totales
	private static int MAX_COINS=30; //Coins máximas por partida
	
	public CoinList() {
	    this.cont=0;
	    this.coinlist=new Coin[game.getLength()][game.getRoadWidth()];}
	
	public void addcoin() {}
	
	public Coin getCoinInPosition(int x, int y) {
		return coinlist[x][y];}    //cambiar
	
	public double frequency() {
		return game.getCoinFrequency();
	}
}

/*La coin list va dentro de una clase. 
 * Definimos un array estático. 
 * Una clase que encapsula un array. 
 * Gracias a esta estructura podemos cambiar lo qeu queramos sin tener que modificar nada del Game. 
 * La idea es que no cambie el programa principal.
 */