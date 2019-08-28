package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'User: Sergey Sysylyatin')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(), 'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(), 'New Contact')]")
    WebElement newContactLink;

    @FindBy(xpath = "//a[contains(text(), 'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(), 'New Deal')]")
    WebElement newDealLink;

    @FindBy(xpath = "//a[contains(text(), 'Tasks')]")
    WebElement tasksLink;

    @FindBy (xpath = "//div[@id='navMenu']//a[contains(text(),'Products')]")
    WebElement productsLink;

    //Initializing the Paje Objects:
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }

    public ProductsPage clickOnProductsPage(){
        productsLink.click();
        return new ProductsPage();
    }

    public void onClickNewCotactLink() {
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();

        newContactLink.click();
    }

    public void onClickNewDealLink(){
        Actions action = new Actions(driver);
        action.moveToElement(dealsLink).build().perform();

        newDealLink.click();
    }

}
