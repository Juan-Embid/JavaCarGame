package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.supercars.control.commands.Command;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	
	private long initialTime;

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
		boolean refreshDisplay=true;
		game.reset();
		while (!game.isFinished()) {	
			if (refreshDisplay ) {
				printGame();
				}
				refreshDisplay = false;
				System.out.print(PROMPT);
				String s = scanner.nextLine();
				String[] parameters = s.toLowerCase().trim().split(" ");
				System.out.println("[DEBUG] Executing: " + s);
				Command command = Command.getCommand(parameters);
				if (command != null) {
				refreshDisplay = command.execute(game);
				} else {
				System.out.println("[ERROR]: "+ UNKNOWN_COMMAND_MSG);
				}
			}
		printGame();
		System.out.println(printer.endMessage(game.PrintFinish()));} //TODO arreglar el tiempo
}