package es.ucm.tp1.control;

import java.io.IOException;
import java.util.Scanner;

import es.ucm.tp1.control.commands.Command;
import es.ucm.tp1.exceptions.GameException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	
	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;
	
	private Record record;
	
	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);
	}

	public void printGame() {
			System.out.println(printer);
	}

	public void run() throws IOException {
		boolean refreshDisplay=true;
		game.reset();
		while (!game.isFinished()) {	
			try {
				this.printer = new GamePrinter(game);
				if (refreshDisplay ) {
					printGame();}
					refreshDisplay = false;
					System.out.println(PROMPT);
					String s = scanner.nextLine();
					String[] parameters = s.toLowerCase().trim().split(" ");
					Command command = Command.getCommand(parameters);
					System.out.println("[DEBUG] Executing: " + s);
					if (command != null) {
					refreshDisplay = command.execute(game);
					} else {
					System.out.println("[ERROR]: "+ UNKNOWN_COMMAND_MSG);
					}
				}
			catch(GameException ex) {
				ex.printException();
			}
			}
		if(game.PrintFinish() != 1)
			printGame();
		if(game.distanceTofinish()==0) {
			record = new Record(game);
			if(record.newRecord()) {
				record.writeRecord();
				System.out.println("New record!: " + game.getTime()+  " s" );
			}
		}
		System.out.println(printer.endMessage(game.PrintFinish()));}
}