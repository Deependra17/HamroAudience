package org.hamropatro.campaignLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Login {
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
    private String ClickEmailButton;
    private String EnterPassword;
    private String ClickButton;


    public Login(){

        try (
                InputStream input = new FileInputStream("src/main/resources/campaign.properties")) {

            java.util.Properties locate = new java.util.Properties();

            locate.load(input);
            this.ContinueWithGoogle = locate.getProperty("ContinueWithGoogle");
            this.EnterEmail = locate.getProperty("EnterEmail");
            this.ClickEmailButton= locate.getProperty("ClickEmailButton");
            this.EnterPassword = locate.getProperty("EnterPassword");
            this.ClickButton = locate.getProperty("ClickButton");


        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

    }
}
