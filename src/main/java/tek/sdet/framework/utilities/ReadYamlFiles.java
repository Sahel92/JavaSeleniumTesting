package tek.sdet.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	/**
	 * implementing singleton pattern to make sure that only one instance of yaml
	 * file is being read
	 *
	 * created a private static reference to the class itself
	 */
	private static ReadYamlFiles readYamlFiles;

	/**
	 * using a private Hashmap and with this HashMap we are storing our yaml files
	 * configuration as a key and value pair within the propertyMap
	 */
	@SuppressWarnings("rawtypes")
	private HashMap propertyMap;

	/**
	 * This constructor will instantiate an instance of our env_config.yml file.
	 *
	 * This method uses the getFileInputStream method of our FileUtility class. To
	 * retrieve the fileinputstream of our .yml file.
	 * 
	 * retrieves the filePath of the the yml file as an object of File.
	 * fileInputStream will point to that yml File object.
	 *
	 * Second part of this constructor creates a Yaml object.
	 * 
	 * Then using our HashMap propertyMap to store the properties of our
	 * env_config.yml file as key : value objects.
	 * 
	 * The filepath passed is defined in BaseSetup class constructor.
	 * 
	 * @param String filepath /** This method returns a new instance of
	 *               ReadYamlFiles, if the field variable (readYamlFile) is null.
	 *               Otherwise if readYamlFile != null, it will return the current
	 *               instance of readYamlFiles
	 */

	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = FileUtility.getFileInputStream(filePath);

		Yaml yaml = new Yaml();
		this.propertyMap = yaml.load(fileInputStream);
	}

	public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
		if (readYamlFiles == null)
			return new ReadYamlFiles(filePath);
		return readYamlFiles;

	}

	/**
	 * this method returns the object key : value pair of our yml object from the
	 * previous method
	 *
	 */

	@SuppressWarnings("rawtypes")
	public HashMap getYamlProperty(String key) {
		return (HashMap) this.propertyMap.get(key);
	}

}
