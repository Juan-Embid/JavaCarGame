package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {
	private Level level;
	
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
	
	public String getGameStatus() {
		return ""; 	} //HARDCODED
	
	public String positionToString(int x, int y) {
		return ""; 	} //HARDCODED
}
