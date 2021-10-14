package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.CoinList;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
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
	

	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}

	public void run() {
		// TODO
		boolean endGame = false, refreshDisplay=true;
		while (endGame != true) {
			
			// Draw
			if(refreshDisplay) printGame();
			
			// User action
			String readLine = scanner.nextLine();
			readLine = readLine.toLowerCase();
			if (readLine.equals("h") || readLine.equals("help")) {
				printer.setLastCommand("help");
				for (String string : HELP) 
					System.out.println(string);	}
			else if (readLine.equals("i") || readLine.equals("info")) {
				printer.setLastCommand("info");
				//System.out.println(game.getInfo());
				//game.cont++;
				// refreshDisplay = false;
			}
			else if (readLine.equals("n") || readLine.equals("none")) {
				refreshDisplay=true;
				printer.setLastCommand("none");
				//game.cont++;//TODO hacer bien estas cosas
			}
			else if (readLine.equals("q")) {
				printer.setLastCommand("goup");
			}
				//game.goUp(); // que llama al player.goUp y update()
				//game.cont++;
			// refreshDisplay = true; 
			else if (readLine.equals("a")) {
				printer.setLastCommand("godown");
				System.out.println("hola");}
			else if (readLine.equals("e")) {endGame=true;
			printer.setLastCommand("exit");}
			else if (readLine.equals("r")) {
				System.out.println("hola");
				printer.setLastCommand("reset");
			}
			else if (readLine.equals("t")) {
				System.out.println("hola");
				printer.setLastCommand("test");
			}
			else
				System.out.println(UNKNOWN_COMMAND_MSG);
			
			// Update
			// Check end
	}System.out.println(printer.endMessage());}  	
}