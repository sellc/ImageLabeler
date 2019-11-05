package standalone;

import java.io.File;

public class ValidFilePath {
	public static boolean validFilePath(String path) {
		return new File(path).exists();
	}
}
