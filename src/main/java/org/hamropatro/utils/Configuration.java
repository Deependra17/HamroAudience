package org.hamropatro.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getInvalidEmail() {
        return InvalidEmail;
    }

    public String getInvalidPassword() {
        return InvalidPassword;
    }

    private String url;
    private String email;
    private String password;
    private String InvalidEmail;
    private String InvalidPassword;

    Configuration() {

        try (
                InputStream input = new FileInputStream("src/main/resources/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            this.url = prop.getProperty("url");
            this.email = prop.getProperty("email");
            this.password = prop.getProperty("password");
            this.InvalidEmail = prop.getProperty("InvalidEmail");
            this.InvalidPassword = prop.getProperty("InvalidPassword");
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

    }
}
