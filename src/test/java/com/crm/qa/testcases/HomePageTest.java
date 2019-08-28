package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    ProductsPage productsPage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        dealsPage = new DealsPage();
        productsPage = new ProductsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitle(){
        Assert.assertEquals(homePage.verifyHomePageTitle(), "CRMPRO", "Home page title not matches");
    }

    @Test(priority = 2)
    public void verifyCorrectUserNameTest(){
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority = 4)
    public void verifyDealsLinkTest(){
        testUtil.switchToFrame();
        dealsPage = homePage.clickOnDealsLink();
    }

    @Test(priority = 5)
    public void verifyProductsLinkTest(){
        testUtil.switchToFrame();
        productsPage = homePage.clickOnProductsPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
