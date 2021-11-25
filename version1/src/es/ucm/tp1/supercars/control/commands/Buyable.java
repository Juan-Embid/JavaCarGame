package es.ucm.tp1.supercars.control.commands;

import java.util.Scanner;

import es.ucm.tp1.supercars.logic.Game;

public interface Buyable {
	//private Scanner scanner; 

		public int cost();
		public default boolean buy(Game game){
			int cost = cost();
			if(!game.buy(cost)) {
				switch (cost) {
				case 1:
					System.out.println("Not enough coins\r\n" + 
							"[ERROR]: Failed to shoot");
					break;
				case 5:
					System.out.println("Not enough coins\r\n" + 
							"[ERROR]: Failed to wave");
					break;
				default:
					break;
				}
				return false;
			}
				return true;
		};
}
