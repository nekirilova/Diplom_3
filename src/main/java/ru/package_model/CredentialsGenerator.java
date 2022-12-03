package ru.package_model;

import java.util.Random;

public class CredentialsGenerator {

    Random random = new Random();

    private String name = "randomname" + random.nextInt(1000);
    private String email = "randomemail" + random.nextInt(1000) + "@mail.ru";
    private String password = "randompassword" + random.nextInt(1000);
    private String incorrectPassword = "" + random.nextInt(1000);
    public String getRandomName() {
        return this.name;
    }

    public String getRandomEmail() {
        return this.email;
    }

    public String getRandomPassword() {
        return this.password;
    }

    public String getIncorrectPassword() {
        return this.incorrectPassword;
    }
}
