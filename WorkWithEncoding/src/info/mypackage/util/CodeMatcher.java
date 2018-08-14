package info.mypackage.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import info.mypackage.model.SymbolsMapping;

public class CodeMatcher {

	private static final String KEY_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") + "lib"
			+ System.getProperty("file.separator") + "key.txt";

	private static final String MATCHER_ONE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "lib" + System.getProperty("file.separator") + "matchingRowOne.txt";

	private static final String MATCHER_TWO_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "lib" + System.getProperty("file.separator") + "matchingRowTwo.txt";

	public static SymbolsMapping getSymbolsMapping(){
		
		String[][] key = getMatrix(KEY_PATH);
		String[][] mapRowOne = getMatrix(MATCHER_ONE_PATH);
		String[][] mapRowTwo = getMatrix(MATCHER_TWO_PATH);
		
		SymbolsMapping mapper = new SymbolsMapping();
		mapper.setMatrixKey(key);
		mapper.setMatrixRowOne(mapRowOne);
		mapper.setMatrixRowTwo(mapRowTwo);

		return mapper;
	}
	
	private static String[][] getMatrix(String path){
		try ( 	FileReader fileReader = new FileReader(path);
				BufferedReader bufferedReader = new BufferedReader(fileReader))
		{
			String[][] matrix = new String[3][5];
			String tempText = "";
			while ((tempText = bufferedReader.readLine()) != null) {
				String[] lines = tempText.split(" ");
				for (int i = 0; i < lines.length; i++) {
					char[] symbols = lines[i].toCharArray();
					for (int j = 0; j < symbols.length; j++) {
						matrix[i][j] = String.valueOf(symbols[j]);
					}
				}
				
			}
			return matrix;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
