package com.webuyanycar.pages;

import com.webuyanycar.base.BaseTest;
import com.webuyanycar.util.TestUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    @FindBy(name = "vehicleReg")
    WebElement carRegTextBox;

    @FindBy(id = "Mileage")
    WebElement carMileageTextBox;
    @FindBy(id = "btn-go")
    WebElement getMyCarValuationBtn;

    @FindBy(id = "txtFindBranchesFooter-input")
    WebElement branchLocatorByPostCode;

    @FindBy(how = How.ID, id = "onetrust-accept-btn-handler")
    WebElement acceptCookiesBtn;


    public HomePage() {

        PageFactory.initElements(driver, this);

    }


    public String validateTitle() {
        return driver.getTitle();
    }

    public boolean checkBranchLocatorByPostCode() {
        return branchLocatorByPostCode.isDisplayed();
    }

    public HomePage acceptCookies() {

        acceptCookiesBtn.click();
        return new HomePage();
    }

    public void enterCarDetails(String vehicleRegistration) {

        carRegTextBox.sendKeys(vehicleRegistration);
        carMileageTextBox.sendKeys(TestUtilities.randomMileage(50000, 250000));


    }

    public String checkCarRegTextBox() {
        return carRegTextBox.getAttribute("value");
    }

    public void clearVehicleRegTextBox() {
        carRegTextBox.clear();
    }

    public void clearVehicleMileageTextBox() {
        carMileageTextBox.clear();

    }


    public DetailsPage carValuation() {

        getMyCarValuationBtn.click();
        return new DetailsPage();

    }


}
