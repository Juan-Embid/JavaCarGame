package es.ucm.tp1.supercars.logic;


import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
public class GameObjectContainer {
	
	GameObject gameobject;
	
		private List<GameObject> gameobjects;
		public GameObjectContainer() {
		gameobjects = new ArrayList<>();
		}
	public void Delete() {
		
	}
	
	public void Add(GameObject objeto) {
		gameobjects.add(objeto);
	}
	public void reset() {
		
	}
	public int getpositionX() {
		return 0;
	}
	public int getpositionY() {
		return 0;
	}
	public void update() {
		// TODO Auto-generated method stub
		for(int i=0;i<gameobjects.size();i++) {
			gameobject.less(gameobjects.get(i));
		}
	}
}
