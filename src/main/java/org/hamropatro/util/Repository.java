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
    public String getClickOnCreateCampaign(){
        return ClickOnCreateCampaign;
    }
    public String getChooseTarget(){
        return ChooseTarget;
    }
    public String getClickOnSchedule() {
        return ClickOnSchedule;
    }

    public String getCLickOnDryRun() {
        return CLickOnDryRun;
    }

    public String getEnterTitle() {
        return EnterTitle;
    }

    public String getEnterDescription() {
        return EnterDescription;
    }

    public String getEnterDeepLink() {
        return EnterDeepLink;
    }

    public String getClickOnCreateCampaignButton() {
        return ClickOnCreateCampaignButton;
    }

    public String getConfirmPopUp() {
        return ConfirmPopUp;
    }

    public String getClickOnYes() {
        return ClickOnYes;
    }

    public String getTargetName() {
        return TargetName;
    }

    public String getStatus() {
        return Status;
    }

    public String getCampaignTitle() {
        return CampaignTitle;
    }

    public String getCampaignType() {
        return CampaignType;
    }

    public String getAuthor() {
        return Author;
    }
    public String getCreateCampaignButton() {
        return CreateCampaignButton;
    }

    public String getClickOnServiceMessage() {
        return ClickOnServiceMessage;
    }

    public String getSelectTarget() {
        return SelectTarget;
    }

    public String getSelectAudience() {
        return SelectAudience;
    }

    public String getClickOnScheduleSM() {
        return ClickOnScheduleSM;
    }

    public String getCLickOnDryRunSM() {
        return CLickOnDryRunSM;
    }

    public String getEnterSmTitle() {
        return EnterSmTitle;
    }
    public String getEnterSubTitle() {
        return EnterSubTitle;
    }

    public String getChooseMiniApp() {
        return ChooseMiniApp;
    }

    public String getCreateSmCampaign() {
        return CreateSmCampaign;
    }

    public String getChooseConfirmBox() {
        return ChooseConfirmBox;
    }

    public String getClickOnSMYes() {
        return ClickOnSMYes;
    }

    public String getConfirmTarget() {
        return ConfirmTarget;
    }

    public String getConfirmStatus() {
        return ConfirmStatus;
    }

    public String getConfirmTitle() {
        return ConfirmTitle;
    }

    public String getConfirmServiceType() {
        return ConfirmServiceType;
    }

    public String getConfirmAuthor() {
        return ConfirmAuthor;
    }
    private String ContinueWithGoogle;
    private String EnterEmail;
    private String ClickEmailButton;
    private String EnterPassword;
    private String ClickButton;
    private String ClickOnCreateCampaign;
    private String ChooseTarget;
    private String ClickOnSchedule;
    private String CLickOnDryRun;
    private String EnterTitle;
    private String EnterDescription;
    private String EnterDeepLink;
    private String ClickOnCreateCampaignButton;
    private String ConfirmPopUp;
    private String ClickOnYes;
    private String TargetName;
    private String Status;
    private String CampaignTitle;
    private String CampaignType;
    private String Author;
    private String CreateCampaignButton;
    private String ClickOnServiceMessage;
    private String SelectTarget;
    private String SelectAudience;
    private String ClickOnScheduleSM;
    private String CLickOnDryRunSM;
    private String EnterSmTitle;
    private String EnterSubTitle;
    private String ChooseMiniApp;
    private String CreateSmCampaign;
    private String ChooseConfirmBox;
    private String ClickOnSMYes;
    private String ConfirmTarget;
    private String ConfirmStatus;
    private String ConfirmTitle;
    private String ConfirmServiceType;
    private String ConfirmAuthor;


    public Repository(){

        try (
                InputStream input = new FileInputStream("src/main/resources/locator.properties")) {

            java.util.Properties locate = new java.util.Properties();

            locate.load(input);
            this.ContinueWithGoogle = locate.getProperty("ContinueWithGoogle");
            this.EnterEmail = locate.getProperty("EnterEmail");
            this.ClickEmailButton= locate.getProperty("ClickEmailButton");
            this.EnterPassword = locate.getProperty("EnterPassword");
            this.ClickButton = locate.getProperty("ClickButton");
            //GP
            this.ClickOnCreateCampaign = locate.getProperty("ClickOnCreateCampaign");
            this.ChooseTarget=locate.getProperty("ChooseTarget");
            this.ClickOnSchedule = locate.getProperty("ClickOnSchedule");
            this.CLickOnDryRun = locate.getProperty("CLickOnDryRun");
            this.EnterTitle = locate.getProperty("EnterTitle");
            this.EnterDescription = locate.getProperty("EnterDescription");
            this.EnterDeepLink = locate.getProperty("EnterDeepLink");
            this.ClickOnCreateCampaignButton =locate.getProperty("ClickOnCreateCampaignButton");
            this.ConfirmPopUp = locate.getProperty("ConfirmPopUp");
            this.ClickOnYes = locate.getProperty("ClickOnYes");
            this.TargetName = locate.getProperty("TargetName");
            this.Status = locate.getProperty("Status");
            this.CampaignTitle = locate.getProperty("CampaignTitle");
            this.CampaignType = locate.getProperty("CampaignType");
            this.Author = locate.getProperty("Author");
            //SM
            this.CreateCampaignButton=locate.getProperty("CreateCampaignButton");
            this.ClickOnServiceMessage= locate.getProperty("ClickOnServiceMessage");
            this.SelectTarget = locate.getProperty("SelectTarget");
            this.SelectAudience = locate.getProperty("SelectAudience");
            this.ClickOnScheduleSM = locate.getProperty("ClickOnScheduleSM");
            this.CLickOnDryRunSM = locate.getProperty("CLickOnDryRunSM");
            this.EnterSmTitle = locate.getProperty("EnterSmTitle");
            this.EnterSubTitle = locate.getProperty("EnterSubTitle");
            this.ChooseMiniApp = locate.getProperty("ChooseMiniApp");
            this.CreateSmCampaign = locate.getProperty("CreateSmCampaign");
            this.ChooseConfirmBox = locate.getProperty("ChooseConfirmBox");
            this.ClickOnSMYes = locate.getProperty("ClickOnSMYes");
            this.ConfirmTarget = locate.getProperty("ConfirmTarget");
            this.ConfirmStatus = locate.getProperty("ConfirmStatus");
            this.ConfirmTitle = locate.getProperty("ConfirmTitle");
            this.ConfirmServiceType = locate.getProperty("ConfirmServiceType");
            this.ConfirmAuthor = locate.getProperty("ConfirmAuthor");


        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

    }
}
