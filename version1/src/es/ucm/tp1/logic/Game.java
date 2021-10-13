package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {
	private Level level;
	private Player player;
	private CoinList coinList;
	private ObstacleList obstacleList;
	
	public Game(long seed, Level level) {
		// TODO
		this.level = level;
	}
	
	public void toggleTest() {
		// TODO
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
		return ""; 	} //HARDCODED
	
	public double getCoinFrequency() { //Si no se mete aquí se mete dentro del coinList
		return level.getCoinFrequency();}
	
	public double getObstacleFrequency() { //Si no se mete aquí se mete dentro del ObstacleList
		return level.getObstacleFrequency();}
}
