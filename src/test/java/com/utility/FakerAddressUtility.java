package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakerAddressUtility {

	public static void main(String[] args) {
		getFakeAddess();
	}

	public static AddressPOJO getFakeAddess() {
		Faker faker = new Faker(Locale.US);
		AddressPOJO addresspojo = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetAddress(), faker.address().city(), "983983", faker.phoneNumber().cellPhone(),
				faker.phoneNumber().cellPhone(), "Hello gafur", "Ghosia Aurai Bhadohi", faker.address().state());
		return addresspojo;
	}
}
