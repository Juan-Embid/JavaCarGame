package es.ucm.tp1.exceptions;

public class IncorrectCommandException extends CommandParseException{
	
    private static final String MENSAJE_EXCEPCION = "Invalid position";
    
    public IncorrectCommandException() {
        super(MENSAJE_EXCEPCION);
    }
}