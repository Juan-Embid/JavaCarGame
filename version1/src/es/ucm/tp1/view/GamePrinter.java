package es.ucm.tp1.view;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.*;
import es.ucm.tp1.logic.Player; //cambiado


public class GamePrinter {

	private static final String SPACE = " ";

	private static final String VERTICAL_DELIMITER = "|";

	private static final String ROAD_BORDER_PATTERN = "═";

	private static final String LANE_DELIMITER_PATTERN = "─";

	private static final int CELL_SIZE = 7;

	private static final int MARGIN_SIZE = 2;

	private String indentedRoadBorder;

	private String indentedLlanesSeparator;

	private String margin;
	private String board[][];


	private static final String CRASH_MSG = String.format("Player crashed!%n");

	private static final String WIN_MSG = String.format("Player wins!%n");

	private static final String DO_EXIT_MSG = "Player leaves the game"; 
	
	private static final String GAME_OVER_MSG = "[GAME OVER] "; 
	
	public String newLine; 

	private Game game;
	
	private Player player;
	
	private String lastCommand;

	public GamePrinter(Game game) {
		this.game = game;
		

		margin = StringUtils.repeat(SPACE, MARGIN_SIZE);

		String roadBorder = ROAD_BORDER_PATTERN + StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) *  game.getVisibility());
		indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE,  game.getVisibility() - 1) + laneDelimiter + SPACE;

		indentedLlanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);
		newLine =  System.getProperty("line.separator");
		

		newLine =  System.getProperty("line.separator");
	}
	
	/*private void encodeGame(Game game) {
		board = new String[num][]
	}*/

	public void setLastCommand(String msg) {
		lastCommand = msg;
	}
	
	private String getInfo() {
		StringBuilder str = new StringBuilder();
		str.append("[DEBUG] Executing: " + lastCommand);
		System.out.println(lastCommand);
			game.distanceTofinish();
			String distancia = String.valueOf(game.distanceTofinish());
			System.out.println(distancia);
			String coin=String.valueOf(game.distanceTofinish());
			int cycles=game.returnCycle();
			System.out.println(cycles);
		// TODO add your code
		/*[DEBUG] Executing: el comando que hayamos metido en controller
		 * Distance: distancia a meta
		 * 
		 * Coins: las monedas que hemos cogido
		 * Cicle: el ciclo del juego en el que nos encontramos
		 -* Total Obstacles: el número total de obstáculos
		 * Total coins: el número total de coins
		 * Ellapsed Time: el tiempo que ha pasado desde que empezamos la partida*/
		return str.toString();
	}

	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		// Game Status
		str.append(getInfo());
		
		// Paint game

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;

		for (int y = 0; y < game.getRoadWidth(); y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = 0; x < game.getVisibility(); x++) {
				str.append(StringUtils.centre(game.positionToString(x, y), CELL_SIZE))
						.append(verticalDelimiter);
				//PlayerPositionToString(x, y); //ADDED, 
			}
			if (y <  game.getRoadWidth() - 1) {
				str.append(this.indentedLlanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}
	
	/*public String PlayerPositionToString(int x, int y) { //mostramos el coche en la carretera
		if (player.isInPosition(x, y))
			return player.toString();
		else
			return "";}*/

	
	public String endMessage(){
		
		String s = GAME_OVER_MSG;
		
		// TODO your code here
		/*Si el jugador gana se imprime: [GAME OVER] Player wins! New record!: 4.85 s
		 *Si el jugador pierde se imprime: [GAME OVER] Player crashed! 
		 *Si el jugador sale de la partida: [GAME OVER] Player leaves the game
		 *
		 *Tenemos variables para los tres mensajes*/
		
		return s;
	}
}
