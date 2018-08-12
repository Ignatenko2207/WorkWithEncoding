package info.mypackage.service;

import java.io.FileWriter;
import java.io.IOException;

public class FileOrganizer {

	private static final String OUT_FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "lib" + System.getProperty("file.separator") + "encriptedFile.txt";

	public static void writeEncriptedTextToFile(String text) {

		String textToWrite = modifyText(text);

		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(OUT_FILE_PATH);
			fileWriter.write(textToWrite);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static String modifyText(String text) {
		String modifiedText = "";
		char[] symbols = text.toCharArray();
		for (int i = 0; i < symbols.length; i++) {
			if (i % 3 == 0 && i != 0) {
				modifiedText += "\n";
			}
			modifiedText += String.valueOf(symbols[i]);
		}
		return modifiedText;
	}
}
