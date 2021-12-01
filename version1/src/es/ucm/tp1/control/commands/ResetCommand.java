package es.ucm.tp1.control.commands;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;

public class ResetCommand extends Command {
	
	private static final String NAME = "reset";

	private static final String DETAILS = "[r]eset [<level> <seed>]";

	private static final String SHORTCUT = "r";

	private static final String HELP = "reset game";
	
	private Level newLevel;
	private Long newSeed;
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}
	
	@Override
	public boolean execute(Game game) {
		if (newSeed == null && newLevel == null)
			game.reset();
		else
			game.reset(newSeed, newLevel);
		return true;
	}
	
	@Override
	protected Command parse(String[] commandWords) {
		if(commandWords.length == 3) {
			if(matchCommandName(commandWords[0])) {
			    newLevel = Level.valueOfIgnoreCase(commandWords[1]);
			    newSeed = Long.parseLong(commandWords[2]);
			    return this;
			  }
			else
			    return null;
		}
	    else
	      return super.parse(commandWords);
	}
}