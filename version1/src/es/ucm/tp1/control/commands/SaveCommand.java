package es.ucm.tp1.control.commands;

import java.io.FileWriter;
import java.io.IOException;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GameSerializer;

public class SaveCommand extends Command{
	private static final String NAME = "save";

	private static final String DETAILS = "sa[v]e <filename>";

	private static final String SHORTCUT = "v";

	private static final String HELP = "Save the state of the game to a file.";
	
	private static String theFile;
	private static boolean written = false;
	private static String[] fileExt;
	
	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) throws IOException{
		if(writeFile(game))
			System.out.println("Game successfully saved to file " + theFile);
		else
			System.out.println("File not found");
		return false;}
	
	boolean writeFile(Game game) throws IOException {
		GameSerializer gameserializer = new GameSerializer(game);
		try (FileWriter myWriter = new FileWriter(theFile)){
			myWriter.write(gameserializer.printSerializer()); //esto está mal hecho, hay que hacer una funcion dentro de game serializer que devuelva un string con exactamente la misma info que estabamos printeando en gameserializer. Llamamos a esa funcion y que la guarde en el archivo poniendola entre los parentesis
			return written = true;
		} catch (IOException e) {
			e.printStackTrace();
			return written;
		}
	}
	
	@Override
	public Command parse(String[] words) { //TODO tiene que soltar un commandparseexception si no se proporciona argumento o se proporciona mas de uno
		if (matchCommandName(words[0])) {
			if (words.length == 2) {
				if(matchCommandName(words[0])) {
					fileExt = words[1].split("."); //desde la linea 48 hasta la 53 lo que estoy intentando hacer es ver si el usuario ha metido el .txt o no, como dice en el pdf. Si no lo ha metido lo metemos. Si si lo ha metido lo usamos
					theFile = fileExt[1].toString();
					if (theFile == "txt")
						theFile = words[1];
					else 
						theFile = theFile + ".txt";
					return this;}
			}
			else
				System.out.format("[ERROR]: Command %s: %s%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
		}
		return null;
	}
}