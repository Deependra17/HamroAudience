package org.hamropatro.multishotLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Email {

    public String getClickMultishot() {
        return ClickMultishot;
    }

    public String getClickOnCampaign() {
        return ClickOnCampaign;
    }

    public String getClickOnEmailToCreateEmailCampaign() {
        return ClickOnEmailToCreateEmailCampaign;
    }

    public String getChooseTargetAudience() {
        return ChooseTargetAudience;
    }

    public String getClickDryRun() {
        return ClickDryRun;
    }

    public String getEnterEmailCampaignTitle() {
        return EnterEmailCampaignTitle;
    }

    public String getSetLocalTIme() {
        return SetLocalTIme;
    }

    public String getSetDaysGap() {
        return SetDaysGap;
    }

    public String getEnterCampaignSubject() {
        return EnterCampaignSubject;
    }

    public String getSelectEmailType() {
        return SelectEmailType;
    }

    public String getEnterEmailText() {
        return EnterEmailText;
    }

    public String getClickOnCampaignCreateButton() {
        return ClickOnCampaignCreateButton;
    }

    public String getFindConfirmBox() {
        return FindConfirmBox;
    }

    public String getClickToYes() {
        return ClickToYes;
    }

    public String getVerifyExpectedTarget() {
        return VerifyExpectedTarget;
    }

    public String getVerifyExpectedName() {
        return VerifyExpectedName;
    }

    public String getVerifyExpectedTitle() {
        return VerifyExpectedTitle;
    }

    public String getVerifyExpectedType() {
        return VerifyExpectedType;
    }

    public String getVerifyExpectedExpireDate() {
        return VerifyExpectedExpireDate;
    }

    private String ClickMultishot;
    private String ClickOnCampaign;
    private String ClickOnEmailToCreateEmailCampaign;
    private String ChooseTargetAudience;
    private String ClickDryRun;
    private String EnterEmailCampaignTitle;
    private String SetLocalTIme;
    private String SetDaysGap;
    private String EnterCampaignSubject;
    private String SelectEmailType;
    private String EnterEmailText;
    private String ClickOnCampaignCreateButton;
    private String FindConfirmBox;
    private String ClickToYes;
    private String VerifyExpectedTarget;
    private String VerifyExpectedName;
    private String VerifyExpectedTitle;
    private String VerifyExpectedType;
    private String VerifyExpectedExpireDate;

    public Email(){

        try(
                InputStream input = new FileInputStream("src/main/resources/multishot.properties")) {

            Properties locate = new Properties();

            locate.load(input);

            this.ClickMultishot=locate.getProperty("ClickMultishot");
            this.ClickOnCampaign=locate.getProperty("ClickOnCampaign");
            this.ClickOnEmailToCreateEmailCampaign=locate.getProperty("ClickOnEmailToCreateEmailCampaign");
            this.ChooseTargetAudience=locate.getProperty("ChooseTargetAudience");
            this.ClickDryRun=locate.getProperty("ClickDryRun");
            this.EnterEmailCampaignTitle=locate.getProperty("EnterEmailCampaignTitle");
            this.SetLocalTIme=locate.getProperty("SetLocalTIme");
            this.SetDaysGap=locate.getProperty("SetDaysGap");
            this.EnterCampaignSubject=locate.getProperty("EnterCampaignSubject");
            this.SelectEmailType=locate.getProperty("SelectEmailType");
            this.EnterEmailText=locate.getProperty("EnterEmailText");
            this.ClickOnCampaignCreateButton=locate.getProperty("ClickOnCampaignCreateButton");
            this.FindConfirmBox=locate.getProperty("FindConfirmBox");
            this.ClickToYes=locate.getProperty("ClickToYes");
            this.VerifyExpectedTarget=locate.getProperty("VerifyExpectedTarget");
            this.VerifyExpectedName=locate.getProperty("VerifyExpectedName");
            this.VerifyExpectedTitle=locate.getProperty("VerifyExpectedTitle");
            this.VerifyExpectedType=locate.getProperty("VerifyExpectedType");
            this.VerifyExpectedExpireDate=locate.getProperty("VerifyExpectedExpireDate");

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }
}
