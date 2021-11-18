package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class GrenadeCommand extends Command{

	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]renade <x> <y>";

	private static final String SHORTCUT = "g";

	private static final String HELP = "add a grenade in position x, y";
	
	private int newX;
	private int newY;
	
	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected Command parse(String[] commandWords) {
	if(commandWords.length == 3) {
	      if(matchCommandName(commandWords[0])) {
	        newX = Integer.parseInt(commandWords[1]);
	        newY = Integer.parseInt(commandWords[2]);
	        
	        return this;
	      }
	      else
	        return null;
	    }
	    else
	      return super.parse(commandWords);
	}
	
}
