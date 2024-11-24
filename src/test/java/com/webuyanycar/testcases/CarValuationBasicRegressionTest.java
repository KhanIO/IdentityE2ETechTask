package com.webuyanycar.testcases;

import com.webuyanycar.base.BaseTest;
import com.webuyanycar.pages.DetailsPage;
import com.webuyanycar.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CarValuationBasicRegressionTest extends BaseTest {

    HomePage homePage;
    DetailsPage detailsPage;



    public CarValuationBasicRegressionTest() {
        super();

    }

    @BeforeTest
    public void setup() {

        initialisation();
        homePage = new HomePage();
        detailsPage = new DetailsPage();

    }

    @Test(priority = 1)
    public void acceptCookiesTest() {
        homePage.acceptCookies();

    }


    @Test(priority = 2)
    public void checkHomePageTitleTest() {
        Assert.assertEquals(homePage.validateTitle(), "Sell your car in under an hour | Buy my car | webuyanycar");
    }

    @Test(priority = 3)
    public void checkBranchLocatorByPostCodeTest() {
        Assert.assertTrue(homePage.checkBranchLocatorByPostCode(), "Can't find branch locator");
    }


    @Test(priority = 4)
    public void enterDetailsOfCarTest() {
        homePage.enterCarDetails("AD58VNF");
        Assert.assertEquals(homePage.checkCarRegTextBox(), "AD58VNF");
        homePage.carValuation();



    }

    @Test(priority = 5)
    public void checkVehicleRegistrationTest() {
        Assert.assertEquals(detailsPage.getCarRegistration(),"AD58VNF");
    }

    @Test(priority = 6)
    public void checkVehicleManufacturerTest() {

        Assert.assertEquals(detailsPage.getManufacturer(),"BMW");
    }

    @Test(priority = 7)
    public void checkVehicleYearTest() {
        Assert.assertEquals(detailsPage.getYear(),"2008");
    }



    @Test(priority = 8)
    public void checkModelTest() {
        Assert.assertEquals(detailsPage.getModel(),"1 SERIES DIESEL COUPE - 120d M Sport 2dr");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }


}
