package es.ucm.tp1.control.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;
import java.text.DecimalFormat;

public class ShowRecordCommand extends Command{
	private static final String NAME = "record";

	private static final String DETAILS = "rec[o]rd";

	private static final String SHORTCUT = "o";

	private static final String HELP = "Show level record";
	
	private static String RecordLevel;
	private static String[] RecordFile, RecordInfo;
	private static int i = 0, j = 0, cont = 0;
	private static int segundos;
	
	public ShowRecordCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);}

	@Override
	public boolean execute(Game game) throws FileNotFoundException { //Si no exite record.txt, lanza inputoutputrecordexception
		 //Lo mejor seria crear una clase para el record y hacer lo que tenemos en el execute
		DecimalFormat df = new DecimalFormat("#.##");
		File file = new File("record.txt");
		Scanner myFile = new Scanner(file);
		while (myFile.hasNextLine()) {
			myFile.nextLine();
		    cont++;}
		String RecordFile[] = new String[cont];
		Scanner theFile = new Scanner(file);
		while (i < cont) {
			String data = theFile.nextLine();
		    RecordFile[i] = data;
		    i++;
		}
		myFile.close();
		RecordInfo = RecordFile[j].split("[:]");
		RecordLevel = RecordInfo[0];
		while (!game.getLevel().toString().equals(RecordLevel) && j < i) {
			j++;
			RecordInfo = RecordFile[j].split("[:]");
			RecordLevel = RecordInfo[0];
		}
		segundos = Integer.parseInt(RecordInfo[1]);
		System.out.println(game.getLevel() + " record is " + df.format((double) segundos/1000.) + " s");
		return false;
	}
	
	@Override
	public Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;} 
			else 
				return this;
		}
		return null;
	}
}