package es.ucm.tp1.control.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import es.ucm.tp1.exceptions.CommandExecuteException; //creo que hay que meterlo de alguna manera dentro del execute
import es.ucm.tp1.logic.Game;

public class DumpCommand extends Command{
	
	private static final String NAME = "dump";

	private static final String DETAILS = "[d]ump filename";

	private static final String SHORTCUT = "d";

	private static final String HELP = "Shows the content of a saved file";
	
	//private static String FilePath = new File(".").getAbsolutePath();
	//File folder = new File(FilePath);
	private static String dumpFile, rawName;
	private static String[] fileName;
	
	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) throws FileNotFoundException {
		File file = new File(getFileName());
	    Scanner myFile = new Scanner(file);
		while (myFile.hasNextLine()) {
		    String data = myFile.nextLine();
		    System.out.println(data);
		  }
		myFile.close();
		return false;
	}
	
	public String getFileName() {
		StringBuilder str = new StringBuilder();
		fileName = dumpFile.split("[.]");
		if (fileName.length == 2)
			dumpFile = fileName[1].toString();
		if (dumpFile.equals("txt"))
			dumpFile = rawName;
		else {
			str.append(rawName).append(".txt");
			dumpFile = str.toString();
		}
		return dumpFile;
	}

	@Override
	public Command parse(String[] words) { //TODO tiene que soltar un commandparseexception si no se proporciona argumento o se proporciona mas de uno
		if (matchCommandName(words[0])) {
			if (words.length == 2) {
				dumpFile = words[1];
				rawName = words[1];
				return this;}
			else {
				System.out.format("[ERROR]: Command %s: %s%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;}
		}
		return null;
	}
	
	//TODO no borrar, es la polla y me da pena quitarlo xd
	/*public String getFileName(final File folder) { //devuelve el archivo donde se encuentra la partida guardada
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isFile() && !fileEntry.isHidden())
				if (!fileEntry.toString().equals(FilePath + "/symbols.txt") && !fileEntry.toString().equals(FilePath + "/record.txt"))
					return fileEntry.toString();
		}
		return "";
	}*/
}