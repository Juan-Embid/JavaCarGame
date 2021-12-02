package es.ucm.tp1.view;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.GameObjectContainer;

public class GameSerializer extends View{
	
	public GameSerializer(Game game) {
		super(game);
		this.game=game;
	}

	public void printSerializer() {
		System.out.println("---- ROAD FIGHTER SERIALIZED ----");
		System.out.println("Level: " + game.getLevel());
		System.out.println("Cycles: " + game.getCycles());
		System.out.println("Coins: " + game.getCoinCounter());
		printTime();
		System.out.println("Game Objects:");
		System.out.println(game.playerSerializer());
		System.out.println(game.serializer());
	}
}