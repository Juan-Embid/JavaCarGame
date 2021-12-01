package es.ucm.tp1.control.commands;

import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;

public class GoUp extends Command {
	private static final String NAME = "goup";

	private static final String DETAILS = "[q]";

	private static final String SHORTCUT = "q";

	private static final String HELP = "go up";
	
	public GoUp() {
		super(NAME, SHORTCUT, DETAILS, HELP);}
	
	@Override
	public boolean execute(Game game) {
		if(!game.firstCollision())
		game.goUp();
		game.update();
		return true;
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