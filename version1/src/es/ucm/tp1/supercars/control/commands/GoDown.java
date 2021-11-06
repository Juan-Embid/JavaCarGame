package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class GoDown extends Command {
	private static final String NAME = "godown";

	private static final String DETAILS = "[d]own";

	private static final String SHORTCUT = "a";

	private static final String HELP = "go down";
	
	public GoDown() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	public boolean execute(Game game) {
		game.goDown();
		return false;
	}
}
