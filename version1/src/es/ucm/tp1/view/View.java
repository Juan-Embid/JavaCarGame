package es.ucm.tp1.view;

import es.ucm.tp1.logic.Game;
import java.text.DecimalFormat;

public abstract class View {
	
	static Game game;
	static DecimalFormat df = new DecimalFormat("#.##");
	
	public View(Game game) {
		this.game=game;
	}

	
	
	public static void printTime() {
		if (!game.getActivate()) {
			if (game.getCycles() == 0)
				System.out.println("Elapsed time: 0.00 s");
			else
				System.out.println("Elapsed time: " + df.format((double) ((System.currentTimeMillis() - game.GetInitTime()) / 1000.)) + " s");
		}
}
}