package es.ucm.tp1.logic;

import java.util.Random;

public class CoinList {
	private Coin coins[];
	private int cont;
	private static int MAX_COINS=30;

	public CoinList() {
		this.cont=0;
		this.coins=new Coin[MAX_COINS];
	}
	
	public void initialize(double frecuencia, int x, int y) {
		Random rand = new Random();
		int probab = rand.nextInt(100);
		if(frecuencia<=probab && cont <= MAX_COINS) {
			coins[cont].x=x;
			coins[cont].y=y;
			cont++;
		}
		}
	
	public void addcoin() {
		cont++;
	}
	public Coin getObjectInPosition(int x, int y) {
		Coin foundCoin = null;
		for (int i = 0; i < coins.length && foundCoin == null; i++) {
			if(coins[i].x == x && coins[i].y==y) {
				foundCoin = coins[i];
			}
		}
		return foundCoin;
	}
	
	public void removeDead() {
		Coin aux[] = new Coin[MAX_COINS];
		int i = 0;
		for (Coin coin : coins) {
			if(coin.isAlive()) {
				aux[i] = coin;
				i++;
			}
		}
		coins = aux;
	}
	public boolean isPositionEmpty(int x, int y){
		return getObjectInPosition(x, y) == null;
	}
}


