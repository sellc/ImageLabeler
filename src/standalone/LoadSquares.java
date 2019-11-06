package standalone;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import basic.Square;

public class LoadSquares {
	
	//Load previously tagged squares from JSON file.
	//TODO ******Write a JSON parser*******
	
	public static LinkedList<Square> loadSquares(String filePath){
		File labelsList = new File(filePath);
		LinkedList<Square> squares = null;
		if(labelsList.exists()) {
			squares = new LinkedList<Square>();
//			Scanner scanner = new Scanner(labelsList);
//			String input = "";
//			String[] split = null;
//			while(scanner.hasNext()) {
//				input = scanner.nextLine();
//				input.replaceAll("{", "");
//				input.replaceAll("}", "");
//				input.replaceAll(",", "\n");
//				split = input.split(":");
//				squares.add(new Square());
//			}
		}
		return squares;
	}

}
