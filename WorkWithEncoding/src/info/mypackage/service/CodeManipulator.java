package info.mypackage.service;

import info.mypackage.model.SymbolsMapping;
import info.mypackage.util.CodeMatcher;

public class CodeManipulator {

	public static String encryptCode(String text) {

		String modifiedText = getModifiedText(text);
		String encodedString = "";

		char[] symbols = modifiedText.toCharArray();
		
		for (int i = 0; i < symbols.length; i++) {
			if (i % 2 == 0) {
				String symbol = getEncodedSymbolFromMatrixOne(String.valueOf(symbols[i]));
				encodedString += symbol;
			} else {
				String symbol = getEncodedSymbolFromMatrixTwo(String.valueOf(symbols[i]));
				encodedString += symbol;
			}
		}
		System.out.println(encodedString);
		return encodedString;
	}

	private static String getEncodedSymbolFromMatrixTwo(String symbol) {
		SymbolsMapping mapper = CodeMatcher.getSymbolsMapping();
		for (int i = 0; i < mapper.getMatrixKey().length; i++) {
			for (int j = 0; j < mapper.getMatrixKey()[i].length; j++) {
				if (symbol.equals(mapper.getMatrixKey()[i][j])) {
					return mapper.getMatrixRowTwo()[i][j];
				}
			}
		}
		
		return "";
	}

	private static String getEncodedSymbolFromMatrixOne(String symbol) {
		SymbolsMapping mapper = CodeMatcher.getSymbolsMapping();
		for (int i = 0; i < mapper.getMatrixKey().length; i++) {
			for (int j = 0; j < mapper.getMatrixKey()[i].length; j++) {
				if (symbol.equals(mapper.getMatrixKey()[i][j])) {
					return mapper.getMatrixRowOne()[i][j];
				}
			}
		}
		
		return "";
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
