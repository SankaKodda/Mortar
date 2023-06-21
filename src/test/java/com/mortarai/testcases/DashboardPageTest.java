package com.mortarai.testcases;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class DashboardPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage, dashboardPage1;
    TestUtil testUtil;
    //    ClientDashboard clientDashboard;
    BusinessOverview businessOverview;

    public DashboardPageTest() {
        super();
    }

    //  Test Case should be Separated -- independent with each other
    //  before each test case -- launch the browser and login
    //  @test -- execute test cases
    //  after each test case -- close the browser
    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        testUtil = new TestUtil();
        businessOverview = new BusinessOverview();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
//        clientDashboard = dashboardPage.clickOnGoToClientDashboard();
    }

    @Test(priority = 1)
    public void verifyDashboardPageTitleTest() {
        String title = dashboardPage.verifyMortarTitle();
        Assert.assertEquals(title, "Web Portal", "Home page Title is not matched");
    }

    @Test(priority = 2)
    public void verifyDashboardTextTest() {
//        testUtil.switchToFrame();
        Assert.assertTrue(dashboardPage.verifyDashboardText());
    }

    @Test(priority = 3)
    public void verifySearchABrandTest() {
//        testUtil.switchToFrame();
//        dashboardPage.searchABrand("B&M-SankaXYZ");
        dashboardPage.searchABrand("B&M-SankaXYZ2");
    }

    @Test(priority = 4)
    public void verifyClickGoToBrandDashboardTest() {
//        testUtil.switchToFrame();
        businessOverview = dashboardPage.clickOnGoToClientsBusinessOverView();
    }

    @Test(priority = 5)
    public void verifySearchABrandAndGoToBrandDashboard() {

        dashboardPage.searchABrand(prop.getProperty("brandName"));
        String searchedUser = dashboardPage.verifySearchedBrand();
        Assert.assertEquals(searchedUser, prop.getProperty("brandName"), "Searched user is displaying wrong");
    }

    @Test(priority = 6)
    public void verifyStatusFilterIsClickable() {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.statusFilterDropdown(), "Status filter is not Opened");
    }

    @Test(priority = 7)
    public void verifyStatusFilterSelectAllIsSelected() {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.selectAllIsSelected(), "Select All is Not Selected");
    }

    @Test(priority = 8)
    public void verifyStatusFilterSetupRequiredIsSelected() {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.setupRequiredIsSelected(), "Setup Required is Not Selected");
    }

    @Test(priority = 9)
    public void verifyStatusFilterActiveIsSelected() {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.activeIsSelected(), "Active is Not Selected");
    }

    @Test(priority = 10)
    public void verifyStatusFilterInactiveIsSelected() {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.inactiveIsSelected(), "Inactive is Not Selected");
    }

    @Test(priority = 11)
    public void verifyStatusFilterSelectAllTheSelectAllValues() throws InterruptedException {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.selectAllIsSelected(), "Select All is Not Selected");
        boolean selectAllStatus = dashboardPage.selectAllIsSelected();
        if (selectAllStatus){
            Assert.assertTrue(dashboardPage.setupRequiredIsSelected(), "Setup Required is Not Selected");
            Assert.assertTrue(dashboardPage.activeIsSelected(), "Active is Not Selected");
            Thread.sleep(2000);
            Assert.assertTrue(dashboardPage.inactiveIsSelected(), "Inactive is Not Selected");
        }
    }
    @Test(priority = 12)
    public void verifyStatusFilterSelectAllDeselect() throws InterruptedException {
        dashboardPage.clickStatusFilter();
        boolean selectAllStatus = dashboardPage.selectAllIsSelected();
        Thread.sleep(2000);
        if(selectAllStatus){
            dashboardPage.clickOnSelectAllCheckBox();
            Thread.sleep(2000);
            Assert.assertFalse(dashboardPage.selectAllIsSelected(),"Successfully Deselected the Select All CheckBox");
            Assert.assertFalse(dashboardPage.setupRequiredIsSelected(), "Successfully Deselected the Setup Required CheckBox");
            Assert.assertFalse(dashboardPage.activeIsSelected(), "Successfully Deselected the Active Checkbox");
            Assert.assertFalse(dashboardPage.inactiveIsSelected(), "Successfully Deselected the Inactive Checkbox");
        }
    }


    @Test(priority = 12)
    public void verifyClickAddClient() {

    }

//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }
}
