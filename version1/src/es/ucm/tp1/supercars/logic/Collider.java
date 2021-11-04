package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public interface Collider {

	boolean doCollision();

	boolean receiveCollision(Player player);
	
	//void update(GameObject gameobject); echarle un vistazo porsi aca
	
	/*boolean receiveShoot();
	
	boolean receiveExplosion();*/
}