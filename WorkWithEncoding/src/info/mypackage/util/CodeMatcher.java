package info.mypackage.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import info.mypackage.model.SymbolsMapping;

public class CodeMatcher {

	public static SymbolsMapping getSymbolsMapping(String filePath){
		
		try ( 	FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader))
		{
			String fileText = "";
			String tempText = "";
			while ((tempText = bufferedReader.readLine()) != null) {
				fileText += tempText;
			}
			
			String rowOne = fileText.split("\n")[0];
			String rowTwo = fileText.split("\n")[1];
			
			SymbolsMapping symbolsMapping = new SymbolsMapping();
			symbolsMapping.setMatrixRowOne(rowOne);
			symbolsMapping.setMatrixRowTwo(rowTwo);
			
			return symbolsMapping;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}