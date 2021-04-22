package utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Getter
public class DriverNew {

    WaitUtils waitUtils;
    public static WebDriver driver;

    @BeforeMethod
    public void webDriver() {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://frontend-qa.1worldonline.biz/#!/feed");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    public DriverNew(WebDriver driver) {
        DriverNew.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
