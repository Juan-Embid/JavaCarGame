package es.ucm.tp1.control.commands;

import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;

public class TestCommand extends Command {
	
	private static final String NAME = "test";

	private static final String DETAILS = "[t]est";

	private static final String SHORTCUT = "t";

	private static final String HELP = "enables test mode";
	
	public TestCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}
	
	@Override
	public boolean execute(Game game) {
		game.toggleTest();
		return true;
	}
	
	@Override
	public Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;} 
			else 
				return this;
		}
		return null;
	}
}