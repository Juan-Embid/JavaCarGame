package es.ucm.tp1.supercars.logic;


import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
public class GameObjectContainer {
	
		private List<GameObject> gameobjects;
		public GameObjectContainer() {
		gameobjects = new ArrayList<>();
		}
	public void Delete() {
		
	}
	
	public void update(GameObject objeto) {
		gameobjects.add(objeto);
	}
	public void reset() {
		
	}
	public int getpositionX() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getpositionY() {
		// TODO Auto-generated method stub
		return 0;
	}
}
