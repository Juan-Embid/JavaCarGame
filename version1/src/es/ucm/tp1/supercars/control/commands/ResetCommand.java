package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import java.util.Scanner;

public class ResetCommand extends Command {
	private static final String NAME = "reset";

	private static final String DETAILS = "[r]eset";

	private static final String SHORTCUT = "r";

	private static final String HELP = "reset";
	
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	public boolean execute(Game game) {
		String lvl;
		System.out.print("Selecciona la seed: ");
		Scanner sc = new Scanner(System.in);
		String semilla = sc.nextLine();
		long sem = Long.parseLong(semilla);
		game.setSeed(sem);
		
		System.out.print("\n" + "Selecciona la nivel: ");
		String nivel = sc.nextLine();
		lvl = nivel.toLowerCase();
		game.setLevel(game.stringToLevel(lvl));
		if (lvl.equals("test"))
			game.toggleTest();
		
		game.reset();
		return true;
	}

}
