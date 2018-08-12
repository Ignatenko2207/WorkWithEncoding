package info.mypackage.service;

import info.mypackage.model.SymbolsMapping;
import info.mypackage.util.CodeMatcher;

public class CodeManipulator {

	private static final String MATCHER_ONE_PATH = 
			System.getProperty("user.dir") +
			System.getProperty("file.separator") + "lib" +
			System.getProperty("file.separator") + "matchingRowOne.txt";
	
	private static final String MATCHER_TWO_PATH = 
			System.getProperty("user.dir") +
			System.getProperty("file.separator") + "lib" +
			System.getProperty("file.separator") + "matchingRowTwo.txt";
	
	public static String encryptCode(String text) {

		String modifiedText = getModifiedText(text);
		String encodedString = new String(text);
		
		char[] symbols = modifiedText.toCharArray();
		SymbolsMapping mapperOne = CodeMatcher.getSymbolsMapping(MATCHER_ONE_PATH);
		SymbolsMapping mapperTwo = CodeMatcher.getSymbolsMapping(MATCHER_TWO_PATH);
		
		for (int i = 0; i < symbols.length; i++) {
			if(i==0 || i%2 == 0 ) {
				int index = mapperOne.getMatrixRowOne().indexOf(symbols[i]);
				encodedString += mapperOne.getMatrixRowTwo().substring(index-1, index+1);
			}
			else{
				int index = mapperTwo.getMatrixRowOne().indexOf(symbols[i]);
				encodedString += mapperTwo.getMatrixRowTwo().substring(index-1, index+1);
			}
		}
		
		
		return encodedString;
	}

	public static String decryptCode(String text) {

		return "";
	}
	
	private static String getModifiedText(String text) {
		String modifiedText = text.replaceAll("[^A-Za-z]", "");
		modifiedText = modifiedText.replaceAll("\n", "");
		modifiedText = modifiedText.replaceAll("\r", "");
		modifiedText = modifiedText.toUpperCase();
		return modifiedText;
	}
}
