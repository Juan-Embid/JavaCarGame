package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.utils.StringUtils;

public class HelpCommand extends Command {

	private static final String NAME = "help";

	private static final String DETAILS = "[h]elp";

	private static final String SHORTCUT = "h";

	private static final String HELP = "show this help";
	
	private static final String INFO =
			"Available commands:" 
					+ "\n" + "[h]elp: show this help" 
					+ "\n" + "[i]nfo: prints gameObjet info" 
					+ "\n" + "[n]one | []: update" 
					+ "\n" + "[q]: go up"
					+ "\n" + "[a]: go down" 
					+ "\n" + "[e]xit: exit game" 
					+ "\n" + "[r]eset: reset game" 
					+ "\n" + "[t]est: enables test mode";

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder(INFO);

		System.out.println(buffer.toString());

		return false;
	}

}
