package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;

public class ShowRecordCommand extends Command{
	private static final String NAME = "record";

	private static final String DETAILS = "rec[o]rd";

	private static final String SHORTCUT = "o";

	private static final String HELP = "Show level record";
	
	public ShowRecordCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) {
		return false;
	}
}