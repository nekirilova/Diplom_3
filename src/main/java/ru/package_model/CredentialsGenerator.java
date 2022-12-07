package ru.package_model;

import java.util.Random;
//класс для генерации тестовых данных
public class CredentialsGenerator {

    Random random = new Random();

    private String name = "randomname" + random.nextInt(1000); //рандомное имя
    private String email = "randomemail" + random.nextInt(1000) + "@mail.ru"; //рандомный емейл
    private String password = "randompassword" + random.nextInt(1000); //рандомный пароль
    private String incorrectPassword = "" + random.nextInt(1000);//рандомный неправильный пароль

    //геттеры для тестовых данных
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
