package es.ucm.tp1.view;

import es.ucm.tp1.utils.*;

import java.text.DecimalFormat;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;


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
		setRoad();

		margin = StringUtils.repeat(SPACE, MARGIN_SIZE);

		newLine =  System.getProperty("line.separator");
	}
	
	public void setRoad() {
		String roadBorder = ROAD_BORDER_PATTERN + StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) *  game.getVisibility());
		indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE,  game.getVisibility() - 1) + laneDelimiter + SPACE;

		indentedLlanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);
		newLine =  System.getProperty("line.separator");
		
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		setRoad();
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
			}
			if (y <  game.getRoadWidth() - 1) {
				str.append(this.indentedLlanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}
	


	
	public String endMessage(int mensaje){
		StringBuilder str = new StringBuilder();
		String s = GAME_OVER_MSG;
		switch (mensaje) {
		case 1:
			str.append(s + "Player leaves the game");
			break;
		case 2:
			if(!game.getActivate())
				str.append(s + "Player wins! New record!: " + game.getTime() + " s");
			else
				str.append(s + "Player wins!");
			break;
		default:
			str.append(s + "Player crashed!");
			break;
		}	
		return str.toString();
	}
	public String getInfo() {
		DecimalFormat df = new DecimalFormat("#.##");
		StringBuilder str = new StringBuilder();
		String distancia = String.valueOf(game.distanceTofinish());
		System.out.println("Distancia: " + distancia);
		System.out.println("Coins: " + game.getCoinCounter());
		System.out.println("Cycle: " + game.getCycles());
		System.out.println("Total obstacles: " + GameObject.getObstacles());
		System.out.println("Total coins: " + GameObject.getCoins());
		if (!game.getActivate())
			if (game.getCycles() == 0)
				System.out.println("Ellapsed time: 0.00 s");
			else
				System.out.println("Ellapsed time: " + df.format((double) ((System.currentTimeMillis() - game.GetInitTime()) / 1000.)) + " s");
		return str.toString();
	}
}