package es.ucm.tp1.supercars.control.commands;

import java.util.Scanner;

import es.ucm.tp1.supercars.logic.Game;

public interface Buyable {
	//private Scanner scanner; 

		public int cost();
		public default boolean buy(Game game){
			int cost = cost();
			if(!game.buy(cost)) {
				System.out.println("Not enough coins\r\n" + 
						"[ERROR]: Failed to shoot");
		//	String s = scanner.nextLine(); TODO Que se pause para poder ver el mensaje.
				return false;
			}
				return true;
		};
}
