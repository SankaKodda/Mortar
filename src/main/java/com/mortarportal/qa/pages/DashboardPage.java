package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends TestBase {
    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement dashboardLabel;
    // xpath=//h1[contains(.,'DashboardPage')]

    //B&M-SankaXYZ Button to go to dashboard
    @FindBy(css = ".btn.btn-client-dashboard")
    WebElement goToBrandDashboardDirectButton;
    @FindBy(css = ".btn.btn-client-dashboard")
//    @FindBy(css = ".btn.btn-client-dashboard.ng-star-inserted.ng-tns-c198-4")
    WebElement goToSearchedDashboardButton;
    @FindBy(css = "[class='table-space ng-tns-c198-4 ng-star-inserted']")
    WebElement searchedCustomerName;
    @FindBy(css = "tbody [class='ng-tns-c198-4 ng-star-inserted']:nth-of-type(1) " +
            "[class='btn btn-client-dashboard ng-tns-c198-4 ng-star-inserted']")
    WebElement goToSearchedClient;

    @FindBy(id = "search")
    WebElement placeholderSearchClient;

    /*@FindBy(xpath="//button[contains(text(),'Search')]")
    WebElement brandSearchButton;*/
    @FindBy(id = "submitButton")
    WebElement brandSearchButton;
    @FindBy(css = "#submitButton")
    WebElement brandSearchButtonCss;
    @FindBy(id = "dropdownBasic1")
    WebElement dropDownStatusFilterOpenButton;
    @FindBy(css = "[class='p-3 ng-tns-c198-0']")
    WebElement dropDownPanel;
    @FindBy(id = "check-all")
    WebElement selectAllInDropDown;
    @FindBy(id = "check_0")
    WebElement setupRequiredInDropDown;
    @FindBy(id = "check_1")
    WebElement activeInDropDown;
    @FindBy(id = "check_2")
    WebElement inactiveInDropDown;
    @FindBy(css = ".custom__checkboxe:nth-child(1) .check__marked")
    WebElement selectAllInDropDownCheckBox;
    @FindBy(css = ".custom__checkboxe:nth-child(2) .check__marked")
    WebElement setupRequiredDropdownCheckBox;
    @FindBy(css = ".custom__checkboxe:nth-child(3) .check__marked")
    WebElement activeInDropdownCheckBox;
    @FindBy(css = ".custom__checkboxe:nth-child(4) .check__marked")
    WebElement inactiveInDropdownCheckBox;
    @FindBy(css = ".ng-tns-c198-0:nth-child(1) > .table-space")
    WebElement searchedCustomer;
    @FindBy(css = ".ng-star-inserted.pagination-previous")
    WebElement previousButtonOnPagination;
    //    @FindBy(css = ".ng-star-inserted.pagination-next")
//    @FindBy(css = ".ng-star-inserted.pagination-next")
    @FindBy(xpath = "//pagination-controls[@id='listing_users']/pagination-template/ul/li[5]/a")
    WebElement nextButtonOnPagination;
    @FindBy(css = ".disabled.ng-star-inserted.pagination-next")
    WebElement disableNextButtonOnPagination;
    @FindBy(css = ".disabled.ng-star-inserted.pagination-previous")
    WebElement disablePreviousButtonOnPagination;
    @FindBy(xpath = "//span[contains(text(),'3')]")
    WebElement pageNumber3;

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

    public void clickStatusFilter() {
        dropDownStatusFilterOpenButton.click();
    }

    public boolean verifyStatusFilterDropdownIsVisible() {
        return dropDownPanel.isDisplayed();
    }
    public boolean selectAllIsSelected(){
        return selectAllInDropDown.isSelected();
    }
    public boolean setupRequiredIsSelected(){
        return setupRequiredInDropDown.isSelected();
    }
    public boolean activeIsSelected(){
        return activeInDropDown.isSelected();
    }
    public boolean inactiveIsSelected(){
        return inactiveInDropDown.isSelected();
    }
    public void clickOnSelectAllCheckBox(){
        selectAllInDropDownCheckBox.click();
    }
  public void clickOnSetupRequiredCheckbox(){
        setupRequiredDropdownCheckBox.click();
  }
    public void clickOnActiveCheckbox(){
        activeInDropdownCheckBox.click();
    }
    public void clickOnInactiveCheckbox(){
        inactiveInDropdownCheckBox.click();
    }

    public BusinessOverview searchABrandAndGoToBusinessOverview(String brandName) throws InterruptedException {
        placeholderSearchClient.sendKeys(brandName);
        Thread.sleep(5000);
        brandSearchButton.click();
        brandSearchButtonCss.click();
        Thread.sleep(2000);
        goToSearchedDashboardButton.click();
        return new BusinessOverview();
    }

    public String verifySearchedBrand() {
        return searchedCustomerName.getText();
    }

    public String verifySearchedCustomerIsAvailable() {
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

    public void clickOnPreviousButtonOnPagination() {
        previousButtonOnPagination.click();
    }

    public boolean previousButtonStatus() {
        return previousButtonOnPagination.isEnabled();
    }

    public void clickOnNextButtonOnPagination() {
        nextButtonOnPagination.click();
    }

    public boolean verifyPreviousButtonIsDisableInDashboardForFirstTime() {
        return disablePreviousButtonOnPagination.isDisplayed();
    }

    public boolean verifyNextButtonIsDisableInDashboardsLastPage() {
        return disableNextButtonOnPagination.isDisplayed();
    }

    public void goToPageNumber3OnDashboard() {
        pageNumber3.click();
    }

    public void verifyNavigateToAllAvailablePages() throws InterruptedException {
        int pageCount = 1;
        boolean isUnclickable = false;
        while (!isUnclickable) {
            clickOnNextButtonOnPagination();
            try {
                isUnclickable = disableNextButtonOnPagination.isDisplayed();
                pageCount++;
                System.out.println("Page Count = " + pageCount);
                Thread.sleep(1000);
            } catch (Exception ex) {
                isUnclickable = false;
                pageCount++;
                Thread.sleep(1000);
            }
        }
    }
}
