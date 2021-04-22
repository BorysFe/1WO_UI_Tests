package portal;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import portalPages.FeedPage;

public class SignUpTest {

    protected FeedPage feedPage;
    String login;
    String password;

    @BeforeMethod
    public void memberCreds() {
        login = "borys1wo@mailinator.com";
        password = "Qwerty123";
    }

    @Test
    public void signUpMember() {
        feedPage.logInMember(login, password);
    }
}
