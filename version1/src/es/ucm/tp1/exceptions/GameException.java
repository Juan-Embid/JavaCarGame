package es.ucm.tp1.exceptions;

public abstract class GameException extends Exception {
	
	public GameException(String message) {
		super(message);
	}
	
	public void printException() {
		System.err.println(getMessage());
	}
	
}
