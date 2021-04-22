package portalPages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import portalPages.enums.SignInUpLinks;
import utils.WaitUtils;

@Getter
public class FeedPage extends BasePage {

    WebDriver driver;
    WaitUtils waitUtils;

    private final String inputElement = ".//input[@id='%s']";

    @FindBy(xpath = ".//span[@id='login']")
    private WebElement signInRegButton;

    public FeedPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    @BeforeClass
    public FeedPage openLoginWindow() {
        driver.get("https://frontend-qa.1worldonline.biz/#!/feed");
        waitUtils.waitVisibilityOfElementShort(signInRegButton);
        signInRegButton.click();
        return this;
    }

    public void logInMember(String logIn, String password) {
//        openLoginWindow();
//        waitUtils.waitForElementToBeClickableAfterMiddleWait(driver.findElement(By.xpath(String.format(inputElement, element))));
        waitUtils.waitVisibilityOfElementByShort(By.xpath(String.format(inputElement, SignInUpLinks.SIGN_IN_LOGIN_FIELD)));
        driver.findElement(By.xpath(String.format(inputElement, SignInUpLinks.SIGN_IN_LOGIN_FIELD))).sendKeys(logIn);
        waitUtils.waitVisibilityOfElementByShort(By.xpath(String.format(inputElement, SignInUpLinks.SIGN_IN_PASSWORD_FIELD)));
        driver.findElement(By.xpath(String.format(inputElement, SignInUpLinks.SIGN_IN_PASSWORD_FIELD))).sendKeys(password);
        waitUtils.waitVisibilityOfElementByShort(By.xpath(String.format(inputElement, SignInUpLinks.SIGN_IN_SIGN_IN_BUTTON)));
    }

    public void registrationMember(String newLogIn, String newPassword) {
        openLoginWindow();
        waitUtils.clickWhenReadyAfterShortWait(By.xpath(String.format(inputElement, SignInUpLinks.SIGN_IN_CREATE_ACCOUNT_BUTTON)));
        waitUtils.waitVisibilityOfElementByShort(By.xpath(String.format(inputElement, SignInUpLinks.SIGN_IN_LOGIN_FIELD)));
        waitUtils.waitPresenceOfElementByShort(By.xpath(String.format(inputElement, SignInUpLinks.REGISTRATION_EMAIL_FIELD)));
        driver.findElement(By.xpath(String.format(inputElement, SignInUpLinks.REGISTRATION_EMAIL_FIELD))).sendKeys(newLogIn);
        waitUtils.waitVisibilityOfElementByShort(By.xpath(String.format(inputElement, SignInUpLinks.REGISTRATION_PASSWORD_FIELD)));
        driver.findElement(By.xpath(String.format(inputElement, SignInUpLinks.REGISTRATION_PASSWORD_FIELD))).sendKeys(newPassword);
        waitUtils.clickWhenReadyAfterShortWait(By.xpath(String.format(inputElement, SignInUpLinks.REGISTRATION_SUBMIT_BUTTON)));
    }
}
