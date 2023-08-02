package org.hamropatro.multishotLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Email {

    public Email(){


        try(
                InputStream input = new FileInputStream("src/main/resources/multishot.properties")) {

            java.util.Properties locate = new java.util.Properties();

            locate.load(input);



        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }
}
