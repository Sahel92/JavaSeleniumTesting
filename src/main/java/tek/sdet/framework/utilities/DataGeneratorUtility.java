package tek.sdet.framework.utilities;

import net.datafaker.Faker;

public class DataGeneratorUtility {
	public static void main(String[] args) {
		System.out.println(data("firstName"));
		System.out.println(data("lastName"));
		System.out.println(data("email"));
		System.out.println(data("phoneNumber"));
		System.out.println(data("fullName"));
		System.out.println(data("address"));
		System.out.println(data("city"));
		System.out.println(data("state"));
		System.out.println(data("zipCode"));
		System.out.println(data("cardNumber"));
		System.out.println(data("ccv"));
	}
	
	public static String data(String input) {
		Faker faker = new Faker();
		
		String outPut = "";
		if(input.equals("firstName")) {
			outPut = faker.name().firstName().replaceAll("[^a-zA-Z]", "");
		}else if(input.equals("lastName")) {
			outPut = faker.name().lastName().replaceAll("[^a-zA-Z]", "");
		}else if (input.equals("email")) {
			outPut = faker.expression("#{letterify '?????.????@tekschool.us'}");
		}else if(input.equals("phoneNumber")) {
			outPut = faker.phoneNumber().cellPhone();
		}else if(input.equals("fullName")) {
			outPut = faker.name().fullName();
		}else if(input.equals("address")) {
			outPut = faker.address().streetAddress();
		}else if(input.equals("city")) {
			outPut = faker.address().city();
		}else if(input.equals("state")) {
			outPut = faker.address().state();
		}else if(input.equals("zipCode")){
			outPut = faker.address().zipCode();
		}else if(input.equals("cardNumber")) {
			outPut = faker.numerify("4213############");
		}else if(input.equals("ccv")) {
			outPut = faker.numerify("###");
		}
		return outPut;
	
	}
	
	
	
	
}
