package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.DigitalMediaBuyingPages.CampaignReportingPage;
import com.mortarportal.qa.pages.DigitalMediaBuyingPages.CreatNewCampaignPage;
import com.mortarportal.qa.pages.EmailsAndJourneysPages.EmailsAndJourney.SingleMailingPage;
import com.mortarportal.qa.pages.EmailsAndJourneysPages.Klaviyo;
import com.mortarportal.qa.pages.Integrations.Integrations;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.FacebookAdvertisingPage;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.GoogleAnalyticsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends TestBase {
    @FindBy(css = ".navigation-left")
    WebElement navigationBarElement;
    //Nav BAr
    @FindBy(css = ".navigation-left li:nth-of-type(1)")
    WebElement navBusinessOverviewLink;

    //Ai Analytics From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(2)")
    WebElement navAiAnalyticsLink;

    //My Customer From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(3)")
    WebElement navMyCustomersLink;

    //Integration From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(4)")
    WebElement navIntegrationsLink;
    //Emails & Journeys From Nav Bar
    @FindBy(css = ".navigation-left .lvl1:nth-of-type(5)")
    WebElement navEmailsAndJourneyLink;
    @FindBy(css = ".childNav .nav-item.ng-star-inserted:nth-of-type(1)")
    WebElement emailsAndJourneyPageSingleMailingLink;
    @FindBy(css = ".childNav .nav-item.ng-star-inserted:nth-of-type(2)")
    WebElement klaviyoPageLink;
    //Social & Display Advertising From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(6)")
    WebElement navSocialDisplayAdvertisingLink;
    @FindBy(css = ".childNav .nav-item.ng-star-inserted:nth-of-type(1)")
    WebElement facebookAdvertisingDashboardPageLink;
    @FindBy(css = ".childNav .nav-item.ng-star-inserted:nth-of-type(2)")
    WebElement googleAnalyticsDashboardPageLink;
    //Digital Media Buying From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(7)")
    WebElement navDigitalMediaBuyingLink;
    @FindBy(css = "li:nth-of-type(1) > .ng-star-inserted > .item-name.lvl1")
    WebElement campaignReportingPageLink;
    @FindBy(css = ".childNav .ng-star-inserted:nth-of-type(2) .item-name")
    WebElement campaignCreatingPageLink;

    //My Creatives From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(8)")
    WebElement navMyCreativesLink;

    public NavigationBar() {
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this);
    }

    public boolean verifyNavigationBarIsAvailable() {
        return navigationBarElement.isDisplayed();
    }

    public BusinessOverview clickOnGoToBusinessOverview() {
        navBusinessOverviewLink.click();
        return new BusinessOverview();
    }

    public CustomerChurnPredictionAIAnalytics clickOnGoToCustomerChurnPredictionAIAnalytics() {
        navAiAnalyticsLink.click();
        return new CustomerChurnPredictionAIAnalytics();
    }

    public MyCustomer clickOnGoToMyCustomer() {
        navMyCustomersLink.click();
        return new MyCustomer();
    }

    public Integrations clickOnGoToIntegrations() {
        navIntegrationsLink.click();
        return new Integrations();
    }

    public void clickOnOpenSubMenuEmailsAndJourneys() {
        navEmailsAndJourneyLink.click();
    }

    public SingleMailingPage clickOnGoToSingleMailingInEmailsAndJourneyPage() {
        emailsAndJourneyPageSingleMailingLink.click();
        return new SingleMailingPage();
    }

    public Klaviyo clickOnGoToKlaviyoDashboardPage() {
        klaviyoPageLink.click();
        return new Klaviyo();
    }

    public void clickOnOpenSubMenuNavSocialDisplayAdvertising() {
        navSocialDisplayAdvertisingLink.click();
    }
    public FacebookAdvertisingPage clickOnGoToFacebookAdvertisingPage() {
        navSocialDisplayAdvertisingLink.click();
        facebookAdvertisingDashboardPageLink.click();
        return new FacebookAdvertisingPage();
    }

    public GoogleAnalyticsPage clickOnGoToGoogleAnalyticsReportingPage() {
        navSocialDisplayAdvertisingLink.click();
        googleAnalyticsDashboardPageLink.click();
        return new GoogleAnalyticsPage();
    }

    public void clickOnToOpenSubNavDigitalMediaBuying() {
        navDigitalMediaBuyingLink.click();
    }

    public CampaignReportingPage clickOnGoToCampaignReportingPage() {
        navDigitalMediaBuyingLink.click();
        campaignReportingPageLink.click();
        return new CampaignReportingPage();
    }

    public CreatNewCampaignPage clickOnGoToCreatNewCampaignPage() {
        navDigitalMediaBuyingLink.click();
        campaignCreatingPageLink.click();
        return new CreatNewCampaignPage();
    }

    public MyCreatives clickOnGoToMyCreatives() {
        navMyCreativesLink.click();
        return new MyCreatives();
    }
}
