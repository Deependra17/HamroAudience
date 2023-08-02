package org.hamropatro.campaignLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ShortMessage {
    public String getClickCreateCampaign() {
        return ClickCreateCampaign;
    }

    public String getClickOnSMS() {
        return ClickOnSMS;
    }

    public String getSelectAudienceTarget() {
        return SelectAudienceTarget;
    }

    public String getSelectUser() {
        return SelectUser;
    }

    public String getClickOnDryRun() {
        return ClickOnDryRun;
    }

    public String getScheduleCampaign() {
        return ScheduleCampaign;
    }

    public String getEnterText() {
        return EnterText;
    }

    public String getCreateSMSCampaign() {
        return CreateSMSCampaign;
    }

    public String getGoTOConfirmPopUp() {
        return GoTOConfirmPopUp;
    }

    public String getClickOnYesButton() {
        return ClickOnYesButton;
    }

    public String getCompareTarget() {
        return CompareTarget;
    }

    public String getCompareStatus() {
        return CompareStatus;
    }

    public String getCompareTitle() {
        return CompareTitle;
    }

    public String getCompareCampaignType() {
        return CompareCampaignType;
    }

    public String getCompareAuthor() {
        return CompareAuthor;
    }

    private String ClickCreateCampaign;
    private String ClickOnSMS;
    private String SelectAudienceTarget;
    private String SelectUser;
    private String ClickOnDryRun;
    private String ScheduleCampaign;
    private String EnterText;
    private String CreateSMSCampaign;
    private String GoTOConfirmPopUp;
    private String ClickOnYesButton;
    private String CompareTarget;
    private String CompareStatus;
    private String CompareTitle;
    private String CompareCampaignType;
    private String CompareAuthor;

    public ShortMessage(){
        try(

                InputStream input = new FileInputStream("src/main/resources/campaign.properties")) {

            java.util.Properties locate = new java.util.Properties();

            locate.load(input);

            this.ClickCreateCampaign = locate.getProperty("ClickCreateCampaign");
            this.ClickOnSMS = locate.getProperty("ClickOnSMS");
            this.SelectAudienceTarget = locate.getProperty("SelectAudienceTarget");
            this.SelectUser = locate.getProperty("SelectUser");
            this.ClickOnDryRun = locate.getProperty("ClickOnDryRun");
            this.ScheduleCampaign = locate.getProperty("ScheduleCampaign");
            this.EnterText = locate.getProperty("EnterText");
            this.CreateSMSCampaign = locate.getProperty("CreateSMSCampaign");
            this.GoTOConfirmPopUp = locate.getProperty("GoTOConfirmPopUp");
            this.ClickOnYesButton = locate.getProperty("ClickOnYesButton");
            this.CompareTarget = locate.getProperty("CompareTarget");
            this.CompareStatus = locate.getProperty("CompareStatus");
            this.CompareTitle = locate.getProperty("CompareTitle");
            this.CompareCampaignType = locate.getProperty("CompareCampaignType");
            this.CompareAuthor = locate.getProperty("CompareAuthor");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
