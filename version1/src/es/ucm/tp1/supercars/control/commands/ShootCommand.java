package es.ucm.tp1.supercars.control.commands;

import actions.ShootAction;
import es.ucm.tp1.supercars.logic.Game;

public class ShootCommand extends Command implements Buyable {

	private static final String NAME = "shoot";

	private static final String DETAILS = "[s]hoot";

	private static final String SHORTCUT = "s";

	private static final String HELP = "shoot bullet";
	
	private static final int COST = 1;
	
	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if(buy(game))
		game.execute(new ShootAction());
		game.update();
		return true;
	}

	@Override
	public int cost() {
		return COST;
	}

}
