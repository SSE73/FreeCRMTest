package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(), 'Products' )]")
    WebElement productsLabel;

    @FindBy(xpath = "//input[@type='button' and @value = 'New Product']")
    WebElement buttonNewProduct;

    public ProductsPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductsLabel(){
        return productsLabel.isDisplayed();
    }

    public ProductPage clickOnCreateNewProduct(){
        buttonNewProduct.click();
        return new ProductPage();
    }

    public ProductPage clickOnEditProduct(String parNameProduct){
        this.getNameProductOnProductsPage(parNameProduct);
        driver.findElement(By.xpath("//a[text()='"+parNameProduct+"']//following::*[4]/a[2]")).click();
        return new ProductPage();
    }

    public String getCostProductOnProductsPage(String parNameProduct,String parCostProduct){
        this.getNameProductOnProductsPage(parNameProduct);
        return driver.findElement(By.xpath("//a[text()='"+parNameProduct+"']//following::*[2]")).getText().replace(" ","");
    }

    public String getRetailValueProductOnProductsPage(String parNameProduct,String parRetailValueProduct){
        this.getNameProductOnProductsPage(parNameProduct);
        return driver.findElement(By.xpath("//a[text()='"+parNameProduct+"']//following::*[3]")).getText().replace(" ","");
    }

    public String getNameProductOnProductsPage(String parNameProduct){
        return driver.findElement(By.xpath("//a[text()='"+parNameProduct+"']")).getText();
    }

    public boolean isNameProductPresentOnProductsPage(String parNameProduct){
        return driver.findElements(By.xpath("//a[text()='"+parNameProduct+"']")).isEmpty();
    }

    public void deleteProductOnProductsPage(String parNameProduct){
        this.getNameProductOnProductsPage(parNameProduct);
        driver.findElement(By.xpath("//a[text()='"+parNameProduct+"']//following::*[4]/a[3]")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
