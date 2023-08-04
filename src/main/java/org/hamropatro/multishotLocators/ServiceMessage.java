package org.hamropatro.multishotLocators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServiceMessage {
    public String getMultishotButton() {
        return MultishotButton;
    }

    public String getCreateSMCampaign() {
        return CreateSMCampaign;
    }

    public String getChooseServiceMessage() {
        return ChooseServiceMessage;
    }

    public String getSelectUserTag() {
        return SelectUserTag;
    }

    public String getChooseUserAudience() {
        return ChooseUserAudience;
    }

    public String getSetDryRun() {
        return SetDryRun;
    }

    public String getEnterCampaignName() {
        return EnterCampaignName;
    }

    public String getLocalDeliveryOn() {
        return LocalDeliveryOn;
    }

    public String getEnterDaysGap() {
        return EnterDaysGap;
    }

    public String getEnterSUBTitle() {
        return EnterSUBTitle;
    }

    public String getEnterCampaignTitle() {
        return EnterCampaignTitle;
    }

    public String getSelectMiniApp() {
        return SelectMiniApp;
    }

    public String getEnterDetailTitle() {
        return EnterDetailTitle;
    }

    public String getEnterValue() {
        return EnterValue;
    }

    public String getClickOnAddButton() {
        return ClickOnAddButton;
    }

    public String getEnterActionTitle() {
        return EnterActionTitle;
    }

    public String getEnterActionDeeplink() {
        return EnterActionDeeplink;
    }

    public String getClickOnActionAddButton() {
        return ClickOnActionAddButton;
    }

    public String getClickOnCreateButton() {
        return ClickOnCreateButton;
    }

    public String getGoToConfirmationBox() {
        return GoToConfirmationBox;
    }

    public String getClickOnYesToCreate() {
        return ClickOnYesToCreate;
    }

    public String getCompareMultishotTarget() {
        return CompareMultishotTarget;
    }

    public String getCompareMultishotName() {
        return CompareMultishotName;
    }

    public String getCompareMultishotTitle() {
        return CompareMultishotTitle;
    }

    public String getCompareMultishotType() {
        return CompareMultishotType;
    }

    public String getCompareExpireDate() {
        return CompareExpireDate;
    }

    private String MultishotButton;
    private String CreateSMCampaign;
    private String ChooseServiceMessage;
    private String SelectUserTag;
    private String ChooseUserAudience;
    private String SetDryRun;
    private String EnterCampaignName;
    private String LocalDeliveryOn;
    private String EnterDaysGap;
    private String EnterSUBTitle;
    private String EnterCampaignTitle;
    private String SelectMiniApp;
    private String EnterDetailTitle;
    private String EnterValue;
    private String EnterActionTitle;
    private String ClickOnAddButton;
    private String EnterActionDeeplink;
    private String ClickOnActionAddButton;
    private String ClickOnCreateButton;
    private String GoToConfirmationBox;
    private String ClickOnYesToCreate;
    private String CompareMultishotTarget;
    private String CompareMultishotName;
    private String CompareMultishotTitle;
    private String CompareMultishotType;
    private String CompareExpireDate;


    public ServiceMessage(){

        try(
                InputStream input = new FileInputStream("src/main/resources/multishot.properties")) {

            Properties locate = new Properties();

            locate.load(input);
            this.MultishotButton=locate.getProperty("MultishotButton");
            this.CreateSMCampaign= locate.getProperty("CreateSMCampaign");
            this.ChooseServiceMessage=locate.getProperty("ChooseServiceMessage");
            this.SelectUserTag=locate.getProperty("SelectUserTag");
            this.ChooseUserAudience=locate.getProperty("ChooseUserAudience");
            this.SetDryRun=locate.getProperty("SetDryRun");
            this.EnterCampaignName=locate.getProperty("EnterCampaignName");
            this.LocalDeliveryOn=locate.getProperty("LocalDeliveryOn");
            this.EnterDaysGap=locate.getProperty("EnterDaysGap");
            this.EnterSUBTitle=locate.getProperty("EnterSUBTitle");
            this.EnterCampaignTitle=locate.getProperty("EnterCampaignTitle");
            this.SelectMiniApp=locate.getProperty("SelectMiniApp");
            this.EnterDetailTitle=locate.getProperty("EnterDetailTitle");
            this.EnterValue=locate.getProperty("EnterValue");
            this.EnterActionTitle=locate.getProperty("EnterActionTitle");
            this.ClickOnAddButton=locate.getProperty("ClickOnAddButton");
            this.EnterActionDeeplink=locate.getProperty("EnterActionDeeplink");
            this.ClickOnActionAddButton=locate.getProperty("ClickOnActionAddButton");
            this.ClickOnCreateButton=locate.getProperty("ClickOnCreateButton");
            this.GoToConfirmationBox=locate.getProperty("GoToConfirmationBox");
            this.ClickOnYesToCreate=locate.getProperty("ClickOnYesToCreate");
            this.CompareMultishotTarget=locate.getProperty("CompareMultishotTarget");
            this.CompareMultishotName=locate.getProperty("CompareMultishotName");
            this.CompareMultishotTitle=locate.getProperty("CompareMultishotTitle");
            this.CompareMultishotType=locate.getProperty("CompareMultishotType");
            this.CompareExpireDate=locate.getProperty("CompareExpireDate");

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

    }
}
