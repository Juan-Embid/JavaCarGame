package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class GrenadeCommand extends Command implements Buyable{

	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]renade <x> <y>";

	private static final String SHORTCUT = "g";

	private static final String HELP = "add a grenade in position x, y";
	
	private static final int COST = 3;
	
	private int newX;
	private int newY;
	
	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if (buy(game)) {
		game.setGrenade(true);
		game.setXGrenade(newX + game.getPlayerCycles());
		game.setYGrenade(newY);
		game.update();
		return true;}
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

	@Override
	public int cost() {
		return COST;
	}
}
