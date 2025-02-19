package utilities;

import com.github.javafaker.Faker;


public class FakerUtility {

	Faker faker = new Faker();

	public String generateName() {
		return faker.name().fullName();
	}

	public String generateAddress() {
		return faker.address().fullAddress();
	}

	public String generatePhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public String generateCompanyName() {
		return faker.company().toString();
	}

	public String generatePassword() {
		return faker.internet().password(6, 8);
	}

	public String generateCountryName() {
		return faker.country().toString();
	}

	public String generateColor() {
		return faker.color().toString();
	}

	public String generateCurrency() {
		return faker.currency().toString();
	}

	public String generateNumber() {
		return faker.number().toString();
	}

	public String generateEmailAddress() {
		return faker.internet().emailAddress().toString();
	}

}
