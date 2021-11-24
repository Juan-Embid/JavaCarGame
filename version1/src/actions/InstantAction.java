package actions;

import es.ucm.tp1.supercars.logic.Game;

public interface InstantAction {
	
void execute(Game game);

 boolean explosionAction();
 
 boolean ThunderKill();
 
 boolean shootAction();
 
}
