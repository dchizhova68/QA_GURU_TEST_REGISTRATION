package dchizhova68;

import com.github.javafaker.Faker;

import java.util.Locale;
public class TestDataRegistrationForm {
    Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1990, 2023)),
            subjects = faker.options().option("Commerce", "Economics", "History"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("test.png", "test1.png"),
            currentAddres = String.valueOf(faker.address()),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getCityByState(state);

    public String getCityByState(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return state;
        }
    }
}