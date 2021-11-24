package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.Player;

public interface Collider {

	boolean receiveCollision(Player player);
	
	boolean receiveShoot();
	
	boolean receiveExplosion();
	//void update(GameObject gameobject); echarle un vistazo porsi acaso

}