package org.hamropatro.multishotLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ShortMessage {

    public ShortMessage() {


        try (
                InputStream input = new FileInputStream("src/main/resources/multishot.properties")) {

            java.util.Properties locate = new java.util.Properties();

            locate.load(input);


        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }
}
