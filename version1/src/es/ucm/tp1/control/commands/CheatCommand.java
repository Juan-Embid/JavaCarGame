package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;

public class CheatCommand extends Command {

	private static final String NAME = "cheat";

	private static final String DETAILS = "Cheat [1..5]";

	private static final String SHORTCUT = "c";

	private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";
	
	private static Integer id;
	
	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) {
		game.addCheat(id);
		return true;
	}
	
	protected Command parse(String[] commandWords) {
		try {
			id = Integer.parseInt(commandWords[0]);} 
		
		catch (Exception e) {
			return null;}
		
		if (0 < id && id < 6) {
			return this;}
		
		return null;
	}
}
