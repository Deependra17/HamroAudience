package org.hamropatro.campaignLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GeneralPush {
    public String getClickOnCreateCampaign() {
        return ClickOnCreateCampaign;
    }

    public String getChooseTarget() {
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



   public GeneralPush() {

       try (
               InputStream input = new FileInputStream("src/main/resources/campaign.properties")) {

           Properties locate = new Properties();

           locate.load(input);
           this.ClickOnCreateCampaign = locate.getProperty("ClickOnCreateCampaign");
           this.ChooseTarget = locate.getProperty("ChooseTarget");
           this.ClickOnSchedule = locate.getProperty("ClickOnSchedule");
           this.CLickOnDryRun = locate.getProperty("CLickOnDryRun");
           this.EnterTitle = locate.getProperty("EnterTitle");
           this.EnterDescription = locate.getProperty("EnterDescription");
           this.EnterDeepLink = locate.getProperty("EnterDeepLink");
           this.ClickOnCreateCampaignButton = locate.getProperty("ClickOnCreateCampaignButton");
           this.ConfirmPopUp = locate.getProperty("ConfirmPopUp");
           this.ClickOnYes = locate.getProperty("ClickOnYes");
           this.TargetName = locate.getProperty("TargetName");
           this.Status = locate.getProperty("Status");
           this.CampaignTitle = locate.getProperty("CampaignTitle");
           this.CampaignType = locate.getProperty("CampaignType");
           this.Author = locate.getProperty("Author");

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
}
