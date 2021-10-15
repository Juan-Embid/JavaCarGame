package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

public class Game {
	private Level level;
	private Long seed;
	private Player player;
	private CoinList coinList;
	private ObstacleList obstacleList;
	private int cycles = 0;
	private String lastCommand;
	
	public void initializeGameObject() {
		double frecuenciaObstacle = getObstacleFrequency()*100;
		for(int x=0;x<getLength();x++) {
			for(int y=0;y<getRoadWidth();y++) {
				if(!obstacleList.initialize(frecuenciaObstacle,x,y)){
					//Aquí solo hay que hacer lo de abajo
					coinList.initialize(frecuenciaObstacle,x,y);
					//se inicializa un obstaculo por lo que en este ciclo no caben más objetos
			}
							
		}
	}}
	public int distanceTofinish() {
		int distancia=getLength()-cycles;
		
		return distancia;
	}
	
	public Game(long seed, Level level) {
		// TODO
		this.level = level;
		this.seed = seed;
	}
	
	public void toggleTest() {
		// TODO
	}
	public void update() {
		cycles++;
	}
	public void goUp() {
		player.update(1);
	}
	public void goDown() {
		player.update(-1);
	}
	public int getVisibility() {
		return level.getVisibility();}
	
	public int getRoadWidth() {
		return level.getWidth();}
	
	public int getLength() {
		return level.getLength();}
	
	public String getGameStatus() {
		return ""; 	} //HARDCODED
	
	
public String positionToString(int x, int y) {
//IMPORTANTE PARA ENSEÑAR GAMEOBJECTS
	//-----------
	
	//(int i=0;)
		return ""; 	} //HARDCODED
	
	public double getCoinFrequency() { //Si no se mete aquí se mete dentro del coinList
		return level.getCoinFrequency();}
	
	public double getObstacleFrequency() { //Si no se mete aquí se mete dentro del ObstacleList
		return level.getObstacleFrequency();}
	
	public void doPlayerCollision(Player player, int x, int y) {
		// coins
		Coin coin = coinList.getObjectInPosition(x, y);
		if(coin != null) {
			coin.receiveCollision();
		}
		
		// obstacle
		Obstacle obstacle = obstacleList.getObjectInPosition(x, y);
		if(obstacle != null) {
			obstacle.receiveCollision(player);
		}
	}
	public int returnCycle() {
		return cycles;
	}
}
