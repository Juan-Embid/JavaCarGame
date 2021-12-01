package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;

public abstract class Command {

	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";
	
	private final String name;

	private final String shortcut;

	private final String details;

	private final String help;
	
	/* @formatter:off */
	private static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new UpdateCommand(),
		new GoUp(),
		new GoDown(),
		new ExitCommand(),		
		new ResetCommand(),
		new TestCommand(),
		new ShootCommand(),
		new GrenadeCommand(),
		new WaveCommand(),
		new ClearCommand(),
		new CheatCommand()	
	};
	
	/* @formatter:on */
	public static Command getCommand(String[] commandWords) {
		Command command = null;
		for(Command command_1 : AVAILABLE_COMMANDS)
			for (Command command_2 : AVAILABLE_COMMANDS)
				if(command_1 == command_2.parse(commandWords))
					return command = command_1;
		return command;
	}
	
	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game);

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);}

	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s%n%n", name, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;} 
			else 
				return this;
		}
		return null;
	}

	 public static String showCommand() {
		StringBuilder str= new StringBuilder();
		for(Command command : AVAILABLE_COMMANDS) {
			str.append(command.details)
			.append(": ")
			.append(command.help)
			.append("\n");
		}
		return str.toString();
	}
}