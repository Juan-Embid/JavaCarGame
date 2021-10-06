package es.ucm.tp1.control;

import java.security.UnrecoverableKeyException;
import java.util.Scanner;

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
		boolean endLoop = false;
		while (endLoop != true) {
		Scanner sc = new Scanner(System.in);
		printGame();
		String readLine = sc.nextLine();
		readLine = readLine.toLowerCase();
		if (readLine.startsWith("h")) 
			for (String string : HELP) 
				System.out.println(string);	
		else if (readLine.startsWith("i"))
			System.out.println("hola");
		else if (readLine.startsWith("n"))
			System.out.println("hola"); //TODO hacer bien estas cosas
		else if (readLine.startsWith("q"))
			System.out.println("hola");
		else if (readLine.startsWith("a"))
			System.out.println("hola");
		else if (readLine.startsWith("e")) endLoop=true;
		else if (readLine.startsWith("r"))
			System.out.println("hola");
		else if (readLine.startsWith("t"))
			System.out.println("hola");
		else
			System.out.println(UNKNOWN_COMMAND_MSG);
				
	}}}