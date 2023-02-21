package tek.sdet.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtility {


	/*
	 * this method of the file utility class
	 * will return the FileInputStream of a File object
	 * which opens the connection to that file
	 * so we can use it's properties
	 * takes one parameter String filePath
	 * returns an Instance of the filePath
	 */
	public static FileInputStream getFileInputStream(String filePath) throws FileNotFoundException {

		return new FileInputStream(new File(filePath));

	}

}
