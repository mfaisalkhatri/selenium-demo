package io.github.mfaisalkhatri.seleniumgridjenkins.testdata;

import net.datafaker.Faker;

public class RegistrationDataBuilder {

    public static RegistrationData getRegistrationData () {
        final Faker faker = new Faker ();
        final String password = "Pass@123";
        final String securityQuestion = "Your favorite book?";
        final String securityAnswer = "Agile Testing";
        return RegistrationData.builder ()
            .email (faker.internet ()
                .emailAddress ())
            .password (password)
            .securityQuestion (securityQuestion)
            .securityAnswer (securityAnswer)
            .build ();
    }
}