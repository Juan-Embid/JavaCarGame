package es.ucm.tp1.supercars.control.commands;

import java.util.Arrays;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.supercars.logic.Game;;
public abstract class Command {

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

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
		//AQUÍ hay que llamar recorrer el array de comandos y parsearlo.
<<<<<<< HEAD
		for(int i = 0; i < AVAILABLE_COMMANDS.length; i++) {
			if(AVAILABLE_COMMANDS[i]==AVAILABLE_COMMANDS[0].parse(commandWords))
				command = AVAILABLE_COMMANDS[i];
			else if (AVAILABLE_COMMANDS[i]==AVAILABLE_COMMANDS[1].parse(commandWords))
				command = AVAILABLE_COMMANDS[i];
			else if (AVAILABLE_COMMANDS[i]==AVAILABLE_COMMANDS[2].parse(commandWords))
				command = AVAILABLE_COMMANDS[i];
			else if (AVAILABLE_COMMANDS[i]==AVAILABLE_COMMANDS[3].parse(commandWords))
				command = AVAILABLE_COMMANDS[i];
			else if (AVAILABLE_COMMANDS[i]==AVAILABLE_COMMANDS[4].parse(commandWords))
				command = AVAILABLE_COMMANDS[i];
			else if (AVAILABLE_COMMANDS[i]==AVAILABLE_COMMANDS[5].parse(commandWords))
				command = AVAILABLE_COMMANDS[i];
			else if (AVAILABLE_COMMANDS[i]==AVAILABLE_COMMANDS[6].parse(commandWords))
				command = AVAILABLE_COMMANDS[i];
			else if (AVAILABLE_COMMANDS[i]==AVAILABLE_COMMANDS[7].parse(commandWords))
				command = AVAILABLE_COMMANDS[i];
=======
		for(int i=0; i<AVAILABLE_COMMANDS.length;i++) {
			//if(AVAILABLE_COMMANDS[i]==parse(commandWords))
	
>>>>>>> parent of 37aa7a8... Imprime objetos y coche correctamente
		}
		return command;
	}

	//protected abstract Command GoDown(); //TODO esta mierda creo que no hay que ponerla pero me la guardo
	
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
}
