package es.ucm.tp1.control.commands;

import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements Buyable{

	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]renade <x> <y>";

	private static final String SHORTCUT = "g";

	private static final String HELP = "add a grenade in position x, y";
	
	private static final int COST = 3;
	
	private int newX;
	private int newY;
	
	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) {
		if (buy(game)) {
			game.setXGrenade(newX + game.getPlayerCycles());
			game.setYGrenade(newY);
			game.addObject(new Grenade(game, game.getXGrenade(), game.getYGrenade()));
			game.activateWait();			
			game.update();
			return true;
		}
		return false;
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException  {
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
	    	if(matchCommandName(commandWords[0]))
	      return this;
	    	return null;
	}

	@Override
	public int cost() {
		return COST;}
}