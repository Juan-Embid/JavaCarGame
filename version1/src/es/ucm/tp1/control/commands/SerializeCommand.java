package es.ucm.tp1.control.commands;

import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;

public class SerializeCommand extends Command{
	private static final String NAME = "dump";

	private static final String DETAILS = "[d]ump <filename>";

	private static final String SHORTCUT = "d";

	private static final String HELP = "Shows the content of a saved file";
	
	public SerializeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) {
		return false;
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