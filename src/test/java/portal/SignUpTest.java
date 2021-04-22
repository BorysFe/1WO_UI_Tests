package portal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import portalPages.FeedPage;
import utils.DriverNew;

public class SignUpTest extends DriverNew {

    WebDriver driver;
    protected FeedPage feedPage;
    String login;
    String password;

    public SignUpTest(WebDriver driver) {
        super(driver);
        feedPage = new FeedPage(getDriver());
    }

    @BeforeMethod
    public void memberCreds() {
//        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
//        driver = new ChromeDriver();
        driver.get("https://frontend-qa.1worldonline.biz/#!/feed");
        login = "borys1wo@mailinator.com";
        password = "Qwerty123";
    }

    @Test
    public void signUpMember() {
        feedPage.logInMember(login, password);
    }
}
