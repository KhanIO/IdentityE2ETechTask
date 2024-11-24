package com.webuyanycar.pages;

import com.webuyanycar.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DetailsPage extends BaseTest {

    @FindBy(xpath = "//input[@id=\"EmailAddress\"]")
    WebElement emailTextBox;

    @FindBy(id = "Postcode")
    WebElement postCodeTextBox;

    @FindBy(id = "TelephoneNumber")
    WebElement telephoneNumberTextBox;


    @FindBy(xpath = "//button[@id=\"btn-back\"]")
    WebElement backToHomePageBtn;

    @FindBy(xpath = "//img[@alt=\"webuyanycar\"]")
    WebElement homePageLogo;


    @FindBy(xpath = "//div[@class=\"d-table-cell value\"]")
    List<WebElement> carDetails;

    @FindBy(xpath = "//div[@class=\"details-vrm ng-star-inserted\"][1]")
    WebElement carRegistration;

    @FindBy(xpath = "//img[@class=\"logo-full d-none d-sm-block ng-star-inserted\"]")
    WebElement homePageLogoOnError;

    public DetailsPage() {
        PageFactory.initElements(driver, this);

    }

    public String validateTitle() {
        return driver.getTitle();
    }

    public boolean checkEmailIconExists() {
        return emailTextBox.isDisplayed();
    }

    public boolean checkPostCodeIconExists() {
        return postCodeTextBox.isDisplayed();
    }


    public String checkEmailTextBox() {

        return emailTextBox.getAttribute("value");

    }

    public String checkpostCodeTextBox() {

        return postCodeTextBox.getAttribute("value");

    }


    public String checktelephoneNumberTextBox() {

        return telephoneNumberTextBox.getAttribute("value");

    }

    public String getManufacturer() {
        return carDetails.get(0).getAttribute("innerHTML");
    }

    public String getModel() {

        return carDetails.get(1).getAttribute("innerHTML");
    }

    public String getYear() {
        return carDetails.get(2).getAttribute("innerHTML");
    }

    public String getCarRegistration() {
        return carRegistration.getAttribute("innerHTML");

    }

    public String checkForErrorMsg() {

        return homePageLogoOnError.getAttribute("value");

    }

    public HomePage notMyCar() {

        backToHomePageBtn.click();
        return new HomePage();

    }

    public HomePage backToHomePage() {
        homePageLogo.click();
        return new HomePage();
    }


}
