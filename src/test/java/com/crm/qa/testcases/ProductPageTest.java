package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

public class ProductPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ProductsPage productsPage;
    ProductPage productPage;

    public ProductPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();

        testUtil = new TestUtil();
        productsPage = new ProductsPage();
        productPage = new ProductPage();

        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        productsPage = homePage.clickOnProductsPage();
        productPage = productsPage.clickOnCreateNewProduct();
    }

    @Test(priority = 1)
    public void verifyProductPageLabel(){
        Assert.assertTrue(productPage.verifyProductPageLabel(),"product page label is missing on the page");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
