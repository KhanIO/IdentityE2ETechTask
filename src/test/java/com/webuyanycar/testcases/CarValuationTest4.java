package com.webuyanycar.testcases;

import com.webuyanycar.base.BaseTest;
import com.webuyanycar.base.Car;
import com.webuyanycar.pages.DetailsPage;
import com.webuyanycar.pages.HomePage;
import com.webuyanycar.util.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CarValuationTest4 extends BaseTest {

    HomePage homePage;
    DetailsPage detailsPage;
    ArrayList<Car> listOfExistingCars = new ArrayList<>();


    public CarValuationTest4() {
        super();

    }

    @BeforeTest
    public void setup() {

        initialisation();
        homePage = new HomePage();
        detailsPage = new DetailsPage();
        listOfExistingCars= TestUtilities.loadExistingCarData("car_output v4.txt");
        listOfExistingCars.remove(0);
    }

     //   Assert.assertEquals("test","test");

    @DataProvider
    public Object[] getInputTestData(){
        ArrayList<String> numberPlates = TestUtilities.readFile("car_input V4.txt","input");
        return numberPlates.toArray();
    }


//    @DataProvider
//    public Object[] getOutputTestData(){
//        ArrayList<String> numberPlates = TestUtilities.readFile("car_output v4.txt","output");
//        return numberPlates.toArray();
//    }

//    @Test(priority = 1,dataProvider="getOutputTestData")
//    public void loadExistingCarData(String data){
//
//        String[] VehicleData = data.split(",");
//        Car car = new Car(VehicleData[0],VehicleData[1],VehicleData[2],VehicleData[3]);
//        listOfExistingCars.add(car);
//        Assert.assertEquals("test","test");
//
//    }

    @Test(priority = 2)
    public void acceptCookiesTest() {
        homePage.acceptCookies();

    }

    @Test(priority = 3)
    public void checkHomePageTitleTest() {
        Assert.assertEquals(homePage.validateTitle(), "Sell your car in under an hour | Buy my car | webuyanycar");
    }

    @Test(priority = 4)
    public void checkBranchLocatorByPostCodeTest() {
        Assert.assertTrue(homePage.checkBranchLocatorByPostCode(), "Can't find branch locator");
    }

    @Test(priority = 5,dataProvider="getInputTestData")
    public void enterDetailsOfCarTest(String vehicleRegistration) {

        homePage.clearVehicleMileageTextBox();
        homePage.clearVehicleRegTextBox();

        homePage.enterCarDetails(vehicleRegistration);
        Assert.assertEquals(homePage.checkCarRegTextBox(), vehicleRegistration.replaceAll("\\s",""));
        homePage.carValuation();



        Assert.assertEquals(detailsPage.getCarRegistration(),vehicleRegistration.replaceAll("\\s",""),"Could not find vehicle");


        for (Car car : listOfExistingCars) {

            if(car.getReg().equals(vehicleRegistration)){
                Assert.assertEquals(detailsPage.getManufacturer(),car.getMake(),"Make is incorrect");
                Assert.assertEquals(detailsPage.getYear(),car.getYear());
                Assert.assertEquals(detailsPage.getModel(),car.getModel());
            }


        }


        detailsPage.notMyCar();



    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }


}
