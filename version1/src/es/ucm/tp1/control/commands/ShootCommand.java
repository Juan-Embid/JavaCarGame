package es.ucm.tp1.control.commands;

import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.actions.ShootAction;

public class ShootCommand extends Command implements Buyable {

	private static final String NAME = "shoot";

	private static final String DETAILS = "[s]hoot";

	private static final String SHORTCUT = "s";

	private static final String HELP = "shoot bullet";
	
	private static final int COST = 1;
	
	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) {
		if(buy(game)) {
			game.execute(new ShootAction());
			game.update();
			return true;
		}
		return false;
	}

	@Override
	public int cost() {
		return COST;}
	
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