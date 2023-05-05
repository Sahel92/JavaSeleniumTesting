package tek.sdet.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtility {


	/**
	 * this method of the FileUtility class
	 * will return the FileInputStream of a File object, referred by filePath
	 * which opens the connection to that file
	 * so we can use it's properties
	 * @param
	 * @returns new FileInputStream(new File(filepath))
	 */
	public static FileInputStream getFileInputStream(String filePath) throws FileNotFoundException {

		return new FileInputStream(new File(filePath));

	}

}
