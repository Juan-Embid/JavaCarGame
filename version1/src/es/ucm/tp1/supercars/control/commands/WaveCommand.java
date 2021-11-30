package es.ucm.tp1.supercars.control.commands;

import actions.WaveAction;
import es.ucm.tp1.supercars.logic.Game;

public class WaveCommand extends Command implements Buyable {

	private static final String NAME = "wave";

	private static final String DETAILS = "[w]ave";

	private static final String SHORTCUT = "w";

	private static final String HELP = "do wave";
	
	private static final int COST = 5;
	
	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) {
		if(buy(game)) {
			game.execute(new WaveAction());
			return true;
		}
		return false;
	}

	@Override
	public int cost() {
		return COST;}
}