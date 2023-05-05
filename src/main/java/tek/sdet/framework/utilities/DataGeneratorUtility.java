package tek.sdet.framework.utilities;

import net.datafaker.Faker;

public class DataGeneratorUtility {

	/**
	 * Fake Data Generator utility method
	 */
	public static String data(String input) {
		Faker faker = new Faker();

		String outPut = "";
		if (input.equals("firstName")) {
			outPut = faker.name().firstName().replaceAll("[^a-zA-Z]", "");
		} else if (input.equals("lastName")) {
			outPut = faker.name().lastName().replaceAll("[^a-zA-Z]", "");
		} else if (input.equals("email")) {
			outPut = faker.expression("#{letterify '?????.????@tekschool.us'}");
		} else if (input.equals("phoneNumber")) {
			outPut = faker.phoneNumber().cellPhone();
		} else if (input.equals("fullName")) {
			outPut = faker.name().fullName().replaceAll("[^a-zA-Z]", " ");
		} else if (input.equals("address")) {
			outPut = faker.address().streetAddress().replaceAll("'","");
		} else if (input.equals("city")) {
			outPut = faker.address().city();
		} else if (input.equals("state")) {
			outPut = faker.address().state();
		} else if (input.equals("zipCode")) {
			outPut = faker.address().zipCode();
		} else if (input.equals("cardNumber")) {
			outPut = faker.numerify("4213############");
		} else if (input.equals("ccv")) {
			outPut = faker.numerify("###");
		} else if (input.equals("apt")) {
			outPut = faker.address().buildingNumber();
		}
		return outPut;

	}

	public static void main(String[] args) {
		System.out.println(data("country"));
		System.out.println(data("fullName"));
		System.out.println(data("phoneNumber"));
		System.out.println(data("address"));
		System.out.println(data("apt"));
		System.out.println(data("city"));
		System.out.println(data("state"));
		System.out.println(data("zipCode"));
	}

}
