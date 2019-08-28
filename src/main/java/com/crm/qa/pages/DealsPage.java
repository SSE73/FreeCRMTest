package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DealsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(), 'Deals')]")
    WebElement dealsLabel;

    @FindBy(id = "title")
    WebElement title;

    @FindBy(name = "client_lookup")
    WebElement company;

    @FindBy(name = "quantity")
    WebElement quantity;

    @FindBy(xpath = "//input[@type='button' and @value='Set projected total']")
    WebElement buttonSetProjectedTotal;

    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveButton;

    public DealsPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyDealsLabel(){
        return dealsLabel.isDisplayed();
    }

    public void createNewDeal(String parTitle,String parCompany,String product,String parQuantity,String type,String source){

        title.sendKeys(parTitle);
        company.sendKeys(parCompany);

        Select selectProduct = new Select(driver.findElement(By.name("product_id")));
        selectProduct.selectByVisibleText(product);

        quantity.sendKeys(parQuantity);
        buttonSetProjectedTotal.click();

        Select selectType = new Select(driver.findElement(By.name("type")));
        selectType.selectByVisibleText(type);

        Select selectSource = new Select(driver.findElement(By.name("source")));
        selectSource.selectByVisibleText(source);

//        saveButton.click();

    }


}
