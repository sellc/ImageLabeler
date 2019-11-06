package standalone;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import basic.Square;

public class WriteOutSquaresInJSON {
	
	public static void writeOut(String filePath, LinkedList<Square> list, double xScale, double yScale) {
		File labelsList = new File(filePath.substring(0, filePath.length()-4) + "JSON.txt");
		try {
			if (!labelsList.exists()) {
				labelsList.createNewFile();
			}
			PrintWriter pw = new PrintWriter(labelsList);
			Square current;
			int index = 0;
			while (index < list.size()) {
				current = list.get(index++);
				pw.print(current.toJSON(xScale, yScale));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
