package info.mypackage;

import info.mypackage.service.CodeManipulator;
import info.mypackage.service.FileOrganizer;

public class AppRunner {

	public static void main(String[] args) {
		String text = "edakl dlkcd";
		
		String encodedString = CodeManipulator.encryptCode(text);
		FileOrganizer.writeEncriptedTextToFile(encodedString);
		
		System.out.println("Text was encoded!");
	}
}
