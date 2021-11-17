package es.ucm.tp1.supercars.control.commands;


import es.ucm.tp1.supercars.logic.Game;

public abstract class Command {


	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";
	
	/* @formatter:off */
	private static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new UpdateCommand(),
		new ExitCommand(),
		new GoDown(),
		new GoUp(),
		new ResetCommand(),
		new TestCommand()
	};
	
	/* @formatter:on */
	public static Command getCommand(String[] commandWords) {
		Command command = null;
		for(int i = 0; i < AVAILABLE_COMMANDS.length; i++) {
			for (int j = 0; j < AVAILABLE_COMMANDS.length; j++) {
				if(AVAILABLE_COMMANDS[i]==AVAILABLE_COMMANDS[j].parse(commandWords))
					return command = AVAILABLE_COMMANDS[i];
			}
		}
		return command;
	}
	
	private final String name;

	private final String shortcut;

	private final String details;

	private final String help;

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game);

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s%n%n", name, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				return this;
			}
		}
		return null;
	}

	 public static String showCommand() {
		StringBuilder str= new StringBuilder();
		for(int i=0;i<AVAILABLE_COMMANDS.length;i++) {
			str.append(AVAILABLE_COMMANDS[i].details)
			.append(": ")
			.append(AVAILABLE_COMMANDS[i].help)
			.append("\n");
		}
		return str.toString();
	};
	
}