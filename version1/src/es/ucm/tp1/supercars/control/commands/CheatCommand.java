package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class CheatCommand extends Command {

	private static final String NAME = "cheat";

	private static final String DETAILS = "[c]heat";

	private static final String SHORTCUT = "c";

	private static final String HELP = "enters cheat mode";

	
	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

}
