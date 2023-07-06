package org.hamropatro.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
    private String url;
    private String email;
    private String password;

    Configuration() {

        try (
                InputStream input = new FileInputStream("src/main/resources/config.properties")) {

            java.util.Properties prop = new java.util.Properties();

            // load a properties file
            prop.load(input);
            this.url = prop.getProperty("url");
            this.email = prop.getProperty("email");
            this.password = prop.getProperty("password");
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

    }
}
