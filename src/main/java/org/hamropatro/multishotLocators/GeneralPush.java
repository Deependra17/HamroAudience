package org.hamropatro.multishotLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GeneralPush {

    public String getClickOnMultishot() {
        return ClickOnMultishot;
    }

    public String getClickOnCreateMultishot() {
        return ClickOnCreateMultishot;
    }

    public String getClickOnTarget() {
        return ClickOnTarget;
    }

    public String getSelectUserAudience() {
        return SelectUserAudience;
    }

    public String getDryRun() {
        return DryRun;
    }

    public String getMultishotCampaignTitle() {
        return MultishotCampaignTitle;
    }

    public String getSelectLocalTime() {
        return SelectLocalTime;
    }

    public String getDayGap() {
        return DayGap;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public String getEnterNewsTitle() {
        return EnterNewsTitle;
    }

    public String getEnterNewsDescription() {
        return EnterNewsDescription;
    }

    public String getEnterDeeplink() {
        return EnterDeeplink;
    }

    public String getCreateCampaign() {
        return CreateCampaign;
    }

    public String getConfirmationBox() {
        return ConfirmationBox;
    }

    public String getClickYesToCreate() {
        return ClickYesToCreate;
    }

    public String getVerifyTarget() {
        return VerifyTarget;
    }

    public String getVerifyCampaignName() {
        return VerifyCampaignName;
    }

    public String getVerifyTitle() {
        return VerifyTitle;
    }

    public String getVerifyType() {
        return VerifyType;
    }

    public String getVerifyExpireDate() {
        return VerifyExpireDate;
    }

    private String ClickOnMultishot;
    private String ClickOnCreateMultishot;
    private String ClickOnTarget;
    private String SelectUserAudience;
    private String DryRun;
    private String MultishotCampaignTitle;
    private String SelectLocalTime;
    private String DayGap;
    private String ExpireDate;
    private String EnterNewsTitle;
    private String EnterNewsDescription;
    private String EnterDeeplink;
    private String CreateCampaign;
    private String ConfirmationBox;
    private String ClickYesToCreate;
    private String VerifyTarget;
    private String VerifyCampaignName;
    private String VerifyTitle;
    private String VerifyType;
    private String VerifyExpireDate;

    public GeneralPush() {
        try (
                InputStream input = new FileInputStream("src/main/resources/multishot.properties")) {

            Properties locate = new Properties();

            locate.load(input);

            this.ClickOnMultishot=locate.getProperty("ClickOnMultishot");
            this.ClickOnCreateMultishot= locate.getProperty("ClickOnCreateMultishot");
            this.ClickOnTarget=locate.getProperty("ClickOnTarget");
            this.SelectUserAudience=locate.getProperty("SelectUserAudience");
            this.DryRun=locate.getProperty("DryRun");
            this.MultishotCampaignTitle=locate.getProperty("MultishotCampaignTitle");
            this.SelectLocalTime=locate.getProperty("SelectLocalTime");
            this.DayGap= locate.getProperty("DayGap");
            this.ExpireDate=locate.getProperty("ExpireDate");
            this.EnterNewsTitle=locate.getProperty("EnterNewsTitle");
            this.EnterNewsDescription= locate.getProperty("EnterNewsDescription");
            this.EnterDeeplink=locate.getProperty("EnterDeeplink");
            this.CreateCampaign=locate.getProperty("CreateCampaign");
            this.ConfirmationBox=locate.getProperty("ConfirmationBox");
            this.ClickYesToCreate=locate.getProperty("ClickYesToCreate");
            this.VerifyTarget=locate.getProperty("VerifyTarget");
            this.VerifyCampaignName=locate.getProperty("VerifyCampaignName");
            this.VerifyTitle=locate.getProperty("VerifyTitle");
            this.VerifyType=locate.getProperty("VerifyType");
            this.VerifyExpireDate=locate.getProperty("VerifyExpireDate");

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }
}
