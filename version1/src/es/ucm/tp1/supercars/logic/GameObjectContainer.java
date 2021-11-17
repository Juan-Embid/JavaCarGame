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
	public GameObject isinPosition(int x, int y) {
		boolean test = false;
		GameObject go=null;
		for (int i = 0;i<gameobjects.size() && !test;i++) {
			go = gameobjects.get(i);
			test = go.isInPosition(x, y);
		}
		if (!test) return null;
		return go;
	}
	public int getpositionY() {
		return 0;
	}
	public void update() {
		for(int i=0;i<gameobjects.size();i++) {
			//gameobject.less(gameobjects.get(i));
			GameObject go = gameobjects.get(i);
			go.less();
		}
	}
	public void onEnter(GameObject gameobject1) {
		gameobject1.onEnter();
	}
}
