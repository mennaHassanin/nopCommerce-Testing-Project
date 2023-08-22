package org.example.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver; //to save changes
    @Before
    public void openBrowser() {
        //1-set property
        WebDriverManager.chromedriver().setup();
        //2-create object from WebDriver
        driver = new ChromeDriver();
        //3-configurations
        //3.1- maximization
        driver.manage().window().maximize();
        //3.2-implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        //4- navigate to URL
        driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }
}

