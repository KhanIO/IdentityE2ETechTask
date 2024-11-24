package com.webuyanycar.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.webuyanycar.util.TestUtilities.IMPLICIT_WAIT;
import static com.webuyanycar.util.TestUtilities.PAGE_LOAD_TIMEOUT;

public class BaseTest {


    public static WebDriver driver;
    public static Properties prop;

    public BaseTest() {
        //initialise
        try {

            prop = new Properties();
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") +"/src/main/java/com/webuyanycar/config/config.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void initialisation() {
        String browserName = prop.getProperty("Browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") +"/src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));



        }


    }}

