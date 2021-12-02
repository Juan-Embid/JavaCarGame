package es.ucm.tp1.view;
import es.ucm.tp1.logic.Game;

public class GameSerializer extends View{
	Game game;
	
	public void printSerializer() {
		System.out.println("---- ROAD FIGHTER SERIALIZED ----");
		System.out.println("Level: " + game.getLevel());
		System.out.println("Cycles: " + game.getCycles());
		System.out.println("Coins: " + game.getCoinCounter());
	}
}