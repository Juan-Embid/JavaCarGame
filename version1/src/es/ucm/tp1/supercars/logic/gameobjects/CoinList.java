package es.ucm.tp1.supercars.logic.gameobjects;

import java.util.Random;

import es.ucm.tp1.supercars.logic.Game;

public class CoinList {
	private static int MAX_COINS;
	private Coin coins[];
	private int cont;
	
	public CoinList(Game game) {
		MAX_COINS = (int) ((int)game.getLength() * game.getCoinFrequency());
		coins = new Coin[MAX_COINS];
		cont=0;
		for (int i = 0; i < MAX_COINS; i++)
			this.coins[i]=new Coin();
	}
	
	public Boolean initialize(double frecuencia, int x, int y) {
		Random rand = new Random();
		int probab = rand.nextInt(100);
		if(frecuencia<probab && cont < MAX_COINS) {
			coins[cont].x=x;
			coins[cont].y=y;
			addcoin();
			return true;
		}
		else {return false;}
		}
	
	public void addcoin() {
		cont++;
	}
	
	public void update() {
		for (int i = 0; i < MAX_COINS; i++)
			this.coins[i].x--;
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
	
	public int getCoins() {
		return cont;
	}
	
	public void reset() {
		cont = 0;
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


