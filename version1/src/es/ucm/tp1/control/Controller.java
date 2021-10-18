package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.CoinList;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	
	private long initialTime;

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"\n Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobjet info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */

	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);
	}

	public void printGame() {
		System.out.println(printer);
	}

	public void run() {
		boolean endGame = false, refreshDisplay=false;
		String finalMes = "derrota";
		initialTime = System.currentTimeMillis();
		game.initializeGameObject(initialTime);
		while (endGame != true) {	
			if(!refreshDisplay) printGame();
			System.out.print(PROMPT);
			String readLine = scanner.nextLine();
			readLine = readLine.toLowerCase();
			
			if (readLine.equals("h") || readLine.equals("help")) {
				game.setLastCommand("help");
				for (String string : HELP) 
					System.out.println(string);	
				refreshDisplay = true;}
			else if (readLine.equals("i") || readLine.equals("info")) {
				game.setLastCommand("info");
				System.out.println("Available objects:\n"
						+ "[Car] the racing car\n"
						+ "[Coin] gives 1 coin to the player\n"
						+ "[Obstacle] hits car");
				refreshDisplay = true;
			}
			else if (readLine.equals("n") || readLine.equals("none") || readLine.equals("")) {
				if (game.update())
					endGame = true;
				game.setLastCommand("none");
				refreshDisplay=false;
			}
			else if (readLine.equals("q")) {
				game.goUp();
				if (game.update())
					endGame = true;
				game.setLastCommand("goup");
				refreshDisplay=false;
			}
			else if (readLine.equals("a")) {
				game.goDown();
				if (game.update())
					endGame = true;
				game.setLastCommand("godown");
				refreshDisplay=false;
				}
			else if (readLine.equals("e") || readLine.equals("exit")) {
				endGame=true;
				finalMes = "exit";
				game.setLastCommand("exit");}
			else if (readLine.equals("r") || readLine.equals("reset")) {
				game.reset();
				game.setLastCommand("reset");
			}
			else if (readLine.equals("t") || readLine.equals("test")) {
				game.toggleTest();
				game.setLastCommand("test");
			}
			else {
				System.out.println(UNKNOWN_COMMAND_MSG);
				refreshDisplay=true;}
			if (game.distanceTofinish() == 0) {
				endGame = true;
				finalMes = "victory";
			}
	}
		printGame();
		System.out.println(printer.endMessage(finalMes, initialTime));}  	
}