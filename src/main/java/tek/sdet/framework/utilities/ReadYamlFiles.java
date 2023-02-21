package tek.sdet.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	/*
	 * implementing singleton pattern
	 * to make sure that only one instance of yaml file is being read
	 *
	 * created a private static reference to the class itself
	 */
	private static ReadYamlFiles readYamlFiles;



	/*
	 * using a private Hashmap and
	 * with this HashMap we are storing our yaml files configuration as
	 *  a key and value pair
	 *  within the propertyMap
	 */
	@SuppressWarnings("rawtypes")
	private HashMap propertyMap;



	/*
	 * This constructor will instantiate an instance of our
	 * env_config.yml file.
	 *
	 * This method uses the getFileInputStream method of our FileUtility class
	 * we are using the File object referred by 'filePath' as a parameter
	 * of our getFileInputStream.
	 *
	 *  The File object essentially is our testing environments configuration
	 * such as which browser to use for the test cases, or
	 * which url our browser starts at.
	 *
	 * So it retrieves the filePath of the the yml file as an object of File.
	 * fileInputStream will point to that yml File object.
	 *
	 * Second part of this constructor creates a Yaml object.
	 * We are using propertyMap referencing our HashMap, to store the
	 * properties of our env_config.yml file as an object
	 *
	 */

	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = FileUtility.getFileInputStream(filePath);

		Yaml yaml = new Yaml();
		this.propertyMap = yaml.load(fileInputStream);
	}

	/*
	 * This method returns an instance of ReadYamlFiles,
	 * if the instance variable readYamlFile is null.
	 * Otherwise it will return the current instance of readYamlFiles
	 *
	 * if it returns a new ReadYamlFiles object the above constructor
	 * will execute
	 *
	 */
	public static ReadYamlFiles getInstance( String filePath) throws FileNotFoundException {
		if(readYamlFiles == null)
			return new ReadYamlFiles(filePath);
		return readYamlFiles;

	}

	/* this method returns the object key : value pair
	 * of our yml object from the previous method
	 *
	 */

	@SuppressWarnings("rawtypes")
	public HashMap getYamlProperty(String key) {
		return (HashMap)this.propertyMap.get(key);
	}

}
