package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;

public class GoDown extends Command {
	private static final String NAME = "godown";

	private static final String DETAILS = "[a]";

	private static final String SHORTCUT = "a";

	private static final String HELP = "go down";
	
	public GoDown() {
		super(NAME, SHORTCUT, DETAILS, HELP);}
	
	@Override
	public boolean execute(Game game) {
		if(!game.firstCollision())
			game.goDown();
		game.update();
		return true;
	}
}