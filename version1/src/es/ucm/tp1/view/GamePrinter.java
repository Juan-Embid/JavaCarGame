package es.ucm.tp1.view;

import es.ucm.tp1.utils.*;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Player;


public class GamePrinter {

	private static final String SPACE = " ";

	private static final String ROAD_BORDER_PATTERN = "═";

	private static final String LANE_DELIMITER_PATTERN = "─";

	private static final int CELL_SIZE = 7;

	private static final int MARGIN_SIZE = 2;

	private String indentedRoadBorder;

	private String indentedLlanesSeparator;

	private String margin;
	
	private static final String GAME_OVER_MSG = "[GAME OVER] "; 
	
	public String newLine; 

	private Game game;
	
	
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
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		// Game Status
		str.append(game.getInfo());
		
		// Paint game

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;

		for (int y = 0; y < game.getRoadWidth(); y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = 0; x < game.getVisibility(); x++) {
				str.append(StringUtils.centre(game.positionToString(x, y), CELL_SIZE))
						.append(verticalDelimiter);
			}
			if (y <  game.getRoadWidth() - 1) {
				str.append(this.indentedLlanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}
	


	
	public String endMessage(String mensaje){
		StringBuilder str = new StringBuilder();
		String s = GAME_OVER_MSG;
		if (mensaje.equals("exit"))
			str.append(s + "Player leaves the game");
		else if (mensaje.equals("victory")) {
			if(!game.getActivate())
				str.append(s + "Player wins! New record!: " + game.getTime() + " s");
			else
				str.append(s + "Player wins!");
		}
		else 
			str.append(s + "Player crashed!");
		
		return str.toString();
	}
}