package org.hamropatro.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ServiceMessage {
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

    public ServiceMessage(){
    try(

        InputStream input = new FileInputStream("src/main/resources/locator.properties")) {

            java.util.Properties locate = new java.util.Properties();

            locate.load(input);
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

        } catch (IOException e) {
        throw new RuntimeException(e);
        }
    }
}
