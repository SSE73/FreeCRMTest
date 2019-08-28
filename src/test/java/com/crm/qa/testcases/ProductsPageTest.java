package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ProductPage;
import com.crm.qa.pages.ProductsPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ProductsPage productsPage;
    ProductPage productPage;

    public ProductsPageTest(){
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
    }

    @Test(priority = 1)
    public void verifyProductsPageLabel(){
        Assert.assertTrue(productsPage.verifyProductsLabel());
    }

    @DataProvider(name = "getArrayNameProduct")
    public Object[][] getArrayNameProduct(){
        return new Object[][] {
                {"NameProduct_2","20.01","30.00","","SkuProduct_2","DescriptionProduct_2" },
                {"NameProduct_3","320.03","330.03","","SkuProduct_3","DescriptionProduct_3" },
                {"NameProduct_4","420.04","430.04","","SkuProduct_4","DescriptionProduct_4" },
        };
    }


    @DataProvider(name = "editProductOnProductsPage")
    public Object[][] editProduct() {
        return new Object[][] {
                {"NameProduct_2","EditNameProduct_2","2220.01","3330.02","","EditSkuProduct_2","EditDescriptionProduct_2"},
                {"NameProduct_3","EditNameProduct_3","3320.03","3330.03","","EditSkuProduct_3","EditDescriptionProduct_3"},
                {"NameProduct_4","EditNameProduct_4","4420.04","4430.04","","EditSkuProduct_4","EditDescriptionProduct_4"},
        };
    }

    @DataProvider(name = "deleteProductOnProductsPage")
    public Object[][] deleteProduct() {
        return new Object[][] {
                {"EditNameProduct_2"},
                {"EditNameProduct_3"},
                {"EditNameProduct_4"},
        };
    }


    @Test(priority = 2, dataProvider = "getArrayNameProduct")
    public void validateCreateNewProduct(String parNameProduct, String parCostProduct, String parRetailValueProduct,
                                         String parWholesalePrice, String parSkuProduct, String parDescriptionProduct){
        productPage = productsPage.clickOnCreateNewProduct();
        productPage.createNewProduct(parNameProduct,parCostProduct,parRetailValueProduct,
                parWholesalePrice,parSkuProduct,parDescriptionProduct);

        productsPage = homePage.clickOnProductsPage();
        Assert.assertEquals(productsPage.getNameProductOnProductsPage(parNameProduct), parNameProduct);

    }


    @Test(priority = 3, dataProvider = "editProductOnProductsPage")
    public void verifyEditProductOnProductsPageTest(String parNameProduct,String parEditNameProduct,
                                                    String parEditCostProduct,String parEditRetailValueProduct,
                                                    String parEditWholesalePrice,String parEditSkuProduct,String parEditDescriptionProduct ){
        productPage = productsPage.clickOnEditProduct(parNameProduct);
        productPage.editProduct(parEditNameProduct, parEditCostProduct, parEditRetailValueProduct, parEditWholesalePrice,
                parEditSkuProduct, parEditDescriptionProduct );
        productsPage = homePage.clickOnProductsPage();

        Assert.assertEquals(productsPage.getNameProductOnProductsPage(parEditNameProduct), parEditNameProduct);
        Assert.assertEquals(productsPage.getCostProductOnProductsPage(parEditNameProduct,parEditCostProduct), parEditCostProduct);
        Assert.assertEquals(productsPage.getRetailValueProductOnProductsPage(parEditNameProduct,parEditRetailValueProduct), parEditRetailValueProduct);

    }

    @Test(priority = 4, dataProvider = "deleteProductOnProductsPage")
    public void verifyDeleteProductOnProductsPageTest(String parNameProduct){
        productsPage.deleteProductOnProductsPage(parNameProduct);
        Assert.assertTrue(productsPage.isNameProductPresentOnProductsPage(parNameProduct));
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
