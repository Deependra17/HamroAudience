package org.hamropatro.multishotLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ShortMessage {

    public String getClickOnMultishotButton() {
        return ClickOnMultishotButton;
    }

    public String getCLickToCampaignButton() {
        return CLickToCampaignButton;
    }

    public String getCLickOnSMS() {
        return CLickOnSMS;
    }

    public String getSelectTargetForSMS() {
        return SelectTargetForSMS;
    }

    public String getSelectUserAudienceForSMS() {
        return SelectUserAudienceForSMS;
    }

    public String getClickOnDRYRun() {
        return ClickOnDRYRun;
    }

    public String getEnterSMSCampaignTitle() {
        return EnterSMSCampaignTitle;
    }

    public String getEnterDayGap() {
        return EnterDayGap;
    }

    public String getEnterSMSText() {
        return EnterSMSText;
    }

    public String getClickOnCreateSMsCampaignButton() {
        return ClickOnCreateSMsCampaignButton;
    }

    public String getToConfirmationBox() {
        return ToConfirmationBox;
    }

    public String getYesToCreateSMSCampaign() {
        return YesToCreateSMSCampaign;
    }

    public String getCampaignTarget() {
        return CampaignTarget;
    }

    public String getCampaignName() {
        return CampaignName;
    }

    public String getCampaignTitle() {
        return CampaignTitle;
    }

    public String getCampaignType() {
        return CampaignType;
    }

    public String getCampaignEndDate() {
        return EndDate;
    }

    private  String ClickOnMultishotButton;
    private String CLickToCampaignButton;
    private String CLickOnSMS;
    private String SelectTargetForSMS;
    private String  SelectUserAudienceForSMS;
    private String ClickOnDRYRun;
    private String  EnterSMSCampaignTitle;
    private String  EnterDayGap;
    private String EnterSMSText;
    private String ClickOnCreateSMsCampaignButton;
    private String ToConfirmationBox;
    private String YesToCreateSMSCampaign;
    private String CampaignTarget;
    private String CampaignName;
    private String CampaignTitle;;
    private String CampaignType;
    private String EndDate;


    public ShortMessage() {


        try (
                InputStream input = new FileInputStream("src/main/resources/multishot.properties")) {

            java.util.Properties locate = new java.util.Properties();

            locate.load(input);
            this.ClickOnMultishotButton=locate.getProperty("ClickOnMultishotButton");
            this.CLickToCampaignButton=locate.getProperty("CLickToCampaignButton");
            this.CLickOnSMS=locate.getProperty("CLickOnSMS");
            this.SelectTargetForSMS=locate.getProperty("SelectTargetForSMS");
            this.SelectUserAudienceForSMS=locate.getProperty("SelectUserAudienceForSMS");
            this.ClickOnDRYRun=locate.getProperty("ClickOnDRYRun");
            this.EnterSMSCampaignTitle=locate.getProperty("EnterSMSCampaignTitle");
            this.EnterDayGap=locate.getProperty("EnterDayGap");
            this.EnterSMSText=locate.getProperty("EnterSMSText");
            this.ClickOnCreateSMsCampaignButton=locate.getProperty("ClickOnCreateSMsCampaignButton");
            this.ToConfirmationBox=locate.getProperty("ToConfirmationBox");
            this.YesToCreateSMSCampaign=locate.getProperty("YesToCreateSMSCampaign");
            this.CampaignTarget=locate.getProperty("CampaignTarget");
            this.CampaignName=locate.getProperty("CampaignName");
            this.CampaignTitle=locate.getProperty("CampaignTitle");
            this.CampaignType=locate.getProperty("CampaignType");
            this.EndDate=locate.getProperty("CampaignEndDate");

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }
}
