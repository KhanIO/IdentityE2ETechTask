package com.webuyanycar.pages;

import com.webuyanycar.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourDetailsPage extends BaseTest {

    @FindBy(xpath = "//input[@id=\"EmailAddress\"]")
    WebElement emailTextBox;

    @FindBy(id = "Postcode")
    WebElement postCodeTextBox;

    @FindBy(id="TelephoneNumber")
    WebElement telephoneNumberTextBox;
    @FindBy(id = "advance-btn")
    WebElement getMyEvaluationBtn;

    @FindBy(xpath = "//button[@id=\"btn-back\"]")
    WebElement notMyCar;

    @FindBy(xpath = "//img[@alt=\"webuyanycar\"]")
    WebElement homePageLogo;


    @FindBy(xpath = "//div[@class=\"d-table-cell value\"][1]")
    WebElement manufacturer;

    @FindBy(xpath = "//div[@class=\"d-table-cell value\"]")
    List<WebElement> vehilceDetails;

    @FindBy(xpath="//div[@class=\"details-vrm ng-star-inserted\"][1]")
    WebElement vehicleRegistration;

    //h1[@class="text-focus ng-star-inserted"]

    @FindBy(xpath = "//h1[@class=\"text-focus ng-star-inserted\"]")
    WebElement errorMsg;

    public YourDetailsPage(){
        PageFactory.initElements(driver, this);

    }

    public String validateTitle() {
        return driver.getTitle();
    }

    public boolean checkEmailIconExists(){
        return emailTextBox.isDisplayed();
    }

    public boolean checkPostCodeIconExists(){
        return postCodeTextBox.isDisplayed();
    }

    public void enterContactDetails(){

        emailTextBox.sendKeys("jam@name.com");

        postCodeTextBox.sendKeys("M71 1UN");

        telephoneNumberTextBox.sendKeys("07000 000000");
    }

    public String checkEmailTextBox(){

        return emailTextBox.getAttribute("value");

    }

    public String checkpostCodeTextBox(){

        return postCodeTextBox.getAttribute("value");

    }


    public String checktelephoneNumberTextBox(){

        return telephoneNumberTextBox.getAttribute("value");

    }

    public String getManufacturer(){
        return vehilceDetails.get(0).getAttribute("innerHTML");
    }
    public String getModel(){

        return vehilceDetails.get(1).getAttribute("innerHTML");
    }

    public String getYear(){
        return vehilceDetails.get(2).getAttribute("innerHTML");
    }

    public String getVehicleRegistration(){
        return vehicleRegistration.getAttribute("innerHTML");

    }

    public String checkForErrorMsg(){

        return errorMsg.getAttribute("value");

    }
    public YourValuationPage getMyValuation(){

        getMyEvaluationBtn.click();
        return new YourValuationPage();

    }
    public HomePage notMyCar(){

        notMyCar.click();
        return new HomePage();

    }

    public HomePage backToHomePage(){
        homePageLogo.click();
        return new HomePage();
    }






}
