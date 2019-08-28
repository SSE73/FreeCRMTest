package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;

import static org.openqa.selenium.Keys.HOME;

public class ProductPage extends TestBase {

    @FindBy(xpath = "//legend[contains(text(), 'Product/Service:')]")
    WebElement productPageLabel;

    @FindBy(name = "name")
    WebElement nameProduct;

    @FindBy(name="cost")
    WebElement costProduct;

    @FindBy(name="retail_value")
    WebElement retailValueProduct;

    @FindBy(name="wholesale")
    WebElement wholesalePrice;

    @FindBy(name="sku")
    WebElement skuProduct;

    @FindBy(name="description")
    WebElement descriptionProduct;

    @FindBy(xpath = "//form[@name='productForm']//tr[1]//input[@type='submit' and @value='Save']")
    WebElement buttonSaveProduct;

    public ProductPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductPageLabel(){
        return productPageLabel.isDisplayed();
    }

    public void createNewProduct(String parNameProduct, String parCostProduct, String parRetailValueProduct,
                                 String parWholesalePrice, String parSkuProduct, String parDescriptionProduct){

         nameProduct.sendKeys(parNameProduct);

         costProduct.clear();
         costProduct.sendKeys(parCostProduct);

         retailValueProduct.clear();
         retailValueProduct.sendKeys(parRetailValueProduct);

         wholesalePrice.clear();
         wholesalePrice.sendKeys(parWholesalePrice);

         skuProduct.sendKeys(parSkuProduct);
         descriptionProduct.sendKeys(parDescriptionProduct);

        buttonSaveProduct.click();

    }

    public void editProduct(String parNameProduct, String parCostProduct, String parRetailValueProduct,
                            String parWholesalePrice, String parSkuProduct, String parDescriptionProduct){

        nameProduct.clear();
        nameProduct.sendKeys(parNameProduct);

        costProduct.clear();
        costProduct.sendKeys(parCostProduct);

        retailValueProduct.clear();
        retailValueProduct.sendKeys(parRetailValueProduct);

        wholesalePrice.clear();
        wholesalePrice.sendKeys(parWholesalePrice);

        skuProduct.clear();
        skuProduct.sendKeys(parSkuProduct);

        descriptionProduct.clear();
        descriptionProduct.sendKeys(parDescriptionProduct);

        buttonSaveProduct.click();

    }

}
