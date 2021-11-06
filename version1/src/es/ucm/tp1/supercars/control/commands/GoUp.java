package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class GoUp extends Command {
	private static final String NAME = "goup";

	private static final String DETAILS = "[u]p";

	private static final String SHORTCUT = "q";

	private static final String HELP = "go up";
	
	public GoUp() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	public boolean execute(Game game) {
		game.goUp();
		return false;
	}
}