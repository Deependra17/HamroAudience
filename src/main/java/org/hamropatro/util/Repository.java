package org.hamropatro.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Repository {
    public String getContinueWithGoogle() {
        return ContinueWithGoogle;
    }
    public String getEnterEmail(){
        return EnterEmail;
    }
    public String getClickEmailButton(){
        return ClickEmailButton;
    }
    public   String getEnterPassword(){
        return EnterPassword;
    }
    public  String getClickButton(){
        return ClickButton;
    }
    private String ContinueWithGoogle;
    private String EnterEmail;
    private  String ClickEmailButton;
    private String EnterPassword;
    private String ClickButton;

    Repository(){

        try (
                InputStream input = new FileInputStream("src/main/resources/repo.properties")) {

            java.util.Properties prop = new java.util.Properties();

            prop.load(input);
            this.ContinueWithGoogle = prop.getProperty("ContinueWithGoogle");
            this.EnterEmail = prop.getProperty("EnterEmail");
            this.ClickEmailButton= prop.getProperty("ClickEmailButton");
            this.EnterPassword = prop.getProperty("EnterPassword");
            this.ClickButton = prop.getProperty("ClickButton");
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

    }
}
