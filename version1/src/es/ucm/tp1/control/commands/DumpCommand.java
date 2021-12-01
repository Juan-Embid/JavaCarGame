package es.ucm.tp1.control.commands;

import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;

public class DumpCommand extends Command{
	private static final String NAME = "serialize";

	private static final String DETAILS = "seriali[z]e";

	private static final String SHORTCUT = "z";

	private static final String HELP = "Serializes the board.";
	
	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) {
		return false;
	}

	@Override
	public Command parse(String[] words){
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