package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends TestBase {
    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement dashboardLabel;
    // xpath=//h1[contains(.,'DashboardPage')]

    //B&M-SankaXYZ Button to go to dashboard
    @FindBy(xpath = "//tr[4]/td[3]/button")
    WebElement goToBrandDashboardDirectButton;
    @FindBy(xpath = "/html/body/app-root/app-admin-layout-sidebar-large/div/div[2]/app-managers-default/div/div[3]/div/" +
            "div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr/td[3]/button")
    WebElement goToSearchedDashboardButton;
    @FindBy(xpath = "/html/body/app-root/app-admin-layout-sidebar-large/div/div[2]/app-managers-default/div/div[3]" +
            "/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[1]/td[1]")
    WebElement searchedCustomer;
    @FindBy(xpath = "//tr[1]/td[3]/button")
    WebElement goToSearchedClient;

    @FindBy(id = "search")
    WebElement placeholderSearchClient;

    /*@FindBy(xpath="//button[contains(text(),'Search')]")
    WebElement brandSearchButton;*/
    @FindBy(id = "submitButton")
    WebElement brandSearchButton;
    @FindBy(id = "dropdownBasic1")
    WebElement dropDownStatusFilter;
    @FindBy(id = "check-all")
    WebElement selectAllInDropDown;
    @FindBy(id = "check_0")
    WebElement setupRequiredInDropDown;
    @FindBy(id = "check_1")
    WebElement activeInDopDown;
    @FindBy(id = "check_2")
    WebElement inactiveInDropDown;
    /**
     * Validate Checkbox isSelected method and click

    WebElement checkBoxElement = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
    boolean isSelected = checkBoxElement.isSelected();

//performing click operation if element is not checked
if(isSelected == false) {
        checkBoxElement.click();
    }*/

    //Initializing the Page Objects;
    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyMortarTitle() {
        return driver.getTitle();
    }

    public boolean verifyDashboardText() {
        return dashboardLabel.isDisplayed();
    }

    /*public void searchABrand(String brandName){
         placeholderSearchClient.sendKeys(brandName);
        brandSearchButton.click();
    }*/
    public void searchABrand(String brandName) {
        placeholderSearchClient.sendKeys(brandName);
        brandSearchButton.click();
    }

    public void statusDropDownClick() {
        dropDownStatusFilter.click();
    }
    public boolean selectAllIsSelected(){
        return selectAllInDropDown.isSelected();
    }
    public boolean setupRequiredIsSelected(){
        return setupRequiredInDropDown.isSelected();
    }
    public boolean activeIsSelected(){
        return activeInDopDown.isSelected();
    }
    public boolean inactiveIsSelected(){
        return inactiveInDropDown.isSelected();
    }

    public BusinessOverview searchABrandAndGoToBusinessOverview(String brandName) {
        placeholderSearchClient.sendKeys(brandName);
        brandSearchButton.click();
        goToSearchedDashboardButton.click();
        return new BusinessOverview();
    }

    public String verifySearchedBrand() {
        return searchedCustomer.getText();
    }

    public DashboardPage enterSearchedBrand() {
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
        return this;
    }

    public void clickBrandSearchButton() {
        driver.findElement(By.id("submitButton")).click();
    }


    public BusinessOverview clickOnGoToClientsBusinessOverView() {
        goToBrandDashboardDirectButton.click();
        return new BusinessOverview();
    }

    public BusinessOverview clickOnGoToSearchedClientDashboard() {
        goToSearchedClient.click();
        return new BusinessOverview();
    }
}
