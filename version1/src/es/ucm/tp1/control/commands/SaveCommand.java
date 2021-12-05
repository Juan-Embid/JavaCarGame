package es.ucm.tp1.control.commands;

import java.io.FileWriter;
import java.io.IOException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GameSerializer;

public class SaveCommand extends Command{
	private static final String NAME = "save";

	private static final String DETAILS = "sa[v]e <filename>";

	private static final String SHORTCUT = "v";

	private static final String HELP = "Save the state of the game to a file.";
	
	private String word;
	
	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) throws IOException{
		GameSerializer gameserializer = new GameSerializer(game);
		try (FileWriter myWriter = new FileWriter(word + ".txt")){
			myWriter.write(gameserializer.serializeToString());
			System.out.println("Game successfully saved to file " + word + ".txt");
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
		return false;}
	
	@Override
	public Command parse(String[] words) { //TODO tiene que soltar un commandparseexception si no se proporciona argumento o se proporciona mas de uno
		if (matchCommandName(words[0])) {
			if (words.length == 2) {
				word = words[1];
				return this;}
			else {
				System.out.format("[ERROR]: Command %s: %s%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;}
		}
		return null;
	}
}