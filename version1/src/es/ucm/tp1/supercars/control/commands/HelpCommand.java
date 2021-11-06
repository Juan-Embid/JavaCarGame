package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.utils.StringUtils;

public class HelpCommand extends Command {

	private static final String NAME = "help";

	private static final String DETAILS = "[h]elp";

	private static final String SHORTCUT = "h";

	private static final String HELP = "show this help";

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:" + "\n" 
				+ "\\\"[h]elp: show this help\\\",\\n\" + \n" + 
				"				\"		\\\"[i]nfo: prints gameobjet info\\\",\\n\" + \n" + 
				"				\"		\\\"[n]one | []: update\\\",\\n\" + \n" + 
				"				\"		\\\"[q]: go up\\\",\\n\" + \n" + 
				"				\"		\\\"[a]: go down\\\",\\n\" + \n" + 
				"				\"		\\\"[e]xit: exit game\\\",\\n\" + \n" + 
				"				\"		\\\"[r]eset: reset game\\\",\\n\" + \n" + 
				"				\"		\\\"[t]est: enables test mode\\\",	\"");
		// TODO Add your code

		System.out.println(buffer.toString());

		return false;
	}

}