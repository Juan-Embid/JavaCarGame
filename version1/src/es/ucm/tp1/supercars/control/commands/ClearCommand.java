package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class ClearCommand extends Command {
	private static final String NAME = "clear";

	private static final String DETAILS = "[0]clear";

	private static final String SHORTCUT = "0";

	private static final String HELP = "clear";
	
	public ClearCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

}
