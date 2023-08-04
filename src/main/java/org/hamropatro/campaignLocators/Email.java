package org.hamropatro.campaignLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Email {

    public String getCreateButton() {
        return CreateButton;
    }

    public String getClickOnEmail() {
        return ClickOnEmail;
    }

    public String getChooseUserList() {
        return ChooseUserList;
    }

    public String getChooseAudience() {
        return ChooseAudience;
    }

    public String getCLickOnSchedule() {
        return CLickOnSchedule;
    }

    public String getEnterSubject() {
        return EnterSubject;
    }

    public String getClickOnLoadTemplate() {
        return ClickOnLoadTemplate;
    }

    public String getLoadTemplate() {
        return LoadTemplate;
    }

    public String getClickOnCreateEmailCampaignButton() {
        return ClickOnCreateEmailCampaignButton;
    }

    public String getConfirmBox() {
        return ConfirmBox;
    }

    public String getClickYes() {
        return ClickYes;
    }

    public String getCompareTargetAudience() {
        return CompareTargetAudience;
    }

    public String getCompareCampaignTitle() {
        return CompareCampaignTitle;
    }

    public String getCompareEmailCampaignType() {
        return CompareEmailCampaignType;
    }

    public String getCompareCampaignAuthor() {
        return CompareCampaignAuthor;
    }

    private String CreateButton;
    private String ClickOnEmail;
    private String ChooseUserList;
    private String ChooseAudience;
    private String CLickOnSchedule;
    private String EnterSubject;
    private String ClickOnLoadTemplate;
    private String LoadTemplate;
    private String ClickOnCreateEmailCampaignButton;
    private String ConfirmBox;
    private String ClickYes;
    private String CompareTargetAudience;
    private String CompareCampaignTitle;
    private String CompareEmailCampaignType;
    private String CompareCampaignAuthor;

    public  Email(){

        try (
                InputStream input = new FileInputStream("src/main/resources/campaign.properties")) {

            Properties locate = new Properties();

            locate.load(input);
            this.CreateButton = locate.getProperty("CreateButton");
            this.ClickOnEmail = locate.getProperty("ClickOnEmail");
            this.ChooseUserList = locate.getProperty("ChooseUserList");
            this.ChooseAudience = locate.getProperty("ChooseAudience");
            this.CLickOnSchedule = locate.getProperty("CLickOnSchedule");
            this.EnterSubject = locate.getProperty("EnterSubject");
            this.ClickOnLoadTemplate = locate.getProperty("ClickOnLoadTemplate");
            this.LoadTemplate = locate.getProperty("LoadTemplate");
            this.ClickOnCreateEmailCampaignButton = locate.getProperty("ClickOnCreateEmailCampaignButton");
            this.ConfirmBox = locate.getProperty("ConfirmBox");
            this.ClickYes = locate.getProperty("ClickYes");
            this.CompareTargetAudience = locate.getProperty("CompareTargetAudience");
            this.CompareCampaignTitle = locate.getProperty("CompareCampaignTitle");
            this.CompareEmailCampaignType = locate.getProperty("CompareEmailCampaignType");
            this.CompareCampaignAuthor = locate.getProperty("CompareCampaignAuthor");

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }
}
